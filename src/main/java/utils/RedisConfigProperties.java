package utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by ZhangHongbin on 2017/8/24.
 */
public class RedisConfigProperties {

    private String filename;

    private final static String DEFAULT_FILENAME = "/redis.properties";

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public RedisConfigProperties() {

        this.filename = DEFAULT_FILENAME;

    }





    public static void main(String[] args) {

        RedisConfigProperties redisConfigProperties = new RedisConfigProperties();

        RedisConfig redisConfig = new RedisConfig();


        System.out.println(redisConfigProperties.getRedisConfig(redisConfigProperties.getFilename(),redisConfig));




    }

    public RedisConfig getRedisConfig(String filename,RedisConfig redisConfig) {

        Properties properties = new Properties();

        try {
            properties.load(RedisConfigProperties.class.getResourceAsStream(filename));

            redisConfig.setRedisServerIP(properties.getProperty("redisServerIp"));

            redisConfig.setRedisServerPort(Integer.parseInt(properties.getProperty("redisServerPort")));

            redisConfig.setPoolMaxActive(Integer.parseInt(properties.getProperty("poolMaxActive")));

            redisConfig.setPoolMaxIdle(Integer.parseInt(properties.getProperty("poolMaxIdle")));

            redisConfig.setPassword(properties.getProperty("password"));

            redisConfig.setPoolMaxWait(Integer.parseInt(properties.getProperty("poolMaxWait")));

            redisConfig.setTimeout(Integer.parseInt(properties.getProperty("timeout")));

            redisConfig.setRetryNum(Integer.parseInt(properties.getProperty("retryNum")));


        } catch (IOException e) {
            e.printStackTrace();
        }

        if (properties != null) {
            properties = null;
        }

        return redisConfig;
    }
}
