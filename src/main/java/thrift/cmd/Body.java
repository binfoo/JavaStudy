package thrift.cmd;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/21.
 */
public class Body {

    //    Map n1 = new HashMap();
//                n1.put("clientID", "ab111");
//                n1.put("deviceID", "01020304");
//                n1.put("deviceManufacture", "厂家A");
//                n1.put("addressID", "4001");
//                n1.put("addressName", "灯光地址");
//                n1.put("addressValue", "1");

    private String clientID;
    private String deviceID;
    private String deviceManufacture;
    private String addressID;
    private String addressName;
    private String addressValue;

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDeviceManufacture() {
        return deviceManufacture;
    }

    public void setDeviceManufacture(String deviceManufacture) {
        this.deviceManufacture = deviceManufacture;
    }

    public String getAddressID() {
        return addressID;
    }

    public void setAddressID(String addressID) {
        this.addressID = addressID;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    @Override
    public String toString() {
        return "Body{" +
                "clientID='" + clientID + '\'' +
                ", deviceID='" + deviceID + '\'' +
                ", deviceManufacture='" + deviceManufacture + '\'' +
                ", addressID='" + addressID + '\'' +
                ", addressName='" + addressName + '\'' +
                ", addressValue='" + addressValue + '\'' +
                '}';
    }

    public String getAddressValue() {
        return addressValue;
    }

    public void setAddressValue(String addressValue) {
        this.addressValue = addressValue;
    }

    public Body(String clientID, String deviceID, String deviceManufacture, String addressID, String addressName, String addressValue) {
        this.addressID = addressID;
        this.deviceID = deviceID;
        this.addressName = addressName;
        this.deviceManufacture = deviceManufacture;
        this.addressName = addressName;
        this.addressValue = addressValue;

    }





}
