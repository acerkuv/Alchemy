package org.example;

import java.util.Objects;

public class Node {
    String sourceElement;
    Node resultOne;
    Node ResultTwo;


    public Node(String sourceElement) {
        this.sourceElement = sourceElement;
    }


    public void setResultOne(Node resultOne) {
        this.resultOne = resultOne;
    }

    public Node getResultTwo() {
        return ResultTwo;
    }

    public void setResultTwo(Node resultTwo) {
        ResultTwo = resultTwo;
    }

    public Node getResultOne() {
        return resultOne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(sourceElement, node.sourceElement);
    }

    @Override
    public String toString() {
        return "Node{" +
                "sourceElement='" + sourceElement + '\'' +
                ", resultOne=" + resultOne +
                ", ResultTwo=" + ResultTwo +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceElement);
    }
}
