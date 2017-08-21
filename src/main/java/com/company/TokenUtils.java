package com.company;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import java.util.Date;

import org.apache.commons.lang.time.FastDateFormat;

/**
 * token在1到2小时之间都有效
 */
public class TokenUtils {
    private static final String privateKey = "fdas34ljfr好sja@#8$%dfkl;js&4*daklfjsdl;akfjsa342";

    public static String getToken(String userId, String date) {
        return Hashing.md5().newHasher().
                putString(userId, Charsets.UTF_8).
                putString(privateKey, Charsets.UTF_8).
                putString(date, Charsets.UTF_8).hash().toString();
    }

    public static String getToken(String userId, Date date) {
        return Hashing.md5().newHasher().
                putString(userId, Charsets.UTF_8).
                putString(privateKey, Charsets.UTF_8).
                putString(getDate(date), Charsets.UTF_8).hash().toString();
    }

    public static String getToken(String userId) {
        return Hashing.md5().newHasher().
                putString(userId, Charsets.UTF_8).
                putString(privateKey, Charsets.UTF_8).putString(getDate(), Charsets.UTF_8).hash().toString();
    }

    /**
     * 2个小时内都校验通过
     * @param token
     * @param userId
     * @return
     */
    public static boolean validToken(String token, String userId) {
        String confirm = getToken(userId);
        String confirmNextHour = getToken(userId,getNextHour());
        if (confirm.equals(token) || confirmNextHour.equals(token)) {
            return true;
        } else {
            return false;
        }
    }

    public static String getDate() {
        Date date = new Date(System.currentTimeMillis());
        return FastDateFormat.getInstance("yyyyMMddHH").format(date);
    }

    public static String getDate(Date now) {

        return FastDateFormat.getInstance("yyyyMMddHH").format(now);
    }
    public static String getNextHour() {
        Date date = new Date(System.currentTimeMillis() + 60 * 60 * 1000);

        return FastDateFormat.getInstance("yyyyMMddHH").format(date);
    }

    public static String getNextHour(Date now) {
        Date date = new Date(now.getTime() + 60 * 60 * 1000);

        return FastDateFormat.getInstance("yyyyMMddHH").format(date);
    }

    public static void main(String[] args){

        Date now = new Date();

        System.out.println("getToken(String userId, String date) : " +getToken("123456", "2016061512"));

        System.out.println(" String getToken(String userId) : " + getToken("123456") );

        System.out.println("String getDate() : " +getDate());
        System.out.println(" String getDate(Date now) : " + getDate(now) );

        System.out.println("getNextHour(Date now) : " + getNextHour(now));
        System.out.println("getNextHour() : " + getNextHour());

        System.out.println("validToken(String token, String userId) : " +validToken("a490cc16e13fe53a6155023e4586ce6b","123456" ));

    }
}
