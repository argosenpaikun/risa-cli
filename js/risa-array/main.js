/**
 * Flatten array
 * 
 * @param {*} arr   list of nested arrays 
 */
function flatArray(arr) {
    let result = [];  // save the output
    let main = arr, first;
    while (main.length > 0) {
        first = main[0];
        if(Array.isArray(first)) {
            Array.prototype.splice.apply(main, [0, 1].concat(first));
        } else {
            result.push(first);
            main.splice(0, 1);
        }
    }
    return result;
}

arr = [1, [2, [[3, 4], 5], 6]];

console.log(arr);
console.log(flatArray(arr));    // flatten array without using existing flat function