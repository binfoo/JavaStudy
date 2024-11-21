package thrift.weixin;

/**TCP消息体
 * @author 董志勇
 *
 */
public class TCPMessageBody {
    public String createTime;//创建时间
    public String from;//消息源头
    public String to;//消息目的地
    public String msgID;//消息编号
    public String msgName;//消息名称
    public String subMsgName;//子消息名称
    public Object body;//消息体
    public Object bodyAck;//消息体应答

    public String toString()
    {
        String info =   "{createTime: " + createTime + LogUtil.lineSeparator +
                ",from: " + from +  LogUtil.lineSeparator +
                ",to: " +to + LogUtil.lineSeparator +
                ",msgID: " +msgID + LogUtil.lineSeparator +
                ",msgName: " +msgName + LogUtil.lineSeparator +
                ",subMsgName: " +subMsgName + LogUtil.lineSeparator +
                ",body: " +body.toString() + LogUtil.lineSeparator ;
        if (bodyAck != null)
        {
            info = info + ",bodyAck: " +bodyAck.toString() + LogUtil.lineSeparator;
        }
        info = info + "}";
        return info;
    }
}