package redis;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import mariadb.FileUtils;
import redis2.PathUtil;
import redis2.RedisConfig;

import java.net.InetAddress;

public class StartInitRedis
{

	public InetAddress clientAddress = null;//客户端ip
	public int clientPort = 0;//客户端端口
	
	public StringBuffer sbLogModule = null;//用于LogUtil.getInstance().Print
	public StringBuffer sbLogInfo = null;//用于LogUtil.getInstance().Print
		

	public static void main(String[] args) 
	{
		//当前工程的绝对路径
    	String ParentPath = PathUtil.getAbsProjectPath() ;
    	// 读取配置文件参数
    	String filePath = ParentPath + "/config/RedisConfig.js";
    	System.out.println("读取RedisConfig配置文件：" + filePath);

    	String fileContent = FileUtils.readFileByLines(filePath);
    	System.out.println("RedisConfig参数：" + fileContent);
    	        
    	// json格式转换为javaBean
    	Gson gson = new Gson();
    	RedisConfig redisConfig = gson.fromJson(fileContent,new TypeToken<RedisConfig>() {}.getType());
		
		StartInitRedis run = new StartInitRedis();
	}
	

	
	
	
	
	
}