package com.company;

public class Ships implements Runnable {
    private int box = 10;
    private String name;
    public Ships(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Start of unloading " + name);
        int n = 0;
        for (int i = 0; i < box; i++) {
            System.out.println("Left unload " + (i + 1) + " boxes from " + name);
            n++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (box == n) {
            System.out.println(name + " unloaded");
        }
    }
    @Override
    public String toString() {
        return "Barge [boxes = " + box + ", name = " + name + "]";
    }
}
