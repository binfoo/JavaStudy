package tcp.test;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.Socket;

public class GreetClient extends Thread {
    private Socket client;
    private int port;
    private String host;

    private final static String DEFAULT_HOST = "localhost";
    private final static int DEFAULT_PORT = 5555;
    private final static int DEFAULT_TIMEOUT = 5000;//5s

    public GreetClient() {

        this.port = DEFAULT_PORT;
        this.host = DEFAULT_HOST;

        init();

    }

    public GreetClient(String host, int port) {
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
            client = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        try {
            System.out.println("====访问端口在 " + port + " 的服务器====");

            OutputStream outToServer = client.getOutputStream();


            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF("Hello from " + client.getLocalSocketAddress());

            InputStream inputStream = client.getInputStream();

            DataInputStream in = new DataInputStream(inputStream);
            System.out.println("接收到来自服务端的消息 ： " + in.readUTF());
            client.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


        for (int i = 0; i < 10000; i++) {


            Thread t1 = new GreetClient();

            t1.start();
            System.out.println("线程 " + i + " " + t1.getName() + " 开始访问服务器！");
        }

    }
}

