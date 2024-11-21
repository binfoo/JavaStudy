package thrift;//package thrift.cmd;
//
//import org.apache.thrift.TException;
//import org.apache.thrift.protocol.TJSONProtocol;
//import org.apache.thrift.protocol.TProtocol;
//import org.apache.thrift.transport.TSocket;
//import org.apache.thrift.transport.TTransport;
//import org.apache.thrift.transport.TTransportException;
//
///**
// * Created by ZhangHongbin on 2017/1/18.
// */
//public class HelloServiceClientTest {
//    public static void main(String[] args) {
//
////        创建Transport
////        创建TProtocol
////        基于TTransport和TProtocol创建 Client
////        调用Client的相应方法
//
//        TTransport tTransport = new TSocket("localhost", 9260);
//        try {
//            tTransport.open();
//
//            TProtocol protocol = new TJSONProtocol(tTransport);
//            Hello.Client client = new Hello.Client(protocol);
//
//            try {
//
//
//                System.out.println(client.helloBoolean(true));
//
//                client.helloVoid();
//
//                System.out.println(client.helloString("Happy New Year !"));
//
//                System.out.println(client.helloInt(926));
//
//                tTransport.close();
//            } catch (TException e) {
//                e.printStackTrace();
//            }
//        } catch (TTransportException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
