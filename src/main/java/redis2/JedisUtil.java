package redis2;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import thrift.weixin.DateUtil;
import utils.DateUtils;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JedisUtil {

    private static RedisConfig redisConfig = ReadJson.getRedisConfig();


    protected Logger log = Logger.getLogger(this.getClass().getName());

    /**
     * 私有构造器.
     */
    private JedisUtil() {

    }

    private static Map<String, JedisPool> maps = new HashMap<String, JedisPool>();


    /**
     * 获取连接池.
     *
     * @return 连接池实例
     */
    private static synchronized JedisPool getPool(String ip, int port) {
        String key = ip + ":" + port;
        JedisPool pool = null;
        if (!maps.containsKey(key)) {
            JedisPoolConfig config = new JedisPoolConfig();

            config.setMaxIdle(redisConfig.getPoolMaxIdle());
            config.setMaxWaitMillis(redisConfig.getPoolMaxWaite());
            config.setTestOnBorrow(true);
            config.setTestOnReturn(true);
            try {
                /**
                 *如果你遇到 java.net.SocketTimeoutException: Read timed out exception的异常信息
                 *请尝试在构造JedisPool的时候设置自己的超时值. JedisPool默认的超时时间是2秒(单位毫秒)
                 */
                if (redisConfig.Password.length() == 0) {
                    pool = new JedisPool(config, ip, port, redisConfig.Timeout);
                } else {
                    pool = new JedisPool(config, ip, port, redisConfig.Timeout, redisConfig.Password);
                }
                maps.put(key, pool);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            pool = maps.get(key);
        }
        return pool;
    }

    /**
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例
     * 没有绑定关系，而且只有被调用到时才会装载，从而实现了延迟加载。
     */
    private static class RedisUtilHolder {
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static JedisUtil instance = new JedisUtil();
    }

    /**
     * 当getInstance方法第一次被调用的时候，它第一次读取
     * RedisUtilHolder.instance，导致RedisUtilHolder类得到初始化；而这个类在装载并被初始化的时候，会初始化它的静
     * 态域，从而创建RedisUtil的实例，由于是静态的域，因此只会在虚拟机装载类的时候初始化一次，并由虚拟机来保证它的线程安全性。
     * 这个模式的优势在于，getInstance方法并没有被同步，并且只是执行一个域的访问，因此延迟初始化并没有增加任何访问成本。
     */
    public static JedisUtil getInstance() {
        return RedisUtilHolder.instance;
    }

    /**
     * 获取Redis实例.
     *
     * @return Redis工具类实例
     */
    public synchronized Jedis getJedis(String ip, int port) {
        Jedis jedis = null;
        int count = 0;
        do {
            try {
                jedis = getPool(ip, port).getResource();
                //log.info("get redis master1!");
            } catch (Exception e) {
                log.error("get redis master1 failed!", e);
                // 销毁对象
                getPool(ip, port).destroy();
            }
            count++;
        } while (jedis == null && count < redisConfig.getRetryNum());
        return jedis;
    }



    public static void main(String[] args) {
        String ip = JedisUtil.redisConfig.RedisServerIP;
        int port = JedisUtil.redisConfig.RedisServerPort;
        Jedis jedis = JedisUtil.getInstance().getJedis(ip, port);

//        jedis.set("company","landleaf");
//
//        System.out.println(jedis.get("company"));


        DeviceBean deviceBean = new DeviceBean();

        deviceBean.setDeviceId("aa:aa:aa:aa");
        deviceBean.setVersion("2");
        deviceBean.setState("在线");
        deviceBean.setDescription("测试对象");
        deviceBean.setCt(DateUtils.getNowTime());
        deviceBean.setUt(DateUtils.getNowTime());


        String json = JSON.toJSONString(deviceBean);

        String key = "uponline_table";

        jedis.hset(key,"uponline+1",json);


        System.out.println(jedis.hget(key,"uponline+1"));


//        System.out.println(JedisUtil.getInstance().getClass().getName());

        


    }


}
