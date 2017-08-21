package com.company;


import java.util.Date;

public class Main {

    public static void main(String args[]) {
        char[] helloArray = {'h', 'e', 'l', 'l', 'o', '.'};
        String helloString = new String(helloArray);
        System.out.println(helloString);
        System.out.print("length is " + helloString.length());
        System.out.println("\n" + helloString.toUpperCase());

        double[] myList;
        myList = new double[]{1.9, 2.9, 3.4, 3.5};

        // Print all the array elements
        for (double element : myList) {
            System.out.println(element);
        }

        String[] sArray = {"1", "2", "3", "4"};
        for (String i : sArray) {
            System.out.println(i);
        }

        Date date = new Date();
        System.out.println(date.toString());
    }
}