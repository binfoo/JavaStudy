package errorcode;

/**
 * Created by ZhangHongbin on 2017/1/3.
 */
public enum  ErrorCode {

    NULL_OBJ("LUO001","对象为空"),
    ERROR_ADD_USER("LUO002","添加用户失败"),
    UNKNOWN_ERROR("LUO999","系统繁忙，请稍后再试....");

    private String errorCode;
    private String errorMsg;

    ErrorCode(String errorCode, String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;

    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static void main(String[] args) {
        System.out.println(ErrorCode.NULL_OBJ.getErrorCode());
        System.out.println(ErrorCode.NULL_OBJ.getErrorMsg());
    }

}
