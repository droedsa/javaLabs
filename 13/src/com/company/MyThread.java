package com.company;

import java.math.BigInteger;

public class MyThread implements Runnable {
    private int number;
    public MyThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        Thread th = Thread.currentThread();
        System.out.println(th.getName() + " -> " + number + "! = " + calculateFactorial(number));

    }

    private BigInteger calculateFactorial(int n) {
        BigInteger factorial = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(new BigInteger("" + i));
        }
        return factorial;
    }
}
