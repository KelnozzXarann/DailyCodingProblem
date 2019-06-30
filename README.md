# Daily Coding Problem #1

I'm doing Problems from [Daily Coding Problem][dailycodingproblem.com]

## Problem

Good morning! Here's your coding interview problem for today.

This problem was recently asked by Google.

Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given \[10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?

## My Take

After the initial test:

``` java
    @Test
    void getPairTo() throws PairInArrayNotFoundException {
        initArrayAndSum(17, 10, 15, 3, 7);

        assertTrue(sumOfArray.getPairTo(sum).isEqual(10,7),
                "This tests if pair can be created");
    }
    
    private void initArrayAndSum(int sum, Integer... ints) {
        this.sum = sum;
        sumOfArray = new SumOfArray(ints);
    }
```
I've written this simple solution. Many times when we need single pass and O(N) complexity we can use HashSet/HashMap.

```java 
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
                return new Pair<>(i, remainder);
            }
        }
        throw new PairInArrayNotFoundException(ints, sum);
    }
}
```

But I had a problem with this solution. We don't check for situation 
where contains returns us the same number we are currently on!

So I've written next test:
```java 
    @Test
    void getPairToOne() {
        initArrayAndSum(10, 5);

        assertThrows(PairInArrayNotFoundException.class, () -> sumOfArray.getPairTo(sum),
                "This tests if pair can be created with one element");
    }
```

And obviously it failed. My response was adding 3 lines in getPairTo method
```java
    public Pair<Integer> getPairTo(Integer sum) throws PairInArrayNotFoundException {
        for(Integer i: ints){
            Integer remainder = sum - i;
            if(integerMap.contains(remainder)){
                //New part
                if(remainder.equals(i) && integerMap.size() == ints.length){
                    continue;
                }
                
                return new Pair<>(i, remainder);
            }
        }
        throw new PairInArrayNotFoundException(ints, sum);
    }
```

All is well, no failed tests anymore. But then it started bugging me... So it's time for another test

```java
    @Test
    void getPairToThree() {
        initArrayAndSum(10, 5, 4, 4, 7);

        assertThrows(PairInArrayNotFoundException.class, () -> sumOfArray.getPairTo(sum),
                "This tests if pair can be created with one element");
    }
```
New fail