package org.example.node2;

public class Main {
    public static void main(String[] args) {
        ReadFile readFile = new ReadFile("alchemy.txt");

//        Пеяать всех элементов
        readFile.readFile();

//        Можно установить любой элемент в цепочке к которому хотим прийти. По умолчанию элемент из задания
//        readFile.setResultElement("Oxygen");

//          Печать всех элментов
//        readFile.printElements();


        System.out.println("Количество реакций для получения  \""  + readFile.resultElement + "\" из \"" +
             readFile.firstElement + "\" = "   +  readFile.qtyStepsTo());


    }
}
