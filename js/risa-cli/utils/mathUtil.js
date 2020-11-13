class MathUtil {

    /**
     * Is odd?
     * 
     * @param {*} value numeric value
     */
    isOdd(value) {
        return value % 2 == 0;
    }

    /**
     * Is even?
     * 
     * @param {*} value numeric value
     */
    isEven(value) {
        return value % 2 != 0;
    }
}

module.exports = MathUtil;