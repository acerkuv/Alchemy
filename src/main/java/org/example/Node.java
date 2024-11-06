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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Node node = (Node) object;
        return Objects.equals(sourceElement, node.sourceElement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceElement);
    }

    @Override
    public String toString() {
        return "Node{" +
                "sourceElement='" + sourceElement + '\'' +
                ", resultOne=" + resultOne +
                ", ResultTwo=" + ResultTwo +
                '}';
    }


}
