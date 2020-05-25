package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.out.print("Enter Arr length: ");
        Scanner sc = new Scanner(System.in);
        int arrLength = sc.nextInt();

        int[] arr = new int[arrLength];
        Random rn = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rn.nextInt(100);
        }

        long time = System.nanoTime();
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }

        System.out.println("Однопоток:" + sum);
        time = System.nanoTime() - time;
        System.out.printf("Elapsed %,9.3f ms\n", time / 1_000_000.0);

        MaltyThreadSum Sum = new MaltyThreadSum();
        sum = Sum.Sum(arr);
        long time2 = System.nanoTime();
        System.out.println("Многопоток:" + sum);
        time2 = System.nanoTime() - time2;
        System.out.printf("Elapsed %,9.3f ms\n", time2 / 1_000_000.0);
    }
}
