package thrift.cmd;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.thrift.TException;

/**
 * Created by ZhangHongbin on 2017/1/18.
 */
public class CmdServiceImpl implements CmdService.Iface {

    @Override
    public CallResult callCommand(int cmdNo, String jsonCmd1, String jsonCmd2) throws TException {

        System.out.println(cmdNo);

        System.out.println(jsonCmd1);

        JSONObject j = JSON.parseObject(jsonCmd1);

        JSONObject body = (JSONObject) j.get("body");



        System.out.println("msgName = " + j.getString("msgName"));

        System.out.println("deviceID  = " + body.getString("deviceID"));

        System.out.println("addressName = " + body.getString("addressName") + ",addressValue = " + body.getString("addressValue"));


        CallResult callResult = new CallResult("成功", 0);



        return callResult;
    }
}
