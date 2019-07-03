package com.kkindustries.DailyCodingProblem;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayMultiplierTest {
    @Test
    void multiplyArrayByItselfPreviewOne() {
        ArrayMultiplier arrayMultiplier = new ArrayMultiplier(1, 2, 3, 4, 5);
        Integer[] correctResult = {120, 60, 40, 30, 24};
        Integer[] actualResult = arrayMultiplier.multiplyArrayByItself();
        assertArrayEquals(correctResult, actualResult,
                String.format("Array multiplier result: %s was expecting %s", Arrays.toString(actualResult), Arrays.toString(correctResult))
        );

    }
    @Test
    void multiplyArrayByItselfPreviewTwo() {
        ArrayMultiplier arrayMultiplier = new ArrayMultiplier(3, 2, 1);
        Integer[] correctResult = {2, 3, 6};
        Integer[] actualResult = arrayMultiplier.multiplyArrayByItself();
        assertArrayEquals(correctResult, actualResult,
                String.format("Array multiplier result: %s was expecting %s", Arrays.toString(actualResult), Arrays.toString(correctResult))
        );

    }
    @Test
    void multiplyArrayByItselfIncludeZero() {
        ArrayMultiplier arrayMultiplier = new ArrayMultiplier(3, 2, 0);
        Integer[] correctResult = {0, 0, 6};
        Integer[] actualResult = arrayMultiplier.multiplyArrayByItself();
        assertArrayEquals(correctResult, actualResult,
                String.format("Array multiplier result: %s was expecting %s", Arrays.toString(actualResult), Arrays.toString(correctResult))
        );
    }
    @Test
    void multiplyArrayByItselfIncludeTwoZeros() {
        ArrayMultiplier arrayMultiplier = new ArrayMultiplier(3, 0, 0);
        Integer[] correctResult = {0, 0, 0};
        Integer[] actualResult = arrayMultiplier.multiplyArrayByItself();
        assertArrayEquals(correctResult, actualResult,
                String.format("Array multiplier result: %s was expecting %s", Arrays.toString(actualResult), Arrays.toString(correctResult))

        );
    }




    @Test
    void multiplyArrayByItselfNoDivisionPreviewOne() {
        ArrayMultiplier arrayMultiplier = new ArrayMultiplier(1, 2, 3, 4, 5);
        Integer[] correctResult = {120, 60, 40, 30, 24};
        Integer[] actualResult = arrayMultiplier.multiplyArrayByItselfNoDivision();
        assertArrayEquals(correctResult, actualResult,
                String.format("Array multiplier result: %s was expecting %s", Arrays.toString(actualResult), Arrays.toString(correctResult))
        );

    }
    @Test
    void multiplyArrayByItselfNoDivisionPreviewTwo() {
        ArrayMultiplier arrayMultiplier = new ArrayMultiplier(3, 2, 1);
        Integer[] correctResult = {2, 3, 6};
        Integer[] actualResult = arrayMultiplier.multiplyArrayByItselfNoDivision();
        assertArrayEquals(correctResult, actualResult,
                String.format("Array multiplier result: %s was expecting %s", Arrays.toString(actualResult), Arrays.toString(correctResult))
        );

    }
    @Test
    void multiplyArrayByItselfNoDivisionIncludeZero() {
        ArrayMultiplier arrayMultiplier = new ArrayMultiplier(3, 2, 0);
        Integer[] correctResult = {0, 0, 6};
        Integer[] actualResult = arrayMultiplier.multiplyArrayByItselfNoDivision();
        assertArrayEquals(correctResult, actualResult,
                String.format("Array multiplier result: %s was expecting %s", Arrays.toString(actualResult), Arrays.toString(correctResult))
        );
    }
    @Test
    void multiplyArrayByItselfNoDivisionIncludeTwoZeros() {
        ArrayMultiplier arrayMultiplier = new ArrayMultiplier(3, 0, 0);
        Integer[] correctResult = {0, 0, 0};
        Integer[] actualResult = arrayMultiplier.multiplyArrayByItselfNoDivision();
        assertArrayEquals(correctResult, actualResult,
                String.format("Array multiplier result: %s was expecting %s", Arrays.toString(actualResult), Arrays.toString(correctResult))

        );
    }
}