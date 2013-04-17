/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data.exchanges;

import data.FileIO;
import java.io.*;

public class Exchange {

    String exchangeName;
    FileWriter outputFileWriter;

    public Exchange(String name) {
        exchangeName = name;
        outputFileWriter = FileIO.getFileWriter(name);
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public FileWriter getOutputFileWriter() {
        return outputFileWriter;
    }

    public void setOutputFileWriter(FileWriter outputFileWriter) {
        this.outputFileWriter = outputFileWriter;
    }
}
