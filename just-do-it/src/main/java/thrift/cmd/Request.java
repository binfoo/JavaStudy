package thrift.cmd;

import com.alibaba.fastjson.JSON;
import org.nutz.lang.util.NutMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/21.
 */
public class Request {


    private String createTime;

    private String from;

    private String to;
    private String msgID;
    private String msgName;
    private String subMsgName;

    public String getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "Request{" +
                "createTime='" + createTime + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", msgID='" + msgID + '\'' +
                ", msgName='" + msgName + '\'' +
                ", subMsgName='" + subMsgName + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMsgID() {
        return msgID;
    }

    public void setMsgID(String msgID) {
        this.msgID = msgID;
    }

    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName;
    }

    public String getSubMsgName() {
        return subMsgName;
    }

    public void setSubMsgName(String subMsgName) {
        this.subMsgName = subMsgName;
    }

    public Map getBody() {
        return body;
    }

    public void setBody(Map body) {
        this.body = body;
    }

    private Map body;

    public Request(String createTime, String from, String to, String msgID, String msgName, String subMsgName, Map body) {
        this.createTime = createTime;
        this.from = from;
        this.to = to;
        this.msgID = msgID;
        this.msgName = msgName;
        this.subMsgName = subMsgName;
        this.body = body;
    }




//    Map n1 = new HashMap();
//                n1.put("clientID", "ab111");
//                n1.put("deviceID", "01020304");
//                n1.put("deviceManufacture", "厂家A");
//                n1.put("addressID", "4001");
//                n1.put("addressName", "灯光地址");
//                n1.put("addressValue", "1");
//
//    NutMap n2 = new NutMap();
//
//                n2.put("createTime", "2016-12-21 12:33:44");
//                n2.put("from", "weiXin");
//                n2.put("to", "clientScreen");
//                n2.put("msgID", "999999");
//                n2.put("msgName", "Device_Control");
//                n2.put("subMsgName", " Device_Write");
//                n2.put("body", n1);
//
//
//    cmd1 = JSON.toJSONString(n2);
//                System.out.println(cmd1);
}
