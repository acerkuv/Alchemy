package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Pattern;

public class ReadFile {
    String fileName;
    String firstElement;
    String resultElement;
   List<Node> elements = new ArrayList<>();

    public ReadFile(String fileName) {
        this.fileName = fileName;
    }

    public void readFile() {

        File file = new File(fileName);
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

    public void setFirstElement(String firstElement) {
        this.firstElement = firstElement;
    }

    public void setResultElement(String resultElement) {
        this.resultElement = resultElement;
    }

    private void readInLie(String line) {

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
// Элементы задания из которого в какой нужно пройти
        } else if (Pattern.matches("[A-Z]{1}.+", line)) {
            if (firstElement==null){
                firstElement = line;

            }else {
                resultElement = line;
            }
        }


    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ReadFile readFile = (ReadFile) object;
        return Objects.equals(firstElement, readFile.firstElement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstElement);
    }

    //Создаем новый объект
    public Node createNode(String source, String result) {
        Node sourceNode = new Node(source);
        if (result != null) {
            Node resulNode = new Node(result);
            sourceNode.setResultOne(resulNode);
        }
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
    public int qtySteps(){
        int steps = 0;
        Node first =  getNodeFromElements(firstElement);
        Node result = getNodeFromElements(resultElement);

//        Правый обход
        Node currentNode = first;
        while (true){
            assert currentNode != null;
            if(currentNode.getResultTwo().equals(result) || currentNode.getResultOne().equals(result)) {
                steps++;
                break;
            }
// проверка достижения конца уепочки
            else if (currentNode.sourceElement==null) {
                    break;
            } else {
                currentNode = currentNode.getResultOne();

                }

            }
        return steps;
        }



    }




