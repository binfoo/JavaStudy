package thrift.cmd;

import com.alibaba.fastjson.JSON;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.nutz.json.Json;
import org.nutz.lang.util.NutMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangHongbin on 2017/1/18.
 */
public class CmdServiceClient {
    public static void main(String[] args) {

//        创建Transport
//        创建TProtocol
//        基于TTransport和TProtocol创建 Client
//        调用Client的相应方法

        TTransport tTransport = new TSocket("192.168.6.75", 7801);
        try {
            tTransport.open();

            TProtocol protocol = new TJSONProtocol(tTransport);
            CmdService.Client client = new CmdService.Client(protocol);

            try {

                String cmd1 = null;

                String cmd2 = null;

                Body body = new Body("aaaaa", "18010101", "思美特",
                        "4001", "客厅大灯", "1");

                Request req = new Request("2016-12-21 12:33:44", "weiXin", "clientScreen", "999999",
                        "Device_Control", " Device_Write", Encode.createBody(body));

                cmd1 = Encode.createReq(req);


                System.out.println(cmd1);


//                {
//                    "createTime":"2016-12-21 12:33:44",
//                        "from":"weiXin",
//                        "to":"clientScreen",
//                        "msgID":"",
//                        "msgName":"Device_Control",
//                        "subMsgName":" Device_Write",
//                        "body":{
//                    "clientID":"ab1111",
//                            "deviceID":"01020304",
//                            "deviceType":"灯光",
//                            "deviceManufacture":"厂家A",
//                            "addressID":"4001",
//                            "addressName":"灯光地址",
//                            "addressValue":"1"
//                }
//                }


                CallResult c1 = client.callCommand(1, cmd1, cmd2);

                System.out.println(c1.toString());


                tTransport.close();
            } catch (TException e) {
                e.printStackTrace();
            }
        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }
}
