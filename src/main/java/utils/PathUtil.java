package utils;
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.File;


import java.io.File;

public class PathUtil {
    public PathUtil() {
    }

    public static String getAbsProjectPath() {
        File file = new File("");
        String absProjectPath = file.getAbsolutePath();
        System.out.println("项目路径：" + absProjectPath);
        return absProjectPath;
    }

    public static void main(String[] args) {
        getAbsProjectPath();
    }
}
