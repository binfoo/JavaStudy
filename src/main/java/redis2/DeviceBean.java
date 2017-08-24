package redis2;

import java.io.Serializable;

/**
 * Created by ZhangHongbin on 2017/7/21.
 */
public class DeviceBean implements Serializable {
    private String deviceId;
    private String version;
    private String state;
    private String description;
    private String ct;
    private String ut;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getCt() {
        return ct;
    }

    public void setCt(String ct) {
        this.ct = ct;
    }

    public String getUt() {
        return ut;
    }

    public void setUt(String ut) {
        this.ut = ut;
    }

    @Override

    public String toString() {
        return "DeviceBean{" +
                "ct=" + ct +
                ", deviceId='" + deviceId + '\'' +
                ", version='" + version + '\'' +
                ", state='" + state + '\'' +
                ", description='" + description + '\'' +
                ", ut=" + ut +
                '}';
    }


}
