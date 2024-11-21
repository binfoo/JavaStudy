package thrift.weixin;

import com.google.common.base.Splitter;

import java.util.Iterator;

public class StringUtil {

    public static String lineSeparator = System.getProperty("line.separator", "\n");
    public static String CWMP_ID_SPLIT_CHAR = "_";
    public static String ByteToString(byte[] b)
    {
        return new String(b);
    }

    /**分离出： SpecVersion
     * @param src: InternetGatewayDevice.DeviceInfo.SpecVersion
     * @param splitChar：.
     * @return
     */
    public static String getLastParamString(String src,char splitChar)
    {
        Iterable<String> tokens = Splitter.on(splitChar).split(src);
        Iterator<String> iter = tokens.iterator();
        String s = null;
        while(iter.hasNext()) {
            s = (String)iter.next();
        }
        return s;
    }

    /**服务器收到empty消息后，调用此函数生成新的设备ID，并将该设备ID通过<cwmp:ID>带到设备端
     * @param deviceID
     * @param cmdID
     * @return
     */
    public static String createDeviceID(String deviceID,String cmdID)
    {
        return deviceID + "_" + cmdID;
    }

    /**服务器收到set param response/get param response报文后，调用本接口解析<cwmp:ID>获得命令ID
     * 从
     * @param cwmpID :b0:38:50:00:ab:99_cmdID
     * @return
     */
    public static String getCmdID(String cwmpID)
    {
        String cmdID = null;
        Iterable<String> tokens = Splitter.on(CWMP_ID_SPLIT_CHAR).split(cwmpID);
        Iterator<String>  iter = tokens.iterator();
        if (iter.hasNext())
        {
            iter.next();//跳过mac
        }
        if (iter.hasNext())
        {
            cmdID = (String)iter.next();
        }
        return cmdID;
    }

    /**服务器收到set param response/get param response报文后，调用本接口解析<cwmp:ID>获得命令ID
     * 从
     * @param cwmpID:38:50:00:ab:99_cmdID
     * @return
     */
    public static String getDseviceID(String cwmpID)
    {
        Iterable<String> tokens = Splitter.on(CWMP_ID_SPLIT_CHAR).split(cwmpID);
        Iterator<String>  iter = tokens.iterator();
        String newDeviceID = (String)iter.next();
        return newDeviceID;
    }

    /**将sub替换为with
     * @param s
     * @param sub
     * @param with
     * @return
     */
    public static String replace(String s, String sub, String with)
    {
        return jodd.util.StringUtil.replace(s, sub, with);

    }

    /**大写字符->小写字符/小写字符->大写字符
     * @param str
     * @return
     */
    public static String swapCase(String str) {

        char[] buffer = str.toCharArray();

        for (int i = 0; i < buffer.length; i++) {
            char ch = buffer[i];
            if (Character.isUpperCase(ch)) {
                buffer[i] = Character.toLowerCase(ch);
            } else if (Character.isTitleCase(ch)) {
                buffer[i] = Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                buffer[i] = Character.toUpperCase(ch);
            }
        }
        return new String(buffer);
    }
}
