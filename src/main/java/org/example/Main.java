package org.example;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile("amchemy.txt");
        readFile.readFile();
//        System.out.println(System.getProperty("user.dir"));
//        readFile.printElements();
        System.out.println(readFile.qtySteps());
    }
}