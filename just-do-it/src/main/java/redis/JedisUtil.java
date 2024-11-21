package redis;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import mariadb.FileUtils;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis2.PathUtil;
import redis2.RedisConfig;

import java.util.HashMap;
import java.util.Map;

public class JedisUtil {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    public static RedisConfig redisConfig;

    private JedisUtil() {
        //当前工程的绝对路径
        String ParentPath = PathUtil.getAbsProjectPath();
        // 读取配置文件参数
        String filePath = ParentPath + "/config/RedisConfig.js";
        System.out.println("读取RedisConfig配置文件：" + filePath);

        String fileContent = FileUtils.readFileByLines(filePath);
        System.out.println("RedisConfig参数：" + fileContent);

        // json格式转换为javaBean
        Gson gson = new Gson();
        redisConfig = gson.fromJson(fileContent, new TypeToken<RedisConfig>() {
        }.getType());

    }

    private static class RedisUtilHolder {
        private static final JedisUtil instance = new JedisUtil();
    }

    public static JedisUtil getInstance() {
        return RedisUtilHolder.instance;
    }

    private static Map<String, JedisPool> maps = new HashMap<String, JedisPool>();

    public synchronized static JedisPool getPool(String ip, int port) {
        String key = ip + ":" + port;
        JedisPool pool = null;
        if (!maps.containsKey(key)) {
            JedisPoolConfig config = new JedisPoolConfig();

            config.setMaxIdle(redisConfig.PoolMaxIdle);
            config.setTestOnBorrow(true);
            config.setTestOnReturn(true);
            if (redisConfig.Password.length() == 0) {
                pool = new JedisPool(config, ip, port, redisConfig.Timeout);
            } else {
                pool = new JedisPool(config, ip, port, redisConfig.Timeout, redisConfig.Password);
            }
            maps.put(key, pool);
        } else {
            pool = maps.get(key);
        }
        return pool;
    }

    private static void distoryPoolMap(String ip, int port) {

        String key = ip + ":" + port;
        maps.remove(key);
    }

    public synchronized Jedis getJedis(String ip, int port) {
        Jedis jedis = null;
        int count = 0;
        do {
            try {
                jedis = getPool(ip, port).getResource();
            } catch (Exception e) {
                logger.error("get redis master1 failed!", e);
                // getPool(ip,port).returnBrokenResource(jedis);
                getPool(ip, port).destroy();
            }
        }
        while (jedis == null && count < redisConfig.RetryNum);
        return jedis;
    }


    public void closePool(String ip, int port) {
        JedisPool pool = getPool(ip, port);
        if (pool != null) {
            pool.close();
        }
    }


}