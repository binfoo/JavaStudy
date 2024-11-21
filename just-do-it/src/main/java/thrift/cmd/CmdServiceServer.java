package thrift.cmd;

import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by ZhangHongbin on 2017/1/18.
 */
public class CmdServiceServer {
    public static void main(String[] args) {


        try {
            //1.实现服务接口


            //2. 关联处理器与 Hello 服务的实现
            CmdService.Processor<CmdServiceImpl> processor = new CmdService.Processor<>(new CmdServiceImpl());

            //3. 创建TServerTransport
            TServerSocket tServerSocket = new TServerSocket(2500);

            //4. 创建TProtocol

            TJSONProtocol.Factory factory = new TJSONProtocol.Factory();

            //5. 创建TServer

            TServer.Args arg = new TServer.Args(tServerSocket);
            arg.processor(processor);
            arg.protocolFactory(factory);

            TServer server = new TSimpleServer(arg);
            System.out.println("Start server on port 2500...");

            //6. 启动Server
            server.serve();


        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }
}
