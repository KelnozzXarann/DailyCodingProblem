package com.kkindustries.DailyCodingProblem;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SumOfArrayTest {
    private int sum;
    private SumOfArray sumOfArray;

    @Test
    void getPairTo() throws PairInArrayNotFoundException {
        initArrayAndSum(17, 10, 15, 3, 7);

        assertTrue(sumOfArray.getPairTo(sum).isEqual(10,7),
                "This tests if pair can be created");
    }

    @Test
    void getPairToException(){
        initArrayAndSum(50, 10, 15, 3, 7);
        assertThrows(PairInArrayNotFoundException.class, () -> sumOfArray.getPairTo(sum),
                "This tests if exception is thrown correctly");
    }

    @Test
    void getPairToOne() {
        initArrayAndSum(10, 5);

        assertThrows(PairInArrayNotFoundException.class, () -> sumOfArray.getPairTo(sum),
                "This tests if pair can be created with one element");
    }
    @Test
    void getPairToTwo() throws PairInArrayNotFoundException {
        initArrayAndSum(10, 5, 5, 3, 7);

        assertTrue(sumOfArray.getPairTo(sum).isEqual(5,5),
                "This tests if works with duplicates");
    }
    @Test
    void getPairToThree() {
        initArrayAndSum(10, 5, 4, 4, 7);

        assertThrows(PairInArrayNotFoundException.class, () -> sumOfArray.getPairTo(sum),
                "This tests if pair can be created with one element");
    }
    @Test
    void getPairToNegativeNumbers() throws PairInArrayNotFoundException {
        initArrayAndSum(4,10, 15, -3, 7);

        assertTrue(sumOfArray.getPairTo(sum).isEqual(-3,7),
                "This tests if pair can be created with negative numbers");
    }

    private void initArrayAndSum(int sum, Integer... ints) {
        this.sum = sum;
        sumOfArray = new SumOfArray(ints);
    }
}