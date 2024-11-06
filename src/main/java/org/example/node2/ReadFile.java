package org.example.node2;



import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class ReadFile {
    String fileName;
    String firstElement;

    public void setResultElement(String resultElement) {
        this.resultElement = resultElement;
    }

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


    private void readInLie(String line) {

        if (Pattern.matches("[A-Z]{1}.+[A-Z]{1}.+", line)) {
            String[] lines = line.split(" -> ");

// проверяем есть ли уже в листе такой обьект
            boolean b = isInElements(new Node(lines[0]));
//            Если элеиннта нет, то добавляем

            if (!b) {
                Node n = new Node(lines[0]);
                n.setResultOne(lines[1]);
                elements.add(n);
            }
//            Если элементуже есть, то проверяем есть ли второй результат
            else {
                Node node = getNodeFromElements(lines[0]);
                assert node != null;
                node.setResultTwo(lines[1]);
            }
// Элементы задания из которого в какой нужно пройти
        } else if (Pattern.matches("[A-Z]{1}.+", line)) {
            if (firstElement == null) {
                firstElement = line;
            } else {
                resultElement = line;
//                Добавить вручную последний элемент
                elements.add(new Node(line));
            }
        }

    }

    public Node getNodeFromElements(String line) {
        Node temp = new Node(line);
        for (Node n : elements) if (temp.equals(n)) return n;
        return null;
    }
    private boolean isInElements(Node node) {
        for (Node n : elements) if (node.equals(n)) return true;
        return false;
    }
//    Вывод всех элменотов Node
    public void printElements(){
        for (Node n: elements) System.out.println(n.toString() + "\n");
    }
//    Обход ** пока обходим только по правой стороне "furstElenent"
    public int qtyStepsTo(){
        int steps = 0;
        Node from = getNodeFromElements(firstElement);
        Node to  = getNodeFromElements(resultElement);
        Node current = from;
//        Сравниваем все элементы с целевым
        while(true){
//            Если мы нашли нужный элемент прерываем while()
            if(isTheGoal(current, to)){
                steps++;
                break;
            }
//            Если конечный элемент в реациии выходим - не нашли нужный
            else if(Objects.isNull(getNodeFromElements(current.resultOne)) &&
                        Objects.isNull(getNodeFromElements(current.resultOne))){
                        steps = 0;
                        break;

            }
//            Если это не целевой элемент, то идем по леому краю
            else if(!isTheGoal(current, to)) {
                current = getNodeFromElements(current.getResultOne());
                steps++;
            }
//            Если целевой элемент, то УРА! Авходим
            else if(isTheGoal(current, to)){
                steps++;
                break;
            }

        }
        return steps;
        }
//        Поверка временного элемента "current" - он нша цель или нет?
        public boolean isTheGoal(Node current, Node to){
            if (current.equals(to)) return true;
            else if (current.resultOne.equals(to.sourceElement)) {
                return true;
            }
            return false;

        }

    }






