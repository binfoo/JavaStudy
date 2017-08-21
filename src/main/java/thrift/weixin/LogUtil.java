package thrift.weixin;

import mariadb.FileUtils;
import org.joda.time.DateTime;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;



public class LogUtil {

	public static String lineSeparator = StringUtil.lineSeparator;
	
	public static int LOG_TYPE_OK = 1;
	public static int LOG_TYPE_ERROR = 2;
	private final static LogUtil m_su = new LogUtil();
	//public static RabbitMQConfig rabbitMQConfig = null ;//rabbitMQ服务器的配置
    public static String serviceName = null;
    public static DebugConfig debugConfig = null;
    
	private LogUtil() {

	}
	
	public static LogUtil getInstance() {
		/*if (rabbitMQConfig == null)
		{
            RabbitConfigDao daoRabbit = DBManager.GetRabbitConfig(null,true);
            rabbitMQConfig = new RabbitMQConfig();
            rabbitMQConfig.ipaddress = daoRabbit.getIpaddress();
            rabbitMQConfig.port = daoRabbit.getPort();
            rabbitMQConfig.timeout = daoRabbit.getTimeout();
            System.out.println("rabbitMQ 服务器连接参数：" + daoRabbit.toString());       
            RabbitMQManager.getInstance().initRabbitConfig(rabbitMQConfig);
         }*/
        if (debugConfig == null)
        {
        	//当前工程的绝对路径
    		String ParentPath = PathUtil.getAbsProjectPath() ;
    		// 读取配置文件参数
    		String filePath = ParentPath + "/config/DebugConfig.js";
    		System.out.println("读取DebugConfig配置文件：" + filePath);

    		String fileContent = FileUtils.readFileByLines(filePath);
            System.out.println("DebugConfig参数：" + fileContent);
            
    		// json格式转换为javaBean
    		Gson gson = new Gson();
    		debugConfig = gson.fromJson(fileContent,new TypeToken<DebugConfig>() {}.getType());
        }
        
		return m_su;
	}
	
	public void setServiceName (String serviceName1)
	{
		serviceName = serviceName1;
	}
	
	/**
     * @param moduleName
     * @param info
     * @param isSave
     * @param logType
     */
    public void Print(StringBuffer moduleName,StringBuffer info,boolean isSave, int logType)
    {
    	if ((logType == LogUtil.LOG_TYPE_OK) && (debugConfig.debugOk!=1))
    	{
    		return;
    	}
    	if ((logType == LogUtil.LOG_TYPE_ERROR) && (debugConfig.debugErr!=1))
    	{
    		return;
    	}
    	DateTime dt = DateUtil.getCurrentDate();
    	String logTime = DateUtil.formatJodaDate(dt);
    	String logHead = null;
    	if (serviceName == null)
    	{
    		logHead = moduleName+ "(" + logTime +")";    	  
    	}
    	else
    	{
    		logHead = serviceName + "->" + moduleName+ "(" + logTime +")";    		
    	}
    	System.out.println("【" + logHead + "】: " + info);
    	
    	if (isSave)
    	{
    		LogBean bean = new LogBean();
    		bean.logTime = logTime;
    		bean.moduleName = logHead;
    		bean.logInfo = info.toString();
    		bean.logType = logType;
    		String message = MessageUtil.ToJson(bean);
    		//RabbitMQManager.getInstance().sendRabbitMQ(message,RabbitMQConstant.ROUTING_KEY_LOG);
    	}
    	logHead = null;
    	logTime = null;
    }
    
   /**
     * @param moduleName
     * @param info
     * @param isSave
     * @param logType
     */
    public void Print(String moduleName,String info,boolean isSave, int logType)
    {
    	if ((logType == LogUtil.LOG_TYPE_OK) && (debugConfig.debugOk!=1))
    	{
    		return;
    	}
    	if ((logType == LogUtil.LOG_TYPE_ERROR) && (debugConfig.debugErr!=1))
    	{
    		return;
    	}
    	DateTime dt = DateUtil.getCurrentDate();
    	String logTime = DateUtil.formatJodaDate(dt);
    	String logHead = null;
    	if (serviceName == null)
    	{
    		logHead = moduleName+ "(" + logTime +")";    	  
    	}
    	else
    	{
    		logHead = serviceName + "->" + moduleName+ "(" + logTime +")";    		
    	}
    	System.out.println("【" + logHead + "】: " + info);
    	
    	if (isSave)
    	{
    		LogBean bean = new LogBean();
    		bean.logTime = logTime;
    		bean.moduleName = logHead;
    		bean.logInfo = info;
    		bean.logType = logType;
    		String message = MessageUtil.ToJson(bean);
    	//RabbitMQManager.getInstance().sendRabbitMQ(message,RabbitMQConstant.ROUTING_KEY_LOG);
    	}
    	logHead = null;
    	logTime = null;
    }
}
