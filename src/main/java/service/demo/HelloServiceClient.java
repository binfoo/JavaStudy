package service.demo;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * 调用 Hello.client 访问服务端的逻辑实现
 */
public class HelloServiceClient {

    private final static int port = 7911;

    public static void main(String[] args) {


        try {
            // 设置调用的服务地址为本地，端口为 7911

            TTransport transport = new TSocket("localhost", port);
            transport.open();

            // 设置传输协议为 TBinaryProtocol
            TProtocol protocol = new TBinaryProtocol(transport);

            Hello.Client client = new Hello.Client(protocol);

            client.helloString("我就是我");

            client.helloVoid();


        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }

    }
}
