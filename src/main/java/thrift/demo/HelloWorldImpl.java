package thrift.demo;

import org.apache.thrift.TException;

/**
 * Created by ZhangHongbin on 2017/1/17.
 */

public class HelloWorldImpl implements HelloWorldService.Iface {

    public HelloWorldImpl() {
    }

    @Override
    public String sayHello(String username) throws TException {
        return "Hi," + username + " welcome to landleaf！";
    }

}
