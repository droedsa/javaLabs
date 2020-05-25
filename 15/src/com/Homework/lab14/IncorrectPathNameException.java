package com.Homework.lab14;

public class IncorrectPathNameException extends Exception {
    private static final long serialVersionUID = -2381893504167422907L;
    public IncorrectPathNameException(String path){
        super("Path "+ path + " is incorrect");
    }
}
