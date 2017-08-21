package tcp.test;

import annotation.Greeting;
import org.apache.commons.lang3.StringUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Created by ZhangHongbin on 2017/7/26.
 */
public class GreetingServer extends Thread {
    private ServerSocket serverSocket;
    private int port;
    private String host;

    private final static String DEFAULT_HOST = "localhost";
    private final static int DEFAULT_PORT = 5555;
    private final static int DEFAULT_TIMEOUT = 5000;//5s

    public GreetingServer(){

        this.port = DEFAULT_PORT;
        this.host = DEFAULT_HOST;

        init();

    }

    public GreetingServer(String host, int port) {
        if (StringUtils.isNotBlank(host)) {
            this.port = port;

        } else {
            this.host = DEFAULT_HOST;
        }
        if (port != 0) {
            this.host = host;
        } else {
            this.port = DEFAULT_PORT;
        }
        init();

    }

    public void init() {
        try {
            serverSocket = new ServerSocket(port);
//            serverSocket.setSoTimeout(DEFAULT_TIMEOUT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            try {

                System.out.println("====在端口 " + port + " 等待客户端的访问====");
                Socket server = serverSocket.accept();

                System.out.println("Just connected to " + server.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(server.getInputStream());
                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
                server.close();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {


        Thread t = new GreetingServer();

        t.start();
    }
}
