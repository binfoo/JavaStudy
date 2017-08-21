package service.demo;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import service.demo.Hello.Processor;

/**
 * 创建服务器端实现代码，将 HelloServiceImpl 作为具体的处理器传递给 Thrift 服务器
 */
public class HelloServiceServer {
    private final static int port = 7911;

    public static void main(String[] args) {


        try {
            // 设置服务端口为 7911
            TServerSocket serverTransport = new TServerSocket(7911);

            // 设置协议工厂为 TBinaryProtocol.Factory

            TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory();

            // 关联处理器与 Hello 服务的实现

            TProcessor processor = new Hello.Processor(new HelloServiceImpl());

            TServer.Args arg = new TServer.Args(serverTransport);

            arg.processor(processor);
            arg.protocolFactory(proFactory);

            TServer server = new TSimpleServer(arg);


            System.out.println("服务器启动在端口 " + port + " ...");

            server.serve();



//            TServer server = new TThreadPoolServer(processor, serverTransport, proFactory);
        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }
}
