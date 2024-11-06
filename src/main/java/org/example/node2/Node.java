package org.example.node2;

import java.util.Objects;

public class Node {
    String sourceElement;
    String resultOne;
    String ResultTwo;

    @Override
    public String toString() {
        return "Node{" +
                "sourceElement='" + sourceElement + '\'' +
                ", resultOne='" + resultOne + '\'' +
                ", ResultTwo='" + ResultTwo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node2 = (Node) o;
        return Objects.equals(sourceElement, node2.sourceElement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceElement);
    }

    public String getResultOne() {
        return resultOne;
    }

    public void setResultOne(String resultOne) {
        this.resultOne = resultOne;
    }

    public void setResultTwo(String resultTwo) {
        ResultTwo = resultTwo;
    }

    public Node(String sourceElement) {
        this.sourceElement = sourceElement;
    }
}
