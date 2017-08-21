package mariadb;

import java.io.File;
import java.io.PrintStream;

public class PathUtil
{
    public static String getAbsProjectPath()
    {
        File file = new File("");
        String absProjectPath = file.getAbsolutePath();
        System.out.println("项目路径：" + absProjectPath);
        return absProjectPath;
    }

    public static void main(String[] args){

        getAbsProjectPath();
    }

}
