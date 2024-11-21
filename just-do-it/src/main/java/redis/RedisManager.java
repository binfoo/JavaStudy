package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis2.RedisConfig;

/**
 * Created by ZhangHongbin on 2017/8/18.
 */
public class RedisManager {
    private final static RedisManager m_su = new RedisManager();

    public StringBuffer sbLogModule = null;//用于LogUtil.getInstance().Print
    public StringBuffer sbLogInfo = null;//用于LogUtil.getInstance().Print

    private static RedisConfig redisConfig = null;

    private RedisManager() {
        if (sbLogModule == null) {
            sbLogModule = new StringBuffer(32);
            sbLogModule.append("Redis服务器");

        }
        if (sbLogInfo == null) {
            sbLogInfo = new StringBuffer(2048);
        }
    }

    public static RedisManager getInstance(RedisConfig config) {
        redisConfig = config;
        return m_su;
    }

    public JedisPool getPool() {
        return JedisUtil.getInstance().getPool(redisConfig.RedisServerIP, redisConfig.RedisServerPort);
    }

    /**
     * 程序异常时才关闭连接池
     */
    public void closePool() {
        JedisUtil.getInstance().closePool(redisConfig.RedisServerIP, redisConfig.RedisServerPort);
    }

    public Jedis getJedis() {
        return getPool().getResource();

    }

    public static void main(String[] args) {

        JedisUtil jedisUtil = JedisUtil.getInstance();


        RedisManager redisManager = RedisManager.getInstance(jedisUtil.redisConfig);

        Jedis jedis = redisManager.getPool().getResource();

        jedis.set("owner","张洪滨");

        System.out.println(jedis.get("owner"));


    }
}
