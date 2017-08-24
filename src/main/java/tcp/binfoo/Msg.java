package tcp.binfoo;


import java.io.Serializable;

/**
 * Created by ZhangHongbin on 2017/7/6.
 * 大屏幕反馈给服务器的更新进度
 */
public class Msg implements Serializable {
    private String app_key;
    private String version_code;
    private int progress;//download progress
    private String status;//update download install error normal（心跳）

    private int errorCode;//0：正常;100:下载错误;200：解析错误;300:安装错误

    public String getApp_key() {
        return app_key;
    }

    public void setApp_key(String app_key) {
        this.app_key = app_key;
    }

    public String getVersion_code() {
        return version_code;
    }

    public void setVersion_code(String version_code) {
        this.version_code = version_code;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "app_key='" + app_key + '\'' +
                ", version_code='" + version_code + '\'' +
                ", progress=" + progress +
                ", status='" + status + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }



    public int getProgress() {
        return progress;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public void setProgress(int progress) {

        this.progress = progress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
