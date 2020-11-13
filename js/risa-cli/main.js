const { argv } = require("process");
var CharUtil = require('./utils/charUtil');
var CSV = require('./utils/data/csv.js');

// initialize classes
var charUtil = new CharUtil();
var csv = new CSV();

// check argument, exit if the argument is return empty
if(process.argv.slice(2).length == 0) {
    console.error('Empty argument');
    process.exit(-1);
}

var args = process.argv.slice(2);

// check if argument value, if the value is string only
if(!charUtil.isStringOnly(args[0])) {
    console.error('Invalid value, requires string only without any digital value')
    process.exit(-1);
}

console.log(charUtil.toUpper(args[0]));
console.log(charUtil.alternateCharOdd(args[0].split('')));

csv.writeArrayToCSV([], 'hello-world.csv', args[0].split(''), ',');

console.log("CSV created!");