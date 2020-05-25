package com.Homework.lab14;

import java.io.File;
import java.util.ArrayList;

public class FileFinder {
    public static final String NO_SUCH_FILE_MESSAGE = "So such file";

    private final String searchedFileName;
    private final File filePath;
    private final File[] currentDirectoryFiles;

    private ArrayList<File> foundFiles = new ArrayList<>();
    private ArrayList<Thread> workingThreads = new ArrayList<>();


    public FileFinder(String searchedFileName, File filePath) {
        this.searchedFileName = searchedFileName;
        this.filePath = filePath;
        currentDirectoryFiles = filePath.listFiles();
    }

    public void searchFileFromSpecifiedPath(File[] files) throws IncorrectPathNameException {

        if (files == null) throw new IncorrectPathNameException(filePath.getPath());

        for (File file : files) {
            if (file.isFile() && file.getName().equalsIgnoreCase(searchedFileName)) {
                System.out.format("%s has found %s\n", Thread.currentThread().getName(), file.getName());
                foundFiles.add(file);
            }
            if (file.isDirectory()) {
                Thread newUtilThread = new Thread(() -> {
                    try {
                        searchFileFromSpecifiedPath(file.listFiles());
                    } catch (IncorrectPathNameException e) {
                        e.printStackTrace();
                        e.getMessage();
                    }
                });
                newUtilThread.start();
            }
        }
    }

    public void findFile() {
        try {
            searchFileFromSpecifiedPath(currentDirectoryFiles);
        } catch (IncorrectPathNameException e) {
            e.printStackTrace();
            e.getMessage();
        }

        for (Thread workingThread : workingThreads) {
            try {
                workingThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (foundFiles.size() == 0) {
            System.out.println(NO_SUCH_FILE_MESSAGE);
        } else {
            System.out.println();
            for (File file : foundFiles) {
                System.out.println(file.getAbsoluteFile());
            }
        }
    }
}