package utils;

import org.joda.time.DateTime;


/**
 * Created by ZhangHongbin on 2017/8/23.
 */
public class DateUtils {

    public static String getNowTime(){
        return DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
    }

}
