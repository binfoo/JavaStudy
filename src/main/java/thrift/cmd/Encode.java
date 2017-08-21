package thrift.cmd;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/22.
 */
public class Encode {
    public static Map createBody(Body body) {
        Map m = new HashMap<>();

        m.put("clientID", body.getClientID());
        m.put("deviceID", body.getDeviceID());
        m.put("deviceManufacture", body.getDeviceManufacture());
        m.put("addressID", body.getAddressID());
        m.put("addressName", body.getAddressName());
        m.put("addressValue", body.getAddressValue());

        return m;
    }

    public static String createReq(Request req) {

        Map m = new HashMap();
        m.put("createTime", req.getCreateTime());
        m.put("from", req.getFrom());
        m.put("to", req.getTo());
        m.put("msgID", req.getMsgID());
        m.put("msgName", req.getMsgName());
        m.put("subMsgName", req.getSubMsgName());
        m.put("body", req.getBody());

        return JSON.toJSONString(m);

    }
}
