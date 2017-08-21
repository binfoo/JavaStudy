package thrift.weixin;



/**普通网关写操作
 * @author 董志勇
 *
 */
public class BodyWriteForAddress {
    public String clientID;   //大屏控制器ID/本地服务器ID
    public String deviceID;
    public String deviceType;//设备类型：灯光
    public String deviceManufacture;//设备厂家
    public String addressID;
    public String addressName;
    public String addressValue;

    public String toString()
    {
        return  "{clientID: " + clientID + LogUtil.lineSeparator +
                ",deviceID: " + deviceID +  LogUtil.lineSeparator +
                ",deviceType: " +deviceType + LogUtil.lineSeparator +
                ",deviceManufacture: " +deviceManufacture + LogUtil.lineSeparator +
                ",addressID: " +addressID + LogUtil.lineSeparator +
                ",addressName: " +addressName + LogUtil.lineSeparator +
                ",addressValue: " +addressValue + LogUtil.lineSeparator +
                "}";
    }
}
