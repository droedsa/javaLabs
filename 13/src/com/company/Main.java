package com.company;

public class Main {
    public static void main(String[] args) {
        Thread[] threads = new Thread[100];

        int i = 0;
        while (i < 100) {
            try {
                threads[i] = new Thread(new MyThread(i));
                threads[i].start();
                threads[i].join();
                i++;
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
