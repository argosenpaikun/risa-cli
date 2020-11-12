package com.argosenpaikun.risa.utils.data;

/**
 * Author: Mohamed Affian bin Che Mohamed Onn
 * Date: 12/11/2020
 * Company: Dataran Teknologi Sdn. Bhd.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class manage the CSV
 */
public class CSV {

    private static CSV csvInstance = null;
    private char delimiter;

    /**
     * Initialize CSV (Constructor without parameter)
     */
    private CSV() {
        new CSV(',');
    }

    /**
     * Initialize CSV
     *
     * @param delimiter delimiter
     */
    private CSV(char delimiter) {
        this.delimiter = delimiter;
    }

    /**
     * Create instance of CSV singleton class
     *
     * @return  csv instance singleton class
     */
    public static CSV getInstance() {
        if(csvInstance == null) csvInstance = new CSV();
        return csvInstance;
    }

    public static void writeData(List<String[]> data, String filename) throws IOException {

    }

    public static void writeData(List<String[]> data, String filename, String delimiter) throws IOException {

    }

    /**
     * Write list of data into CSV
     *
     * @param data                  data
     * @param filename              filename
     * @throws IOException          invalid input output
     */
    public static void writeListData(List<List<String>> data, String filename) throws IOException {
        writeListData(data, filename, csvInstance.delimiter);
    }

    /**
     * Write list of data into CSV
     *
     * @param data                  data
     * @param filename              filename
     * @param delimiter             delimiter
     * @throws IOException          invalid input output
     */
    public static void writeListData(List<List<String>> data, String filename, char delimiter) throws IOException {
        // create file object for file placed at location specified by filepath
        FileWriter fileWriter = new FileWriter(new File(filename), true);
        for(List<String> csv : data) {
            String collect = String.join(Character.toString(validate_delimiter(delimiter)), csv);
            fileWriter.write(collect);
            fileWriter.write("\n");
        }

        // flush all memory
        fileWriter.flush();

        // close writer
        fileWriter.close();
    }

    /**
     * Validate delimiter
     *
     * @param delimiter delimiter
     * @return  valid delimiter, if invalid replace with default delimiter
     */
    private static char validate_delimiter(char delimiter) {
        switch(delimiter) {
            case ';':
            case '|':
            case ',':
                return delimiter;
            default:
                // throw invalid delimiter exception and replace it with default delimiter
                // the purpose to provide efficient support for the CSV generator
                csvInstance.delimiter = new DelimiterException("Invalid delimiter, replace with default delimiter ','").defaultDelimiter();
                return csvInstance.delimiter;
        }
    }
}
