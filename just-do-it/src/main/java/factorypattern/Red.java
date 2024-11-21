package factorypattern;


/**
 * Created by ZhangHongbin on 2017/1/5.
 */
public class Red implements Color{

    @Override
    public void fill() {
        System.out.println("RED:调用方法fill");
    }
}


class Green implements Color{

    @Override
    public void fill() {
        System.out.println("Green:调用方法fill");
    }
}

class Blue implements Color{

    @Override
    public void fill() {
        System.out.println("Blue:调用方法fill");
    }
}