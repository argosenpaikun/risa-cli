package com.argosenpaikun.risa.args;

/**
 * Author: Mohamed Affian bin Che Mohamed Onn
 * Date: 12/11/2020
 * Company: Dataran Teknologi Sdn. Bhd.
 */

/**
 * This class manage the argument exception
 */
public class ArgException extends Exception {

    /**
     * Initialize argument exception
     *
     * @param message   message
     */
    public ArgException(String message) {
        super(message);
    }
}
