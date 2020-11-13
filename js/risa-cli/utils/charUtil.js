const StringBuilder = require('string-builder');
const MathUtil = require('./mathUtil');

class CharUtil {

    /**
     * Convert string value to upper case
     * 
     * @param {*} value string value
     */
    toUpper(value) {
        return value.toUpperCase();
    }

    /**
     * Convert string value to lower case
     * 
     * @param {*} value string value
     */
    toLower(value) {
        return value.toLowerCase();
    }

    /**
     * Add array character
     * 
     * @param {*} value string value
     */
    addArrayChars(value) {
        let chars = []
        chars.push(value)
        return chars;
    }

    alternateCharOdd(chars) {
        let sb = new StringBuilder();
        let math = new MathUtil();
        for(const [i, value] of chars.entries()) {
            sb.append((math.isOdd(i + 1) ? this.toUpper(value) : this.toLower(value)));
        }
        return sb.toString();
    }

    /**
     * Is string only?
     * 
     * @param {*} value string value 
     */
    isStringOnly(value) {
        var string_regex = /^[a-zA-Z_ .,?]*$/;
        return string_regex.test(value);
    }

    /**
     * Is digital only?
     * 
     * @param {*} value string value 
     */
    isDigitOnly(value) {
        var digital_regex = /^[0-9]*$/;
        return digital_regex.test(value);
    }
}

module.exports = CharUtil;