package service.demo;

import org.apache.thrift.async.AsyncMethodCallback;

/**
 * Created by ZhangHongbin on 2017/2/16.
 */
public class MethodCallback implements AsyncMethodCallback{

    Object response = null;

    public  Object getResult(){

        // 返回结果值
        return  this.response;
    }
    @Override
    public void onComplete(Object response) {

        this.response = response;


    }

    @Override
    public void onError(Exception e) {

    }
}
