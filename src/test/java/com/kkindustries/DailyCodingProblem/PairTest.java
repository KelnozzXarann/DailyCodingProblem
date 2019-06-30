package com.kkindustries.DailyCodingProblem;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PairTest {

    @Test
    void isEqual() {
        Pair<Integer> integerPair = new Pair<>(3,5);
        assertTrue(integerPair.isEqual(5,3));
    }
    @Test
    void isEqualSameNumbers() {
        Pair<Integer> integerPair = new Pair<>(5,5);
        assertTrue(integerPair.isEqual(5,5));
    }
}