package com.kkindustries.DailyCodingProblem;

public class Pair<T> {
    private     T firstElement;
    private     T secondElement;

    public Pair(T firstElement, T secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public boolean isEqual(T first, T second) {
       if (first.equals(firstElement)){
           if (second.equals(secondElement)){
               return true;
           }
       } else if(first.equals(secondElement)){
           if (second.equals(firstElement)) {
               return true;
           }
       }
       return false;
    }
    public T getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(T firstElement) {
        this.firstElement = firstElement;
    }

    public T getSecondElement() {
        return secondElement;
    }

    public void setSecondElement(T secondElement) {
        this.secondElement = secondElement;
    }
}
