package io;

import java.io.*;

/**
 * Created by ZhangHongbin on 2017/7/26.
 */
public class FileStreamTest {
    public static void main(String[] args) {
        String str = "我是好人";
        byte[] bWrite = str.getBytes();
        try {
            OutputStream os = new FileOutputStream("test.txt");
            for (int i = 0; i < bWrite.length; i++) {
                os.write(bWrite[i]);
            }

            os.close();

            InputStream is = new FileInputStream("test.txt");

            int length = is.available();

            byte[] array = new byte[length];


            is.read(array);
            

            System.out.println("读取文件 ： " + new String(array));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
