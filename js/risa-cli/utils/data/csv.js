const fs = require('fs');
const csvReader = require('csv-parser');
const csvWriter = require('csv-writer');
const fastCSV = require('fast-csv');
const { convertArrayToCSV } = require('convert-array-to-csv');

class CSV {
    /**
     * Read data from CSV
     * 
     * @param {*} filename csv filename
     */
    readData(filename) {
        return fileStream.createReadStream(filename).pipe(csvReader());
    }

    /**
     * Write fast data into CSV
     * 
     * @param {*} data      csv data
     * @param {*} filename  csv filename
     */
    writeFastData(data, filename) {
        writeFastData(data, filename, true);
    }

    /**
     * Write fast data into CSV
     * 
     * @param {*} data      csv data
     * @param {*} filename  csv filename
     * @param {*} header    csv header
     */
    writeFastData(data, filename, header) {
        fastCSV.write(data, {headers: header}).pipe(fs.createWriteStream(filename));
    }
    
    /**
     * Write data into CSV
     * 
     * @param {*} data      csv data
     * @param {*} filename  csv filename
     * @param {*} header    csv header
     */
    writeData(data, filename, header) {
        csvWriter.createObjectCsvWriter({path: filename, header: header});
        csvWriter.writeRecords(data);
    }



    /**
     * Write array to CSV
     * 
     * @param {*} data      csv data
     * @param {*} filename  csv filename
     */
    writeArrayToCSV(data, filename) {
        fs.writeFile(filename, this.arrayToCSV(data),
            function (err) {
                if(err) throw err;
            });
    }

    /**
     * Write array to CSV
     * 
     * @param {*} data          csv data
     * @param {*} filename      csv filename
     * @param {*} header        csv header
     * @param {*} delimiter     csv delimiter
     */
    writeArrayToCSV(data, filename, header, delimiter) {
        fs.writeFile(filename, this.arrayToCSV(data, header, delimiter),
            function (err) {
                if(err) throw err;
            });
    }

    /**
     * Convert array to CSV
     * 
     * @param {*} text  text
     */
    arrayToCSV(text) {
        return convertArrayToCSV(text);
    }

    /**
     * Convert array to CSV
     * 
     * @param {*} text          text
     * @param {*} header        header
     * @param {*} delimiter     delimiter
     */
    arrayToCSV(text, header, delimiter) {
        return convertArrayToCSV(text, {header, separator: delimiter});
    }

    /**
     * Convert CSV value into array
     * 
     * @param {*} text  text value 
     */
    convertCSVtoArray(text) {
        var re_valid = /^\s*(?:'[^'\\]*(?:\\[\S\s][^'\\]*)*'|"[^"\\]*(?:\\[\S\s][^"\\]*)*"|[^,'"\s\\]*(?:\s+[^,'"\s\\]+)*)\s*(?:,\s*(?:'[^'\\]*(?:\\[\S\s][^'\\]*)*'|"[^"\\]*(?:\\[\S\s][^"\\]*)*"|[^,'"\s\\]*(?:\s+[^,'"\s\\]+)*)\s*)*$/;
        var re_value = /(?!\s*$)\s*(?:'([^'\\]*(?:\\[\S\s][^'\\]*)*)'|"([^"\\]*(?:\\[\S\s][^"\\]*)*)"|([^,'"\s\\]*(?:\s+[^,'"\s\\]+)*))\s*(?:,|$)/g;

        // return NULL if input string is not well formed CSV string
        if(!re_valid.test(text)) return null;

        var a = []; // initialize array to receive values
        text.join().replace(re_value, // "Walk" the string using replace with callback.
        function(m0, m1, m2, m3) {

            // Remove backslash from \' in single quoted values.
            if (m1 !== undefined) a.push(m1.replace(/\\'/g, "'"));

            // Remove backslash from \" in double quoted values.
            else if (m2 !== undefined) a.push(m2.replace(/\\"/g, '"'));
            else if (m3 !== undefined) a.push(m3);
            return ''; // Return empty string.
        });
        
        // handle special case case of empty last value
        if(/,\s*$/.test(text)) a.push('');
        return a;
    }
}

module.exports = CSV;

