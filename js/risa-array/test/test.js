const CharUtil = require('../utils/charUtil');
var assert = require('assert');

// initialize chracter utility
var charUtil = new CharUtil();

describe('flatArray', function () {
    describe('#flatArray()', function () {
        it('should return flat array', function () {
            arr = [1, [2, [[3, 4], 5], 6]];
            assert.equal(charUtil.flatArray(arr).toString(), [1, 2, 3, 4, 5, 6])
        });
    });
});