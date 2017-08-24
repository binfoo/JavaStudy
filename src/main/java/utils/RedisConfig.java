package utils;

/**
 * Created by ZhangHongbin on 2017/8/18.
 */
public class RedisConfig {
    private String redisServerIP;
    private int redisServerPort;

    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private int poolMaxActive;

    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private int poolMaxWait;

    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private int poolMaxIdle = 200;

    private int timeout = 10000;

    private int retryNum = 5;

    private String password;//redis 登录密码

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPoolMaxActive() {
        return poolMaxActive;
    }

    public void setPoolMaxActive(int poolMaxActive) {
        this.poolMaxActive = poolMaxActive;
    }

    public int getPoolMaxIdle() {
        return poolMaxIdle;
    }

    public void setPoolMaxIdle(int poolMaxIdle) {
        this.poolMaxIdle = poolMaxIdle;
    }

    public int getPoolMaxWait() {
        return poolMaxWait;
    }

    public void setPoolMaxWait(int poolMaxWait) {
        this.poolMaxWait = poolMaxWait;
    }

    public String getRedisServerIP() {
        return redisServerIP;
    }

    public void setRedisServerIP(String redisServerIP) {
        this.redisServerIP = redisServerIP;
    }

    public int getRedisServerPort() {
        return redisServerPort;
    }

    public void setRedisServerPort(int redisServerPort) {
        this.redisServerPort = redisServerPort;
    }

    public int getRetryNum() {
        return retryNum;
    }

    public void setRetryNum(int retryNum) {
        this.retryNum = retryNum;
    }


    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        return "RedisConfig{" +
                "password='" + password + '\'' +
                ", redisServerIP='" + redisServerIP + '\'' +
                ", redisServerPort=" + redisServerPort +
                ", poolMaxActive=" + poolMaxActive +
                ", poolMaxWait=" + poolMaxWait +
                ", poolMaxIdle=" + poolMaxIdle +
                ", timeout=" + timeout +
                ", retryNum=" + retryNum +
                '}';
    }


}
