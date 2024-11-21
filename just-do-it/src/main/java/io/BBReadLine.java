package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ZhangHongbin on 2017/7/26.
 */
public class BBReadLine {
    public static void main(String[] args) throws IOException {
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("开始输入字符串，并打印");
        System.out.println("遇到‘end’停止打印");

        do {
            str = br.readLine();
            System.out.println(str);

        }while (!str.equals("end"));
    }
}
