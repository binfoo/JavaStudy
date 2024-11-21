package url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ZhangHongbin on 2016/12/30.
 */
public class UrlDemo {

//    1	public String getPath()
//    返回URL路径部分。
//            2	public String getQuery()
//    返回URL查询部分。
//            3	public String getAuthority()
//    获取此 URL 的授权部分。
//            4	public int getPort()
//    返回URL端口部分
//    5	public int getDefaultPort()
//    返回协议的默认端口号。
//            6	public String getProtocol()
//    返回URL的协议
//    7	public String getHost()
//    返回URL的主机
//    8	public String getFile()
//    返回URL文件名部分
//    9	public String getRef()
//    获取此 URL 的锚点（也称为"引用"）。
//            10	public URLConnection openConnection() throws IOException
//    打开一个URL连接，并运行客户端访问资源。

    //    Url is = http://www.w3cschool.cc/index.html?language=cn#j2se
//    protocol is http
//    authority is www.w3cschool.cc
//    file name is /index.html?language=cn
//    host is www.w3cschool.cc
//    path is /index.html
//    port is -1
//    default port is 80
//    query is language=cn
//    ref is j2se
    public static void main(String[] args) {
        urlConnectionDemo();

    }

    private static void urlDemo(){
        try {
            URL url = new URL("http://www.w3cschool.cc/index.html?language=cn#j2se");
            System.out.println("Url is = " + url.toString());
            System.out.println("protocol is "
                    + url.getProtocol());
            System.out.println("authority is "
                    + url.getAuthority());
            System.out.println("file name is " + url.getFile());
            System.out.println("host is " + url.getHost());
            System.out.println("path is " + url.getPath());
            System.out.println("port is " + url.getPort());
            System.out.println("default port is "
                    + url.getDefaultPort());
            System.out.println("query is " + url.getQuery());
            System.out.println("ref is " + url.getRef());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
    private static void urlConnectionDemo(){
        try {
            URL url = new URL("http://www.w3cschool.cc");
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if (urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
                System.out.println(connection.getContentEncoding() );
            } else {
                System.out.println("Please enter an HTTP URL.");
                return;
            }
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String urlString = "";
            String current;
            while ((current = in.readLine()) != null) {
                urlString += current;
            }
//            System.out.println(urlString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


//    序号	方法描述
//        1	Object getContent()
//        检索URL链接内容
//        2	Object getContent(Class[] classes)
//        检索URL链接内容
//        3	String getContentEncoding()
//        返回头部 content-encoding 字段值。
//        4	int getContentLength()
//        返回头部 content-length字段值
//        5	String getContentType()
//        返回头部 content-type 字段值
//        6	int getLastModified()
//        返回头部 last-modified 字段值。
//        7	long getExpiration()
//        返回头部 expires 字段值。
//        8	long getIfModifiedSince()
//        返回对象的 ifModifiedSince 字段值。
//        9	public void setDoInput(boolean input)
//        URL 连接可用于输入和/或输出。如果打算使用 URL 连接进行输入，则将 DoInput 标志设置为 true；如果不打算使用，则设置为 false。默认值为 true。
//        10	public void setDoOutput(boolean output)
//        URL 连接可用于输入和/或输出。如果打算使用 URL 连接进行输出，则将 DoOutput 标志设置为 true；如果不打算使用，则设置为 false。默认值为 false。
//        11	public InputStream getInputStream() throws IOException
//        返回URL的输入流，用于读取资源
//        12	public OutputStream getOutputStream() throws IOException
//        返回URL的输出流, 用于写入资源。
//        13	public URL getURL()
//        返回 URLConnection 对象连接的URL
