package http;

import org.junit.Test;
import org.nutz.Nutz;
import org.nutz.http.Http;
import org.nutz.http.Response;

import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by ZhangHongbin on 2017/3/1.
 */

public class test {

    @Test
    public void get() {
        Response response = Http.get("http://wthrcdn.etouch.cn/WeatherApi?city=%E5%8D%97%E4%BA%AC");
        assertNotNull(response);
        assertNotNull(response.getContent());

        System.out.println(response.getContent());
        assertNotNull(response.getDetail());
        assertNotNull(response.getHeader());
        assertNotNull(response.getProtocal());
        System.out.println(response.getStatus());
        assertNotNull(response.getStream());
    }

    @Test
    public void post() {
        Map<String, Object> parms = new HashMap<String, Object>();
        parms.put("version", "NutzTest");
        parms.put("website", Nutz.version());
        String response = Http.post("http://nutztest.herokuapp.com/",
                parms,
                5 * 1000); // 可以同时设置超时时间
        assertNotNull(response);
        System.out.println(response.length() > 0);
        // 该post的返回值是"version: #{params[:version]}, website: #{params[:website]}"
        assertEquals(response,
                String.format("version: %s, website: %s",
                        "NutzTest",
                        Nutz.version()));

        // 根据Http头的Content-Type自动识别编码类型
        Response response1 = Http.get("www.duokan.com");
        assertEquals("utf-8", response1.getEncodeType().toLowerCase());
        assertTrue(response1.getContent().indexOf("多看") > 0);

        // 如果Http头中没有指定编码类型，用户也可以手工指定
        Response response2 = Http.get("www.exam8.com/SiteMap/Article1.htm");
        assertTrue(response2.getContent("GBK").indexOf("考试吧") > 0);
    }


}
