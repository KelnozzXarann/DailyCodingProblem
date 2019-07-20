# Daily Coding Problem #

I'm doing Problems from [Daily Coding Problem](dailycodingproblem.com)

## Problem

Good morning! Here's your coding interview problem for today.

This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input \[3, 4, -1, 1] should give 2. The input \[1, 2, 0] should give 3.

You can modify the input array in-place.

## My Take

Right of the bat, we write two tests from the problem description.

```java
    @Test
    void findLowestPositiveInteger() {
        LowestPositiveInteger lpi = new LowestPositiveInteger(new Integer[]{3, 4, -1, 1});
        assertEquals(2, lpi.findLowestPositiveInteger());
    }
    
    @Test
    void findLowestPositiveIntegerOne() {
        LowestPositiveInteger lpi = new LowestPositiveInteger(new Integer[]{1, 2, 0});
        assertEquals(3, lpi.findLowestPositiveInteger());
    }
```

So for the solution. We need to look for a sorting algorithm that sorts in linear time and can do it in place.
