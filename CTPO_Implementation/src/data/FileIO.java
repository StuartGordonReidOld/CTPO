/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stuart
 */
public class FileIO {

    public FileIO() {
    }

    public static FileWriter getFileWriter(String fileN) {
        FileWriter fileWriter;
        File outputFile;
        try {
            String fileName = currentDirectory() + fileN;
            outputFile = new File(fileName);
            fileWriter = new FileWriter(outputFile);
            return fileWriter;
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static BufferedReader getBufferedReader(String fileName) {
        FileReader fileReader;
        try {
            fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            return bufferedReader;
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static String currentDirectory() {
        File tempFile = new File("###");
        String workingDirectory = tempFile.getAbsolutePath();
        workingDirectory = workingDirectory.replaceAll("###", "");
        return workingDirectory;
    }

    public String promptName() {
        String portfolioName;
        try {
            BufferedReader keyBoardReader = new BufferedReader(new InputStreamReader(System.in));
            
            keyBoardReader.close();
            return "";
        } catch(Exception ex) {
            return "";
        }
    }
}
