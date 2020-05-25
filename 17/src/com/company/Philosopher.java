package com.company;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

class Philosopher extends Thread {
    Semaphore sem;
    int num = 0;
    int id;

    Philosopher(Semaphore sem, int id) {
        this.sem = sem;
        this.id = id;
    }

    public void run() {
        try {
            while (num < 3) {
                sem.acquire();
                System.out.printf("Philosopher %s sits down at the table \r\n", id);
                sleep(500);
                num++;

                System.out.printf("Philosopher %s gets up from the table\r\n", id);
                sem.release();
                sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
}
