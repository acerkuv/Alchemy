package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class ReadFile {
    String fileName;
   List<Node> elements = new ArrayList<>();

    public void readFile() {

        File file = new File("amchemy.txt");
        Charset charset = StandardCharsets.US_ASCII;
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                readInLie(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

    }

    private void readInLie(String line) {
        System.out.println(line);
        if (Pattern.matches("[A-Z]{1}.+[A-Z]{1}.+", line)) {
            String[] lines = line.split(" -> ");

// проверяем есть ли уже в листе такой обьект
            boolean b = isInElements(new Node(lines[0]));
//            Если элеиннта нет, то добавляем

            if(!b) {
                Node node = createNode(lines[0], lines[1]);
                elements.add(node);
            }
//            Если элементуже есть, то проверяем есть ли второй результат
            else{
                Node node = getNodeFromElements(lines[0]);
                assert node != null;
                node.setResultTwo(new Node(lines[1]));
            }

        }



    }
//Создаем новый объект
    private Node createNode(String source, String result) {
        Node sourceNode = new Node(source);
        Node resulNode = new Node(result);
        sourceNode.setResultOne(resulNode);
        return sourceNode;
    }
    private boolean isInElements(Node node){
        for (Node n: elements) if (node.equals(n)) return true;
        return false;

    }
//    Получить едемент из листа
    private Node getNodeFromElements(String name){
        Node temp = new Node(name);
        for (Node n: elements) if (temp.equals(n)) return n;
        return null;
    }
    public void printElements(){
        for(Node n: elements) System.out.println(n.toString());
    }

}
