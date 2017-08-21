package thrift.weixin;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;



public class ThreadWeiXinClient implements Runnable{
	private  WeiXinServerConfig config;	
	private WebuiService.Client webUI = null;
	private TTransport transport = null;
	private TProtocol protocol = null;
	private String jscmd;
	public ThreadWeiXinClient(WeiXinServerConfig config,String jscmd)
	{
	    this.config = config;
	    this.jscmd = jscmd;
	}
	
	public void initConnection()
	{
		// 使用非阻塞式IO，服务端和客户端需要指定TFramedTransport数据传输的方式
		//transport = new TFramedTransport(new TSocket(this.config.WebUIServerIP,this.config.WebUIServerPort,10000));//设置TSocket的超时时常为500毫秒
		//transport = new TFramedTransport(new TSocket("114.215.100.41",7801,5000));//设置TSocket的超时时常为500毫秒
		//transport = new TFramedTransport(new TSocket("115.28.66.148",7801,15000));//设置TSocket的超时时常为500毫秒
		//transport = new TFramedTransport(new TSocket("127.0.0.1",7801,5000));//设置TSocket的超时时常为500毫秒
		String logTxt = DateUtil.getFormatCurrentDate1() + "[job线程][" + Thread.currentThread().getName() +"]对方ip = " + this.config.WeiXinServerIP + ", port = " + this.config.WeiXinServerPort;
		System.out.println(logTxt);
		transport = new TFramedTransport(new TSocket("127.0.0.1",this.config.WeiXinServerPort,35000));//设置TSocket的超时时常为500毫秒
		// 协议要和服务端一致
		protocol = new TJSONProtocol(transport);
		webUI = new WebuiService.Client(protocol);        
		try {
			transport.open();
		} catch (TTransportException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//必须先打开传输层	
	}
	
	public void closeConnection()
	{
		transport.close();
	}
	
	public void run(){
		initConnection();
		String logTxt = DateUtil.getFormatCurrentDate1() + "[thread线程][" + Thread.currentThread().getName() +"]callCommand之前: "+ jscmd;
		System.out.println(logTxt);
		try {

//			//普通网关写
//			BodyWriteForAddress body = new BodyWriteForAddress();
//			body.clientID = "ab1111";
//			body.deviceID = "default";
//			body.deviceType = "light";
//			body.deviceManufacture = "思美特";
//			body.addressID = "4001";
//			body.addressName = "客厅灯光";
//			body.addressValue = "1";
//
//			TCPMessageBody msg = new TCPMessageBody();
//			msg.createTime = "2017-13-22 12:33:44";
//			msg.from = TCPMessageConstant.form_or_to_weiXin;
//			msg.to = TCPMessageConstant.form_or_to_cloud;
//			msg.msgID = "";
//			msg.msgName = TCPMessageConstant.MsgName_Device_Control;
//			msg.subMsgName = TCPMessageConstant.subMsgName_Device_Write;
//			msg.body = body;


//			//普通网关读
//			BodyWriteForAddress body = new BodyWriteForAddress();
//			body.clientID = "ab1111";
//			body.deviceID = "default";
//			body.deviceType = "light";
//			body.deviceManufacture = "思美特";
//			body.addressID = "4001";
//			body.addressName = "客厅灯光";
//			body.addressValue = "1";
//
//			TCPMessageBody msg = new TCPMessageBody();
//			msg.createTime = "2017-13-22 12:33:44";
//			msg.from = TCPMessageConstant.form_or_to_weiXin;
//			msg.to = TCPMessageConstant.form_or_to_cloud;
//			msg.msgID = "";
//			msg.msgName = TCPMessageConstant.MsgName_Device_Control;
//			msg.subMsgName = TCPMessageConstant.subMsgName_Device_Read;
//			msg.body = body;

//			//物联设备写
//			BodyWriteForAddress body = new BodyWriteForAddress();
//			body.clientID = "ab1111";
//			body.deviceID = "default";
//			body.deviceType = "light";
//			body.deviceManufacture = "物联";
//			body.addressID = "4001";
//			body.addressName = "客厅灯光";
//			body.addressValue = "1";
//
//			TCPMessageBody msg = new TCPMessageBody();
//			msg.createTime = "2017-13-22 12:33:44";
//			msg.from = TCPMessageConstant.form_or_to_weiXin;
//			msg.to = TCPMessageConstant.form_or_to_cloud;
//			msg.msgID = "";
//			msg.msgName = TCPMessageConstant.MsgName_WuLian_Control;
//			msg.subMsgName = TCPMessageConstant.subMsgName_WuLian_Write;
//			msg.body = body;

//			//物联设备读
//			BodyWriteForAddress body = new BodyWriteForAddress();
//			body.clientID = "ab1111";
//			body.deviceID = "default";
//			body.deviceType = "light";
//			body.deviceManufacture = "物联";
//			body.addressID = "4001";
//			body.addressName = "客厅灯光";
//			body.addressValue = "1";
//
//			TCPMessageBody msg = new TCPMessageBody();
//			msg.createTime = "2017-13-22 12:33:44";
//			msg.from = TCPMessageConstant.form_or_to_weiXin;
//			msg.to = TCPMessageConstant.form_or_to_cloud;
//			msg.msgID = "";
//			msg.msgName = TCPMessageConstant.MsgName_WuLian_Control;
//			msg.subMsgName = TCPMessageConstant.subMsgName_WuLian_Read;
//			msg.body = body;

			//物联设备读
			BodyWriteForAddress body = new BodyWriteForAddress();
			body.clientID = "ab1111";
			body.deviceID = "default";
			body.deviceType = "light";
			body.deviceManufacture = "物联";
			body.addressID = "4001";
			body.addressName = "客厅灯光";
			body.addressValue = "1";

			TCPMessageBody msg = new TCPMessageBody();
			msg.createTime = "2017-13-22 12:33:44";
			msg.from = TCPMessageConstant.form_or_to_weiXin;
			msg.to = TCPMessageConstant.form_or_to_cloud;
			msg.msgID = "";
			msg.msgName = TCPMessageConstant.MsgName_IsOnline_Device;
			msg.subMsgName=TCPMessageConstant.subMsgName_Default;
			msg.body = body;

			CallResult retBean = webUI.callCommand(-1, MessageUtil.ToJson(msg), " ");
			
			logTxt = DateUtil.getFormatCurrentDate1() + "[thread线程][" + Thread.currentThread().getName() +"]returnCode:" + retBean.returnCode;
			System.out.println(logTxt);
			logTxt = DateUtil.getFormatCurrentDate1() + "[thread线程][" + Thread.currentThread().getName() +"]returnInfo:" + retBean.returnInfo;
			System.out.println(logTxt);
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		logTxt = DateUtil.getFormatCurrentDate1() + "[thread线程][" + Thread.currentThread().getName() +"]callCommand之后: " +jscmd;
		System.out.println(logTxt);
		closeConnection();
	
	}
}
