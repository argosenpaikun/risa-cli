package com.argosenpaikun.risa.utils.data;

/**
 * Author: Mohamed Affian bin Che Mohamed Onn
 * Date: 12/11/2020
 * Company: Dataran Teknologi Sdn. Bhd.
 */

/**
 * This class manage delimiter exception
 */
public class DelimiterException extends Exception {

    /**
     * Initialize delimiter exception
     *
     * @param delimiter delimiter
     */
    public DelimiterException(String delimiter) {
        super(delimiter);
    }

    /**
     * Return default delimiter
     *
     * @return  default delimiter
     */
    public char defaultDelimiter() {
        return ',';
    }
}
