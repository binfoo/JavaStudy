package thrift.weixin;

public class TCPMessageConstant {
    public static short TCP_Msg_Header = (short) 0xBADA;//tcp消息的head

    public static String form_or_to_cloud = "cloud";//cloud模块
    public static String form_or_to_clientScreen = "clientScreen";//大屏显示器
    public static String form_or_to_clientServer = "clientServer";//本地服务器
    public static String form_or_to_weiXin = "weiXin";//微信模块

    public static String MsgName_HeartBeat_Inform = "HeartBeat_Inform";//心跳消息
    public static String MsgName_Upload_Status = "Upload_Status";//上传状态
    public static String MsgName_Internal_Control = "Internal_Control";//内部控制命令
    public static String MsgName_Device_Control = "Device_Control";//普通网关读写操作
    public static String MsgName_WuLian_Control = "WuLian_Control";//物联设备读写操作
    public static String MsgName_IsOnline_Device = "IsOnline_Device";//设备是否在线

    public static String subMsgName_Address_Status = "Address_Status";//普通网关上传状态
    public static String subMsgName_Sensor_Status = "Sensor_Status";//传感器上传状态
    public static String subMsgName_WuLian_Status = "WuLian_Status";//物联设备上传状态
    public static String subMsgName_Alert_Status = "Alert_Info";//告警信息

    public static String subMsgName_Device_Write = "Device_Write";//普通网关写操作
    public static String subMsgName_Device_Read = "Device_Read";//普通网关读操作
    public static String subMsgName_WuLian_Write = "WuLian_Write";//物联设备写操作
    public static String subMsgName_WuLian_Read = "WuLian_Read";//物联设备读操作

    public static String subMsgName_Client_Identify = "Client_Identify";//客户端安全校验

    public static String subMsgName_Default = "default";//客户端安全校验

}
