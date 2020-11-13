package com.argosenpaikun.risa.utils;

/**
 * Author: Mohamed Affian bin Che Mohamed Onn
 * Date: 13/11/2020
 * Company: Dataran Teknologi Sdn. Bhd.
 */

/**
 * This class manage the mathematics utilities
 */
public class MathUtil {

    private static MathUtil mathUtilInstance = null;

    /**
     * Initialize mathematics utilities (Constructor without parameter)
     */
    private MathUtil() {

    }

    /**
     * Create instance of mathematics utility singleton class
     *
     * @return  mathematics utility instance singleton class
     */
    public static MathUtil getInstance() {
        if(mathUtilInstance == null) mathUtilInstance = new MathUtil();
        return mathUtilInstance;
    }

    /**
     * Is odd?
     *
     * @param value numeric value
     * @return  is odd or otherwise
     */
    public boolean isOdd(int value) {
        return value % 2 == 0;
    }

    /**
     * Is even?
     *
     * @param value numeric value
     * @return  is even or otherwise
     */
    public boolean isEven(int value) {
        return value % 2 != 0;
    }
}
