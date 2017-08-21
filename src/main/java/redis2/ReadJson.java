package redis2;

import com.alibaba.fastjson.JSON;
import mariadb.FileUtils;

/**
 * Created by ZhangHongbin on 2017/8/18.
 */
public class ReadJson {
    public static RedisConfig getRedisConfig() {


        String fileName = PathUtil.getAbsProjectPath()+ "/config/RedisConfig.js";

        String string = FileUtils.readFileByLines(fileName);

        System.out.println(string);

        RedisConfig redisConfig = null;

        redisConfig = JSON.parseObject(string,RedisConfig.class);

        return redisConfig;
    }

    public static void main(String[] args) {
        System.out.println(getRedisConfig());
    }

}
