package tcp;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.net.SocketServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ZhangHongbin on 2017/6/21.
 */
public class TcpServerTest {

    private String ip;
    private int port;
    private final String defaultIp = "localhost";

    private final String defaultOutString = "欢迎您！";

    public TcpServerTest(String ip, int port) {

        if (StringUtils.isBlank(ip)) {
            ip = defaultIp;
        } else {
            this.ip = ip;
        }
        this.port = port;
    }


    public void start(String outString) {

        System.out.println("TCP Server 启动在端口 : " + port);
        try {

//            1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
            ServerSocket serverSocket = new ServerSocket(port);

//           2、调用accept()方法开始监听，等待客户端的连接

            Socket socket = serverSocket.accept();
//            3、获取输入流，并读取客户端信息

            InputStream inputStream = socket.getInputStream();

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bf = new BufferedReader(inputStreamReader);

            String info = null;

            while ((info = bf.readLine()) != null) {
                System.out.println("我是服务器，客户端说 ： " + info);
            }

            socket.shutdownInput();

            OutputStream outputStream = socket.getOutputStream();

            PrintWriter pw = new PrintWriter(outputStream);

            if (StringUtils.isBlank(outString)) {
                outString = defaultOutString;
            }
            pw.print(outString);
            pw.flush();

            pw.close();
            outputStream.close();
            bf.close();
            inputStreamReader.close();
            inputStream.close();
            socket.close();
            serverSocket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 基于TCP协议的Socket通信，实现用户登录，服务端
     */

//    public void start() throws IOException {
////1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
//        ServerSocket serverSocket = new ServerSocket(port);//1024-65535的某个端口
//        //2、调用accept()方法开始监听，等待客户端的连接
//        Socket socket = serverSocket.accept();
//        //3、获取输入流，并读取客户端信息
//        InputStream is = socket.getInputStream();
//        InputStreamReader isr = new InputStreamReader(is);
//        BufferedReader br = new BufferedReader(isr);
//        String info = null;
//        while ((info = br.readLine()) != null)
//
//        {
//            System.out.println("我是服务器，客户端说：" + info);
//        }
//
//        socket.shutdownInput();//关闭输入流
//        //4、获取输出流，响应客户端的请求
//        OutputStream os = socket.getOutputStream();
//        PrintWriter pw = new PrintWriter(os);
//        pw.write("欢迎您！");
//        pw.flush();
//
//
////5、关闭资源
//        pw.close();
//        os.close();
//        br.close();
//        isr.close();
//        is.close();
//        socket.close();
//        serverSocket.close();
//    }
    public static void main(String[] args) throws IOException {
        while (true) {
            new TcpServerTest("", 1024).start("welcome to you,little girl!");
        }
    }

}
