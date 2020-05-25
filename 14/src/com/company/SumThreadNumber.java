package com.company;

public class SumThreadNumber extends Thread {
    int beginIndex;
    int endIndex;
    int[] array;
    int result;

    public SumThreadNumber(int first, int last, int[] arr) {
        this.beginIndex = first;
        this.endIndex = last;
        array = arr;
    }

    @Override
    public void run() {
        for (int i = beginIndex; i < endIndex; i++) {
            result += array[i];
        }
    }

    public int Res() {
        return result;
    }
}