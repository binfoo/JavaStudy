package service.demo;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.AbstractNonblockingServer;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.*;

/**
 * 创建非阻塞服务器.
 */
public class HelloServiceAsyncServer {

    private final static int port = 10005;

    public static void main(String[] args) {

        TNonblockingServerTransport serverTransport;

        try {
            serverTransport = new TNonblockingServerSocket(port);

            Hello.Processor processor = new Hello.Processor(new HelloServiceImpl());

            TNonblockingServer.Args tnbArgs = new TNonblockingServer.Args(
                    serverTransport);
            tnbArgs.processor(processor);
            // 使用非阻塞式IO，服务端和客户端需要指定TFramedTransport数据传输的方式

            tnbArgs.transportFactory(new TFramedTransport.Factory());
            tnbArgs.protocolFactory(new TBinaryProtocol.Factory());


            TServer server = new TNonblockingServer(tnbArgs);
            System.out.println("启动非阻塞服务器，端口 " + port + " ...");
            server.serve();


        } catch (TTransportException e) {
            e.printStackTrace();
        }


    }
}
