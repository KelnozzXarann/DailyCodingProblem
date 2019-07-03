package com.kkindustries.DailyCodingProblem;

public class Node {
    String val;
    Node left;
    Node right;

    public Node(String val) {
        this.val = val;
    }

    public Node(String val, Node left) {
        this.val = val;
        this.left = left;
    }

    public Node(String val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String getVal() {
        return val;
    }
    public static String serialize(Node node){
        return null;
    }
    public static Node deserialize(String serializedNode){
        return null;
    }
}
