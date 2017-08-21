package com.company;

/**
 * Created by ZhangHongbin on 2016/6/12.
 */
public class Token {

    public String signature;
    public String echoStr;
    public String timestamp;


//    public  String createToken()
//    {
//        String[] str = { TOKEN, timestamp, nonce };
//        Arrays.sort(str); // 字典序排序
//        String bigStr = str[0] + str[1] + str[2];
//        // SHA1加密
//        String digest = new SHA1().getDigestOfString(bigStr.getBytes()).toLowerCase();
//
//    }
}
