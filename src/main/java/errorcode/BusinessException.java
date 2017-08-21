package errorcode;

/**
 * Created by ZhangHongbin on 2017/1/3.
 */
public class BusinessException extends RuntimeException{

    public  BusinessException(Object obj){
        super(obj.toString());
    }

    public static void main(String args[]) {
        Object user = null;
        if(user == null){
            throw new BusinessException(errorcode.ErrorCode.NULL_OBJ);
        }
    }
}
