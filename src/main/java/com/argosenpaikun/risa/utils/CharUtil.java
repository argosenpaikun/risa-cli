package com.argosenpaikun.risa.utils;

/**
 * Author: Mohamed Affian bin Che Mohamed Onn
 * Date: 12/11/2020
 * Company: Dataran Teknologi Sdn. Bhd.
 */

import java.util.List;

/**
 * This class manage the character utilities
 */
public class CharUtil {

    private MathUtil mathUtil;
    private static CharUtil charUtilInstance = null;

    /**
     * Initialize character utilities (Constructor without parameter)
     */
    private CharUtil() {
        // initialize mathematics utilities singleton class
        mathUtil = MathUtil.getInstance();
    }

    /**
     * Create instance of character utility singleton class
     *
     * @return  character utility instance singleton class
     */
    public static CharUtil getInstance() {
        if(charUtilInstance == null) charUtilInstance = new CharUtil();
        return charUtilInstance;
    }

    /**
     * Convert string value to upper case
     *
     * @param value string value
     * @return  converted string value to upper case
     */
    public String toUpper(String value) {
        return value.toUpperCase();
    }

    /**
     * Convert string value to lower case
     *
     * @param value string value
     * @return  converted string value to lower case
     */
    public String toLower(String value) {
        return value.toLowerCase();
    }

    /**
     * Convert a string to character
     *
     * @param value string value
     * @return  converted string to character
     */
    public char[] stringToChar(String value) {
        char[] chars = new char[value.length()];

        // copy character by character into array
        for(int i = 0; i < value.length(); i++) {
            chars[i] = value.charAt(i);
        }
        return  chars;
    }

    /**
     * Convert a string to character at
     *
     * @param value string value
     * @return  converted string to character at
     */
    public String[] stringToCharAt(String value) {
        String[] chartAt = new String[value.length()];

        // copy character by character into array
        for(int i = 0; i < value.length(); i++) {
            chartAt[i] = Character.toString(value.charAt(i));
        }
        return chartAt;
    }

    /**
     * Convert alternate case according list of boolean index
     *
     * @param value string value
     * @param alt   list of alternate character that requires to upper case, where true is toUpper, other toLower
     * @return  converted alternate case
     */
    public String alternateCharCase(String value, List<Boolean> alt) {
        return alternateCharCase(stringToChar(value), alt);
    }

    /**
     * Convert alternate case according list of boolean index
     *
     * @param chars     list of characters
     * @param alt       list of alternate character that requires to upper case, where true is toUpper, otherwise toLower
     * @return  converted alternate case
     */
    public String alternateCharCase(char[] chars, List<Boolean> alt) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++) {
            sb.append((alt.get(i)) ? toUpper(Character.toString(chars[i])) : toLower(Character.toString(chars[i])));
        }
        return sb.toString();
    }

    /**
     * Convert alternate case according to odd index
     *
     * @param value string value
     * @return  converted alternate case
     */
    public String alternateCharOdd(String value) {
        return alternateCharOdd(stringToChar(value));
    }

    /**
     * Convert alternate case according to odd index
     *
     * @param chars list of characters
     * @return  converted alternate case
     */
    public String alternateCharOdd(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++) {
            sb.append((mathUtil.isOdd(i + 1)) ? toUpper(Character.toString(chars[i])) :
                    toLower(Character.toString(chars[i])));
        }
        return sb.toString();
    }

    /**
     * Is string only?
     *
     * @param value string value
     * @return  is string or otherwise
     */
    public boolean isStringOnly(String value) {
        return value.matches("^[a-zA-Z_ .,?]*$");
    }

    /**
     * Is digital only?
     *
     * @param value string value
     * @return  is digital only or otherwise
     */
    public boolean isDigitalOnly(String value) {
        return value.matches("^[0-9]*$");
    }
}
