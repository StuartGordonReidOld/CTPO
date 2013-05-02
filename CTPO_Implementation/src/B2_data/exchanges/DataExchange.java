/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package B2_data.exchanges;

import B1_data.FileInputOutput;
import java.io.*;

public class DataExchange {

    String exchangeName;
    FileWriter outputFileWriter;

    public DataExchange(String name) {
        exchangeName = name;
        outputFileWriter = FileInputOutput.getFileWriter(name);
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
