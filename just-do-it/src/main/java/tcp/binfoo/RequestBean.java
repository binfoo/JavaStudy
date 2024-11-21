package tcp.binfoo;


import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 {
 "device_id":"eeccaaddffee",
 "from":"SCREEN",
 "to":"CLOUD",
 "type":"Apk_Update/Aqi_Adjust",
 "msg":{
 "app_key":"suningruicheng",
 "version_code":"1",
 "progress":0,
 "status":"normal",
 "errorCode":0
 },
 "msgAck":{
 "update":true,
 "new_version":"1",
 "update_url":"http://cdn.the.url.of.apk/or/patch",
 "update_log":"new version",
 "file_name":"landleaf.apk/libSerialport.so",
 "update_type":0
 },
 "aqi":{
 "voc":-0.02,
 "temp":-5,
 "arofene":-0.006,
 "co2":-200,
 "humidity":-10,
 "pm25":-5
 },
 "aqiAck":true
 }
 */
public class RequestBean implements Serializable {

    private String device_id;//对应mac地址
    private String from;//取值为SCREEN、WEB、CLOUD;分别对应大屏、网、云
    private String to;
    private String type;//Apk_Update/Aqi_Adjust/Heat
    private Msg msg;
    private AqiAdjust aqi;
    private MsgAck msgAck;
    private boolean apiAck;

    public boolean isApiAck() {
        return apiAck;
    }

    public void setApiAck(boolean apiAck) {
        this.apiAck = apiAck;
    }

    public AqiAdjust getAqi() {
        return aqi;
    }

    public void setAqi(AqiAdjust aqi) {
        this.aqi = aqi;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Msg getMsg() {
        return msg;
    }

    public void setMsg(Msg msg) {
        this.msg = msg;
    }

    public MsgAck getMsgAck() {
        return msgAck;
    }

    public void setMsgAck(MsgAck msgAck) {
        this.msgAck = msgAck;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "RequestBean{" +
                "apiAck=" + apiAck +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", type='" + type + '\'' +
                ", device_id='" + device_id + '\'' +
                ", msg=" + msg +
                ", aqi=" + aqi +
                ", msgAck=" + msgAck +
                '}';
    }

    public static void main(String[] args) {
        String str = "{\n" +
                "    \"device_id\":\"eeccaaddffee\",\n" +
                "    \"from\":\"SCREEN\",\n" +
                "    \"to\":\"CLOUD\",\n" +
                "    \"type\":\"Apk_Update/Aqi_Adjust\",\n" +
                "    \"msg\":{\n" +
                "        \"app_key\":\"suningruicheng\",\n" +
                "        \"version_code\":\"1\",\n" +
                "        \"progress\":0,\n" +
                "        \"status\":\"normal\",\n" +
                "        \"errorCode\":0\n" +
                "    },\n" +
                "    \"msgAck\":{\n" +
                "        \"update\":true,\n" +
                "        \"new_version\":\"1\",\n" +
                "        \"update_url\":\"http://cdn.the.url.of.apk/or/patch\",\n" +
                "        \"update_log\":\"new version\",\n" +
                "        \"file_name\":\"landleaf.apk/libSerialport.so\",\n" +
                "        \"update_type\":0\n" +
                "    },\n" +
                "    \"aqi\":{\n" +
                "        \"voc\":-0.02,\n" +
                "        \"temp\":-5,\n" +
                "        \"arofene\":-0.006,\n" +
                "        \"co2\":-200,\n" +
                "        \"humidity\":-10,\n" +
                "        \"pm25\":-5\n" +
                "    },\n" +
                "    \"aqiAck\":true\n" +
                "}";
        RequestBean requestBean = JSON.parseObject(str,RequestBean.class);

        System.out.println(requestBean);
        System.out.println("msg = " + requestBean.getMsg());
        System.out.println("aqi = " + requestBean.getAqi());
        System.out.println("msgAck = " + requestBean.getMsgAck());
    }

}
