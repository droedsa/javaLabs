package com.company;

import com.company.SumThreadNumber;

public class MaltyThreadSum {
    int numberOfThreads = 10;

    public int Sum(int[] arr) throws InterruptedException {
        int middleIndex = arr.length / numberOfThreads;

        SumThreadNumber[] Thread = new SumThreadNumber[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            int beginIndex = i * middleIndex;
            int endIndex = (i + 1) * middleIndex;
            if (endIndex > arr.length) endIndex = arr.length;
            Thread[i] = new SumThreadNumber(beginIndex, endIndex, arr);
            Thread[i].start();
        }

        int sum = 0;
        for (int i = 0; i < numberOfThreads; i++) {
            Thread[i].join();
            sum += Thread[i].Res();
        }
        return sum;
    }
}