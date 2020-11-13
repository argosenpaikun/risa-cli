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
     * Initialize delimiter exception (Constructor without parameter)
     */
    public DelimiterException() {
        super();
    }

    /**
     * Initialize delimiter exception
     *
     * @param msg message
     */
    public DelimiterException(String msg) {
        super(msg);
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
