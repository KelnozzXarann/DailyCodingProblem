package com.kkindustries.DailyCodingProblem;

/**
 * The PairInArrayNotFoundException exception thrown when given array
 * does not contain elements that sum up to expected value
 */
public class PairInArrayNotFoundException extends Exception {
    public PairInArrayNotFoundException(Integer[] ints, Integer sum) {
        super(String.format("Sum of %d is not found in array %s", sum, ints));
    }
}
