package tcp;

import org.apache.commons.lang.StringUtils;
import org.nutz.mvc.Scope;

import java.io.*;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/**
 * Created by ZhangHongbin on 2017/6/21.
 */
public class TcpClientTest {
    private String ip;
    private int port;
    private final String defaultIp = "localhost";
    private final String defaultInString = "服务器你好，我是大熊猫Land leaf！";

    public TcpClientTest(String ip, int port) {
        if (StringUtils.isBlank(ip)) {
            this.ip = defaultIp;
        } else {
            this.ip = ip;
        }
        this.port = port;

    }

    public void start(String inString) {

        System.out.println("TCP Client 启动 ,服务器的端口为 : " + port);

        try {
            Socket socket = new Socket(ip, port);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter pf = new PrintWriter(outputStream);
            pf.print(defaultInString);
            pf.flush();
            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);

            BufferedReader br = new BufferedReader(isr);
            String str = "";
            String temp;
            while ((temp = br.readLine()) != null) {
                str += temp;
                System.out.println("收到服务器回复 ： " + str);
            }

            br.close();
            isr.close();
            inputStream.close();
            pf.close();
            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new TcpClientTest("",1024).start("");

    }

}
