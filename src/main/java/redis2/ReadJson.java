package redis2;

import com.alibaba.fastjson.JSON;
import mariadb.FileUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

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
//        System.getProperties().list(System.out) ;   // 列出系统的全部属性

        Properties properties = System.getProperties();
        Iterator it = properties.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry entry = (Map.Entry)it.next();
            System.out.print(entry.getKey()+"=");
            System.out.println(entry.getValue());
        }

    }

}
