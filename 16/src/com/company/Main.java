package com.company;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService thr = Executors.newFixedThreadPool(2);
        thr.execute(new Ships("First"));
        thr.execute(new Ships("Second"));
        thr.execute(new Ships("Third"));
    }
}
