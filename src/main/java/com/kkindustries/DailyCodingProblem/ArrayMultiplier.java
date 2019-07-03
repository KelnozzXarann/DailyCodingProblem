package com.kkindustries.DailyCodingProblem;

import java.util.Arrays;

public class ArrayMultiplier {
    private Integer[] integers;

    public ArrayMultiplier(Integer... integers) {
        this.integers = integers;
    }

    public Integer[] multiplyArrayByItself(){
        Integer multiplyAll=1;
        Integer[] result = new Integer[integers.length];
        boolean containsZero = false;
        int zeroIndex = 0;
        for(int i=0;i<integers.length;i++){
            if(integers[i] != 0) {
                multiplyAll *= integers[i];
            }
            else {
                if (containsZero){
                    Arrays.fill(result,0);
                    return result;
                }
                containsZero = true;
                zeroIndex = i;
            }
        }
        if (containsZero){
            Arrays.fill(result,0);
            result[zeroIndex] = multiplyAll;
            return result;
        }
        for (int i=0; i<result.length;i++){
            result[i] = multiplyAll/integers[i];
        }
        return result;
    }
    public Integer[] multiplyArrayByItselfNoDivision(){
        Integer[] result = new Integer[integers.length];
        Integer[] startToEnd = new Integer[integers.length];
        Integer[] endToStart = new Integer[integers.length];
        int startMultiplier = 1;
        int endMultiplier = 1;
        int j;
        for (int i = 0; i < integers.length; i++) {
            j = integers.length - i - 1;
            if (i>0) {
                startMultiplier*=integers[i-1];
                endMultiplier*=integers[j+1];
            }
            startToEnd[i] = startMultiplier;
            endToStart[j] = endMultiplier;
        }
        for (int i = 0; i < result.length; i++){
            result[i] = startToEnd[i] * endToStart[i];
        }
        return result;
    }
}
