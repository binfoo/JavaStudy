package tcp.binfoo;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBufUtil;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.net.Socket;

/**
 * Created by ZhangHongbin on 2017/8/24.
 */
public class TcpClient {
    private String host = "139.224.128.240";
    private int port = 7777;
    private Socket socket;
    private RequestBean requestBean;


    public TcpClient() {

    }

    public TcpClient(String host, int port, RequestBean requestBean) {
        if (StringUtils.isNotBlank(host)) {
            this.host = host;
        }

        if (port > 0) {
            this.port = port;
        }
        this.requestBean = requestBean;
    }


    public void initConnect() {

        try {
            socket = new Socket(host, port);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public RequestBean start() {

        initConnect();


        try {
            OutputStream outputStream = socket.getOutputStream();

            byte[] outBytes = LandleafUtils.getMsg(JSON.toJSONString(requestBean).getBytes("UTF-8"));

            System.out.println(JSON.toJSONString(requestBean));
            System.out.println(ByteBufUtil.hexDump(outBytes));

            outputStream.write(outBytes);
            socket.shutdownOutput();//关闭输出流

            //接收数据

            byte[] tempBytes = new byte[2048];

            InputStream inputStream = socket.getInputStream();


            int len = inputStream.read(tempBytes);

            byte[] bytes = new byte[len];

            System.arraycopy(tempBytes, 0, bytes, 0, len);


            System.out.println(ByteBufUtil.hexDump(bytes));

            String jsonString = LandleafUtils.parseBean(bytes);

            System.out.println("jsonString:" + jsonString);

            requestBean = JSON.parseObject(jsonString, RequestBean.class);

            inputStream.close();
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return requestBean;
    }

    public static void main(String[] args) {
        RequestBean requestBean = new RequestBean();

        Msg msg = new Msg();
        msg.setVersion_code("4");
        msg.setApp_key("zhongjiandagongguan");
        msg.setStatus("normal");

        requestBean.setDevice_id("b92de746960db90d");
        requestBean.setFrom(Constant.WEB);
        requestBean.setTo(Constant.CLOUD);
        requestBean.setType(Constant.TYPE_APK_UPDATE);
        requestBean.setMsg(msg);
        requestBean.setMsgAck(new MsgAck());
        requestBean.setApiAck(false);

        TcpClient tcpClient = new TcpClient("", 7777, requestBean);

        requestBean = tcpClient.start();

        System.out.println(requestBean.toString());
    }
}
