package serializable;

import java.io.*;

/**
 * Created by ZhangHongbin on 2016/12/30.
 */
public class Employee implements Serializable {
    public String name;
    public String address;
    public transient int SSN;
    public int number;

    public void mailCheck() {
        System.out.println("Mailing a check to " + name
                + " " + address);
    }
}

class SerializeDemo {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "Reyan Ali";
        e.address = "Phokka Kuan, Ambehta Peer";
        e.SSN = 11122333;
        e.number = 101;

        try {
            FileOutputStream fileOut = new FileOutputStream("employee.ser");

            try {
                ObjectOutput objectOutput = new ObjectOutputStream(fileOut);
                objectOutput.writeObject(e);
                objectOutput.close();
                fileOut.close();
                System.out.println("Serialized data is saved in employee.ser");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }
}


class DeSerializeDemo {
    public static void main(String[] args) {

        try {
            FileInputStream file = new FileInputStream("employee.ser");

            try {
                ObjectInput oi = new ObjectInputStream(file);

                try {
                    Employee e = (Employee) oi.readObject();


                    e.mailCheck();

                    System.out.printf("name = %s,address = %s,SSN = %d,number = %d",e.name,e.address,e.SSN,e.number);



                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}