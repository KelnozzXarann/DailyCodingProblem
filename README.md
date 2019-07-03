# Daily Coding Problem #

I'm doing Problems from [Daily Coding Problem](dailycodingproblem.com)

## Problem

Good morning! Here's your coding interview problem for today.

This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was \[1, 2, 3, 4, 5], the expected output would be \[120, 60, 40, 30, 24]. If our input was \[3, 2, 1], the expected output would be \[2, 3, 6].

Follow-up: what if you can't use division?

## My Take

So first things first we got two tests from the description

```java
    @Test
    void multiplyArrayByItselfPreviewOne() {
        ArrayMultiplier arrayMultiplier = new ArrayMultiplier(1, 2, 3, 4, 5);
        Integer[] correctResult = {120, 60, 40, 30, 24};
        Integer[] actualResult = arrayMultiplier.multiplyArrayByItself();
        assertArrayEquals(correctResult, actualResult,
                String.format("Array multiplier result: %s was expecting %s", Arrays.toString(correctResult), Arrays.toString(actualResult))
        );

    }
    @Test
    void multiplyArrayByItselfPreviewTwo() {
        ArrayMultiplier arrayMultiplier = new ArrayMultiplier(3, 2, 1);
        Integer[] correctResult = {2, 3, 6};
        Integer[] actualResult = arrayMultiplier.multiplyArrayByItself();
        assertArrayEquals(correctResult, actualResult,
                String.format("Array multiplier result: %s was expecting %s", Arrays.toString(correctResult), Arrays.toString(actualResult))
        );

    }
```

First solution is almost dictated by the follow up clause. The time complexity is O(N). It's presented directly below
```java
    public Integer[] multiplyArrayByItself(){
        Integer multiplyAll=1;
        for(Integer i:integers){
           multiplyAll*=i;
        }
        Integer[] result = new Integer[integers.length];
        for (int i=0; i<result.length;i++){
            result[i] = multiplyAll/integers[i];
        }
        return result;
    }
```
There is no need to look to closely at this as it lacks most basic safe guard that should be implemented when dealing with division. 
Next test we write will fail.

```java
    @Test
    void multiplyArrayByItselfIncludeZero() {
        ArrayMultiplier arrayMultiplier = new ArrayMultiplier(3, 2, 0);
        Integer[] correctResult = {0, 0, 6};
        Integer[] actualResult = arrayMultiplier.multiplyArrayByItself();
        assertArrayEquals(correctResult, actualResult,
                String.format("Array multiplier result: %s was expecting %s", Arrays.toString(correctResult), Arrays.toString(actualResult))
        );
    }
```
You have to safe against one and two zero arrays. Array with one zero will not be filled with zeros!
 It will have one different number at the same index zero used to reside. To check if array with two zeros is processed correctly
 I've added a test.
```java
    @Test
    void multiplyArrayByItselfIncludeTwoZeros() {
        ArrayMultiplier arrayMultiplier = new ArrayMultiplier(3, 0, 0);
        Integer[] correctResult = {0, 0, 0};
        Integer[] actualResult = arrayMultiplier.multiplyArrayByItself();
        assertArrayEquals(correctResult, actualResult,
                String.format("Array multiplier result: %s was expecting %s", Arrays.toString(actualResult), Arrays.toString(correctResult))

        );
    }
```

And since we have a clear objective it is time to go back to the implementation. This is something I came up with.

```java
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
```

But the follow up clause specifically said we shouldn't use division. And so the search for next solution ensues

First of all I've copied all of the tests so we'll have nice base for checking.

Algorithm is the same as in this brilliant answer on [stackOverflow](https://stackoverflow.com/a/2680697)

What we want to accomplish:

Given the array \[a ,b ,c ,d]

We want an array result with:

    result[0] = 1 * b * c * d
    result[1] = a * 1 * c * d
    result[2] = a * b * 1 * d
    result[3] = a * b * c * 1

And so if we split each row on number one we get:

First:

    start\[0] = 1
    start\[1] = a * 1
    start\[2] = a * b * 1
    start\[3] = a * b * c * 1

Second:

    end[0] = 1 * b * c * d
    end[1] = 1 * 1 * c * d
    end[2] = 1 * 1 * 1 * d
    end[3] = 1 * 1 * 1 * 1

And if we multiply rows with the same index we will get the result.

Now we know we can prepare these in a single pass. We need two variables
 to iterate over, one will go from last index, the other from first.
 to illustrate that I will go through this iteration with single array:
 
 Pass 1:
 
    startMultiplier = 1
    start[0] = 1

 Pass 2:
 
    startMultiplier = start[0]
    start[1] = 1 * startMultiplier

 Pass 3:
 
    startMultiplier = start[1] * startMultiplier
    start[2] = 1 * startMultiplier

 Pass 4:
 
    startMultiplier = start[2] * startMultiplier
    start[3] = 1 * startMultiplier
    
    
Then we put it all together and my result is:

```java
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
``` 
All the tests are passing and we have achieved O(N) time complexity!