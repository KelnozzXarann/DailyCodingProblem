package com.kkindustries.DailyCodingProblem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LowestPositiveIntegerTest {

//    For example, the input \[3, 4, -1, 1] should give 2. The input \[1, 2, 0] should give 3.
    @Test
    void findLowestPositiveInteger() {
        LowestPositiveInteger lpi = new LowestPositiveInteger(new int[]{3, 4, -1, 1});
        assertEquals(2, lpi.findLowestPositiveint());
    }

    @Test
    void findLowestPositiveIntegerOne() {
        LowestPositiveInteger lpi = new LowestPositiveInteger(new int[]{1, 2, 0});
        assertEquals(3, lpi.findLowestPositiveint());
    }
    @Test
    void sortTest() {
        LowestPositiveInteger lpi = new LowestPositiveInteger(new int[]{7, 8, 0, 6, 8, 67, 5, 45, 34, 76, 25, 6876, 14, 36});
        assertArrayEquals(new int[]{0, 5, 6, 7, 8, 8, 14, 25, 34, 36, 45, 67, 76, 6876}, lpi.heapSort());
    }
}