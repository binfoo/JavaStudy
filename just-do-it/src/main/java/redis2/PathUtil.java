package redis2;

import java.io.File;
import java.io.IOException;

public class PathUtil {
    public PathUtil() {
    }

    public static String getAbsProjectPath() {
        File file = new File("");
        String absProjectPath = file.getAbsolutePath();
        System.out.println("项目路径：" + absProjectPath);
        return absProjectPath;
    }

    public static String getProjectPath() {
        File file = new File("");
        String projectPath = file.getPath();
        System.out.println("项目路径：" + projectPath);
        return projectPath;
    }

    public static String getCanonicalPath() {
        File file = new File("");
        String projectPath = null;
        try {
            projectPath = file.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("项目路径：" + projectPath);
        return projectPath;
    }

    public static void main(String[] args) {
        System.out.println(getAbsProjectPath());
        System.out.println(getProjectPath());

        System.out.println(getCanonicalPath());
    }
}