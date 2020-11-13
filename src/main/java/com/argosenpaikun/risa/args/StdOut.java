package com.argosenpaikun.risa.args;

/**
 * Author: Mohamed Affian bin Che Mohamed Onn
 * Date: 12/11/2020
 * Company: Dataran Teknologi Sdn. Bhd.
 */

import com.argosenpaikun.risa.utils.CharUtil;
import com.argosenpaikun.risa.utils.data.CSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class manage standard output argument
 */
public class StdOut {

    private boolean dryRun;

    /**
     * Initialize standard output (Constructor without parameter)
     */
    public StdOut() {
        new StdOut(false);
    }

    /**
     * Initialize standard output
     *
     * @param dryRun    dry run
     */
    public StdOut(boolean dryRun) {
        this.dryRun = dryRun;
    }

    /**
     * Print out standard output
     *
     * @param value string value
     */
    public void stdout(String value) {
        try {
            if (isDryRun()) stdOutDryRun(value);
            else System.out.println(value);
        } catch (ArgException | IOException ae) {
            ae.printStackTrace();
        }
    }

    /**
     * Print out standard output via dry run
     *
     * @param value string value
     * @throws IOException invalid input
     */
    public void stdOutDryRun(String value) throws IOException, ArgException {
        CharUtil charUtil = CharUtil.getInstance();
        CSV csv = CSV.getInstance();

        // check if the value is actually a string characters
        if (!charUtil.isStringOnly(value)) {
            throw new ArgException("Invalid value, requires string only without any digital value");
        }

        // print upper case string value
        System.out.println(charUtil.toUpper(value));

        // print alternate upper and lower case
        System.out.println(charUtil.alternateCharOdd(value));

        // create csv file based on the value string
        csv.writeData(new ArrayList<>(Collections.singletonList(charUtil.stringToCharAt(value))),
                "hello-world.csv");
        System.out.println("CSV created!");
    }

    /**
     * Set dry run
     *
     * @param dryRun    dry run
     */
    public void setDryRun(boolean dryRun) {
        this.dryRun = dryRun;
    }

    /**
     * Is dry run?
     *
     * @return  is dry run or otherwise
     */
    public boolean isDryRun() {
        return dryRun;
    }
}
