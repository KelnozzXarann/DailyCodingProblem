package com.kkindustries.DailyCodingProblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumOfArray {
    private Integer[] ints;
    private Set<Integer> integerMap = new HashSet<>();
    public SumOfArray(Integer[] ints) {
        this.ints = ints;
        integerMap.addAll(Arrays.asList(ints));
    }

    public Pair<Integer> getPairTo(Integer sum) throws PairInArrayNotFoundException {
        for(Integer i: ints){
            Integer remainder = sum - i;
            if(integerMap.contains(remainder)){
                if(remainder.equals(i) && integerMap.size() == ints.length){
                    continue;
                }
                return new Pair<>(i, remainder);
            }
        }
        throw new PairInArrayNotFoundException(ints, sum);
    }
}
