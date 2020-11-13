const CharUtil = require('./utils/charUtil');

var charUtil = new CharUtil();

arr = [1, [2, [[3, 4], 5], 6]];

console.log(arr);
console.log(charUtil.flatArray(arr));    // flatten array without using existing flat function