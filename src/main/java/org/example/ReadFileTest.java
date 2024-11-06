package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {
    @Test
    public void createNode(){
        Node node = new Node("Aurum");
        ReadFile readFile = new ReadFile("alchemy.txt");
        Node aurum = readFile.createNode("Aurum", null);

        Assertions.assertEquals (node, aurum);
    }

}