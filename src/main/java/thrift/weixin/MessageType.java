package thrift.weixin;

public class MessageType {
    //TR069协议用的命令
	public static String MESSAGE_TYPE_INFO = "infomation";
	public static String MESSAGE_TYPE_INFO_RESPONSE = "infomation_response";
	
	public static String MESSAGE_TYPE_MESSAGE_DOWNLOAD_RESPONSE = "download_response";
	
	public static String MESSAGE_UNKNOWN = "unknown";//无法识别的消息
	
	public static String MESSAGE_EMPTY = "empty";//空消息
	
	public static String MESSAGE_GET_PARAM_VALUE = "get_param_value";
	public static String MESSAGE_GET_PARAM_VALUE_RESPONSE = "get_param_value_response";
	
	public static String MESSAGE_SET_PARAM_VALUE = "set_param_value";
	public static String MESSAGE_SET_PARAM_VALUE_RESPONSE = "set_param_value_response";
		
	//云平台内部用的命令
	public static String MESSAGE_SET_PROTO_TIMEOUT = "set_proto_timeout";//设置协议的超时时间
	public static String MESSAGE_REMOVE_PROTO_TIMEOUT = "remove_proto_timeout";//删除协议的超时时间
	
	public static String MESSAGE_SET_TR069CMD_TIMEOUT = "set_TR069CMD_timeout";//设置TR069命令的超时时间
	public static String MESSAGE_REMOVE_TR069CMD_TIMEOUT = "remove_TR069CMD_timeout";//删除TR069命令的超时时间
	
	//数据库写操作的命令
	public static String DB_UPDATE_DEVICEINFO = "update_device_info";
	public static String DB_UPDATE_PARAM_GET_RESULT = "update_param_get_result";
	public static String DB_UPDATE_PARAM_SET_RESULT = "update_param_set_result";
	public static String DB_INSERT_TR069CMD = "insert_tr069cmd";
	
	public static String MESSAGE_LOG = "log";
	
	public static String DB_KEEP_ALIVE = "keep_db_alive";//云平台内部命令，保持ConsumerDB的数据库连接
	
}
