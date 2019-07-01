package com.kkindustries.DailyCodingProblem;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayMultiplierTest {


    @Test
    void multiplyArrayByItself() {
        ArrayMultiplier arrayMultiplier = new ArrayMultiplier(1, 2, 3, 4, 5);
        Integer[] correctResult = {120, 60, 40, 30, 24};
        Integer[] actualResult = arrayMultiplier.multiplyArrayByItself();
        assertArrayEquals(actualResult, correctResult,
                String.format("Array multiplier result: %s was expecting %s", actualResult, correctResult));

    }
}