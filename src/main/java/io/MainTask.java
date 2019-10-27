package io;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class MainTask {

    private static int sumLengthOfFileNames = 0;
    private static int numberOfDirectories = 0;
    private static int numberOfFiles = 0;
    private static double averageNumberOfFilesInTheDirectory = 0.0;
    private static double averageLengthOfFileName = 0.0;


    public static void main(String[] args) throws IOException {

        File inputFile = new File(args[0].trim());

        if (inputFile.exists()){
            if (inputFile.isDirectory()){
                writeToFile(inputFile);
            } else if (inputFile.isFile()){
                readFile(inputFile);
            } else System.out.println("It's not a Directory or a File");
        } else System.out.println("File does not exist");
    }


    private static void writeToFile(File directoryForWritingToFile) throws IOException {

        File fileDirectoryTreeInfo = new File("DirectoryTreeInfo.txt");

        try(FileWriter writer = new FileWriter(fileDirectoryTreeInfo);
            BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            bufferedWriter.write("-> " + directoryForWritingToFile.getName());
            bufferedWriter.newLine();
            writeString(Objects.requireNonNull(directoryForWritingToFile.listFiles()), bufferedWriter, 1, 1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeString(File[] listFiles, BufferedWriter bufferedWriter, int tabCountDirectory, int tabCountFile) throws IOException {
        StringBuffer tab = new StringBuffer();

        for (File dir : listFiles){
            if(dir.isDirectory()) {
                tab.setLength(5*(tabCountDirectory++));
                bufferedWriter.write(tab.toString() + "-> " + dir.getName());
                bufferedWriter.newLine();

                writeString(Objects.requireNonNull(dir.listFiles()), bufferedWriter, tabCountDirectory, ++tabCountFile);
                tabCountDirectory--;
                tabCountFile--;
            }
            if(dir.isFile()){
                tab.setLength(5*(tabCountFile));
                bufferedWriter.write(tab.toString() + "* " + dir.getName());
                bufferedWriter.newLine();
            }
        }
    }


    private static void readFile(File fileToRead) {

        try {
            fileToRead.createNewFile();
            try (FileReader reader = new FileReader(fileToRead);
                 BufferedReader bufferedReader = new BufferedReader(reader)) {

                ArrayList<String> list = new ArrayList<>();
                bufferedReader.lines().forEach(list::add);

                countingTheNumberOfDirectoriesAndFiles(list);
                countingAverageNumberOfFilesInTheDirectory();
                countingTheAverageLengthOfFileName();

                System.out.println ("Number of directories = " + numberOfDirectories);
                System.out.println ("Number of files = " + numberOfFiles);
                System.out.println ("Average number of files in the directory = " + averageNumberOfFilesInTheDirectory);
                System.out.println ("Average length of file name = " + averageLengthOfFileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void countingTheNumberOfDirectoriesAndFiles(ArrayList<String> list) {
        for (String string : list) {
            if (string.contains("-> ")){
                ++numberOfDirectories;
            }
            if (string.contains("* ")){
                ++numberOfFiles;
                sumLengthOfFileNames += string.trim().replace("* ", "").length();
            }
        }
    }

    private static void countingAverageNumberOfFilesInTheDirectory(){
        averageNumberOfFilesInTheDirectory = (double) numberOfFiles / (double) numberOfDirectories;
    }

    private static void countingTheAverageLengthOfFileName(){
        averageLengthOfFileName = (double) sumLengthOfFileNames / (double) numberOfFiles;
    }

}