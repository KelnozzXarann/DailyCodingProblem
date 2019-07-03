package com.kkindustries.DailyCodingProblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    
    @Test
    void finalTest() {
        Node node = new Node("root", new Node("left", new Node("left.left")), new Node("right"));
        assertTrue(Node.deserialize(Node.serialize(node)).left.left.val == "left.left");
    }

}