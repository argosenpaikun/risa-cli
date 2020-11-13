package com.argosenpaikun.risa;

/**
 * Author: Mohamed Affian bin Che Mohamed Onn
 * Date: 12/11/2020
 * Company: Dataran Teknologi Sdn. Bhd.
 */

import com.argosenpaikun.risa.args.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class manage the arguments
 */
public class Args {

    private List<String[]> args;

    /**
     * Initialize arguments
     *
     * @param args  arguments
     */
    public Args(String[] args) {
        this.args = new ArrayList<>(Collections.singletonList(args));
    }

    /**
     * Initialize arguments
     */
    public void init_args() {
        switch (argumentIndex(0)) {
            case "-h":
            case "--help":
                break;
            default:
                StdOut stdOut = new StdOut(true);
                stdOut.stdout(argumentIndex(0));
                break;
        }
    }

    /**
     * Get argument value based on the index
     *
     * @param index index
     * @return  argument value based on the index
     */
    private String argumentIndex(int index) {
        return Arrays.toString(args.get(index)).toLowerCase().replace("[", "")
                .replace("]", "");
    }
}
