package service.demo;

import org.apache.thrift.TException;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TNonblockingServerTransport;
import org.apache.thrift.transport.TNonblockingSocket;
import org.apache.thrift.transport.TNonblockingTransport;

import java.io.IOException;

/**
 * 创建异步客户端实现代码，调用 Hello.AsyncClient 访问服务端的逻辑实现，将 MethodCallback 对象作为参数传入调用方法中
 */
public class HelloServiceAsyncClient {

    private final static int port = 10005;




    public static void main(String[] args) throws TException {

        try {
            TAsyncClientManager clientManager = new TAsyncClientManager();

            TNonblockingTransport transport = new TNonblockingSocket("localhost", port);

            TProtocolFactory protocol = new TBinaryProtocol.Factory();

            Hello.AsyncClient asyncClient = new Hello.AsyncClient(protocol, clientManager, transport);

            System.out.println("Client calls ......");

            MethodCallback callback = new MethodCallback();

            asyncClient.helloString("我就是我", callback);

            Object res = callback.getResult();

            while (res == null) {
                res = callback.getResult();
            }

            System.out.println(((Hello.AsyncClient.helloString_call) res)
                    .getResult());


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
