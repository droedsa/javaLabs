package com.Homework.lab14;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String fileName = "text.txt";
        File filePath = new File("C:\\Users\\Droed\\IdeaProjects\\");
        new FileFinder(fileName, filePath).findFile();
    }
}
