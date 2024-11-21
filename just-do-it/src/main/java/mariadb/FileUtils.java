package mariadb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    public FileUtils() {

    }

    public static String readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        String fileContent = "";
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                fileContent = fileContent + tempString;
            }
            reader.close();

            return fileContent;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException localIOException3) {
                }
            }
        }
        return fileContent;
    }

    public static void writeFile(String fileName, String information) {
        FileWriter fw = null;
        BufferedWriter buf = null;
        try {
            fw = new FileWriter(fileName);
            buf = new BufferedWriter(fw);
            buf.write(information);
            return;
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                buf.close();
                fw.close();
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }
    }
}
