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
    
    public BufferedReader getBufferedReader(String fileName) {
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
    
    public String currentDirectory() {
        File tempFile = new File("###");
        String workingDirectory = tempFile.getAbsolutePath();
        workingDirectory = workingDirectory.replaceAll("###","");
        return workingDirectory;
    }
}
