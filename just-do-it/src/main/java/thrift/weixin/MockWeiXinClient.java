package thrift.weixin;

import java.util.concurrent.Executors;

import mariadb.FileUtils;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MockWeiXinClient {

	private WeiXinServerConfig config;
    WebuiService.Client webUI = null;
    TTransport transport = null;
    TProtocol protocol = null;
    
	public MockWeiXinClient(WeiXinServerConfig config)
	{
	    this.config = config;

	}


		
    public static void main(String[] args) throws TException {
		
		//当前工程的绝对路径
		String ParentPath = PathUtil.getAbsProjectPath() ;
		// 读取配置文件参数
		String filePath = ParentPath + "/config/WeiXinServer.txt";
		System.out.println("读取WeiXinServer配置文件：" + filePath);

		String fileContent = FileUtils.readFileByLines(filePath);
        System.out.println("WeiXinServer配置参数：" + fileContent);
        
        // json格式转换为javaBean
     	Gson gson = new Gson();
     	WeiXinServerConfig config = gson.fromJson(fileContent,new TypeToken<WeiXinServerConfig>() {
     			}.getType());
     		
        MockWeiXinClient test = new MockWeiXinClient(config);	
		
	    try {	
			
			test.test2();
		} catch (Exception e) {			
			e.printStackTrace();
			System.out.println("error message:" + e.getMessage());
		}	
		
    }
    	
	public void test2()
	{
		String jscmd;
		for(int k=0;k<1;k++)
		{
			jscmd = "cmd：" +k;
		    ThreadWeiXinClient thread = new ThreadWeiXinClient(config,jscmd); 
		 
		    Thread t=new Thread(thread); 
		    t.start();
		}
		
	}	
	
}
