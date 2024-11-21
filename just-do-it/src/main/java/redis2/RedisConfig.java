package redis2;

/**
 * Created by ZhangHongbin on 2017/8/18.
 */
public class RedisConfig {
    public String RedisServerIP;
    public int RedisServerPort;

    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    public int PoolMaxActive;

    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    public int PoolMaxWaite;

    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    public int PoolMaxIdle = 200;

    public int Timeout = 10000;

    public int RetryNum = 5;

    public String Password;//redis 登录密码

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getPoolMaxActive() {
        return PoolMaxActive;
    }

    public void setPoolMaxActive(int poolMaxActive) {
        PoolMaxActive = poolMaxActive;
    }

    @Override
    public String toString() {
        return "RedisConfig{" +
                "Password='" + Password + '\'' +
                ", RedisServerIP='" + RedisServerIP + '\'' +
                ", RedisServerPort=" + RedisServerPort +
                ", PoolMaxActive=" + PoolMaxActive +
                ", PoolMaxWaite=" + PoolMaxWaite +
                ", PoolMaxIdle=" + PoolMaxIdle +
                ", Timeout=" + Timeout +
                ", RetryNum=" + RetryNum +
                '}';
    }

    public int getPoolMaxIdle() {
        return PoolMaxIdle;
    }

    public void setPoolMaxIdle(int poolMaxIdle) {
        PoolMaxIdle = poolMaxIdle;
    }

    public int getPoolMaxWaite() {
        return PoolMaxWaite;
    }

    public void setPoolMaxWaite(int poolMaxWaite) {
        PoolMaxWaite = poolMaxWaite;
    }

    public String getRedisServerIP() {
        return RedisServerIP;
    }

    public void setRedisServerIP(String redisServerIP) {
        RedisServerIP = redisServerIP;
    }

    public int getRedisServerPort() {
        return RedisServerPort;
    }

    public void setRedisServerPort(int redisServerPort) {
        RedisServerPort = redisServerPort;
    }

    public int getRetryNum() {
        return RetryNum;
    }

    public void setRetryNum(int retryNum) {
        RetryNum = retryNum;
    }

    public int getTimeout() {
        return Timeout;
    }

    public void setTimeout(int timeout) {
        Timeout = timeout;
    }

}
