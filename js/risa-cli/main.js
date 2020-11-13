var CSV = require("./utils/data/csv.js")
// console.log(process.argv.slice(2));

var csv = new CSV();
var header = ['h','e','l','l','o', ' ', 'w', 'o', 'r','l', 'd'];
var data = [];

// console.log(csv.csvToArray(data, header, ','));
csv.writeArrayToCSV(data, "hello-world.csv");
console.log('CSV created!');