package thrift.weixin;


import java.io.File;

public class PathUtil {
    /**获得项目的绝对路径
     * @return
     */
    public static String getAbsProjectPath()
    {
        File file=new File("");
        String  absProjectPath=file.getAbsolutePath();
        System.out.println("项目路径：" + absProjectPath);
        return absProjectPath;
    }

    public static void main(String[] args) {
        getAbsProjectPath();
    }
}