package org.example;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        readFile.readFile();
//        System.out.println(System.getProperty("user.dir"));
        readFile.printElements();
    }
}