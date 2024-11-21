package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ZhangHongbin on 2017/3/1.
 */
public class HttpURLConnectionTest {

    public static void main(String[] args) {
//        1.1 创建 HTTP 连接对象
        try {


            URL obj = new URL("http://wthrcdn.etouch.cn/WeatherApi?city=%E5%8D%97%E4%BA%AC");

            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

//            1.2 添加 HTTP 请求头
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
// 1.3 HTTP GET

            con.setRequestMethod("GET");

            con.setRequestProperty("Charset", "utf-8");
            int responseCode = con.getResponseCode();
            String responseBody = readResponseBody(con.getInputStream());

            System.out.println(responseBody);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    // 读取输入流中的数据
    public static String readResponseBody(InputStream inputStream) throws IOException {

        BufferedReader in = new BufferedReader(
                new InputStreamReader(inputStream,"ISO-8859-1"));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return new String(response.toString().getBytes("ISO-8859-1"),"UTF-8");
    }
}