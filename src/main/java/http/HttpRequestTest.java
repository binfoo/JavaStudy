package http;

import com.github.kevinsawicki.http.HttpRequest;
import org.apache.log4j.Logger;

/**
 * Created by ZhangHongbin on 2017/3/8.
 */
public class HttpRequestTest {

    private static Logger log =  Logger.getLogger(HttpRequestTest.class);


    public static void main(String[] args) {
        int response = HttpRequest.get("http://www.qq.com").code();
        System.out.println(response);


        String response2 = HttpRequest.get("http://www.baidu.com").body();
        System.out.println("Response was: " + response2);

        HttpRequest.get("http://www.baidu.com").receive(System.out);


        HttpRequest.get("http://wthrcdn.etouch.cn/WeatherApi?city=%E5%8D%97%E4%BA%AC").receive(System.out);


    }









}
