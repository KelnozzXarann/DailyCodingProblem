package com.kkindustries.DailyCodingProblem;

public class LowestPositiveInteger {
    private int[] array;

    public LowestPositiveInteger(int[] array) {
        this.array = array;
    }

    public int findLowestPositiveint() {
        int lowestPositiveInt = 1;
        heapSort();
        for (int i:array){
            if (i == lowestPositiveInt){
                lowestPositiveInt++;
            }else if (i > lowestPositiveInt){
                return lowestPositiveInt;
            }
        }
        return lowestPositiveInt;
    }

    public int[] heapSort(){
        int n = array.length;
        int branch = (n/2-1);
        for (int i = branch; i >= 0; i--) {
            heapify(i, n);
        }
        swap(0,--n);
        while(n >= 1) {
            heapify(0, n);
            swap(0,--n);
        }
        return array;
    }

    private void heapify(int currentRoot, int length) {
        int indexOfMaxValue = currentRoot;
        int leftChildIndex = currentRoot*2+1;
        int rightChildIndex = currentRoot*2+2;
        if(leftChildIndex<length && array[indexOfMaxValue]<array[leftChildIndex]){
            indexOfMaxValue = leftChildIndex;
        }
        if(rightChildIndex<length && array[indexOfMaxValue]<array[rightChildIndex]){
            indexOfMaxValue = rightChildIndex;
        }
        if(currentRoot != indexOfMaxValue){
            swap(indexOfMaxValue, currentRoot);
            heapify(indexOfMaxValue, length);
        }
    }

    private void swap(int swapOne, int swapTwo) {
        int tmp = array[swapOne];
        array[swapOne] = array[swapTwo];
        array[swapTwo] = tmp;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }
}
