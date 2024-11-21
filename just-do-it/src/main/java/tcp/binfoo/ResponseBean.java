package tcp.binfoo;


/**
 * 服务器返回数据
 * 说明：1.没有更新，则返回：{"update":false};
 * 2.update_type: 0:sh脚本安装(主要用于冠林屏),1:系统方式安装(主要用于21寸大屏)
 * {
 * "update":true,
 * "new_version":"v1.0.1",
 * "update_url":"http://cdn.the.url.of.apk/or/patch",
 * "update_log":"new version",
 * "file_name":"landleaf.apk/libSerialport.so",
 * "update_type":0/1
 * }
 */

/**
 *{
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
 "update_url":"http://cdn.the.url.of.apk/or/patch

 ",
 "update_log":"new version",
 "file_name":"landleaf.apk/libSerialport.so",
 "update_type":0
 },
 "aqi":{
 "voc":"-0.02",
 "temp":"-5",
 "arofene":"-0.006",
 "co2":"-200",
 "humidity":"-10",
 "pm25":"+5"
 },
 "aqiAck":true
 }
 */
public class ResponseBean {

    private boolean update;
    private String new_version;
    private String update_url;
    private String update_log;
    private int update_type;
    private String file_name;

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public String getNew_version() {
        return new_version;
    }

    public void setNew_version(String new_version) {
        this.new_version = new_version;
    }

    public String getUpdate_url() {
        return update_url;
    }

    public void setUpdate_url(String update_url) {
        this.update_url = update_url;
    }

    public String getUpdate_log() {
        return update_log;
    }

    public void setUpdate_log(String update_log) {
        this.update_log = update_log;
    }

    public int getUpdate_type() {
        return update_type;
    }

    public void setUpdate_type(int update_type) {
        this.update_type = update_type;
    }

    public String getFile_name() {
        return file_name;
    }

    @Override
    public String toString() {
        return "ResponseBean{" +
                "file_name='" + file_name + '\'' +
                ", update=" + update +
                ", new_version='" + new_version + '\'' +
                ", update_url='" + update_url + '\'' +
                ", update_log='" + update_log + '\'' +
                ", update_type=" + update_type +
                '}';
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }


}
