var assert = require('assert');
const CharUtil = require('../utils/charUtil');
const CSV = require('../utils/data/csv');
const fs = require('fs')

// initialize character utilities
var charUtil = new CharUtil();

// initialize CSV
var csv = new CSV();

// write the csv file first
csv.writeArrayToCSV([], 'hello-world.csv', 'hello world'.split(''), ',');

describe('toUpper', function () {
    describe('#toUpper()', function () {
        it('should return upper case', function () {
            assert.equal(charUtil.toUpper('hello world'), 'HELLO WORLD');
        });
    });
});

describe('alternateCharOdd', function () {
    describe('#alternateCharOdd()', function () {
        it('should return value with odd upper case on each character', function () {
            assert.equal(charUtil.alternateCharOdd('hello world'.split('')), 'hElLo wOrLd');
        });
    });
});

describe('writeArraytoCSV', function () {
    describe('#writeArraytoCSV()', function () {
        it('should return true if the CSV file is successfully created', function () {
            assert.equal(fs.existsSync('hello-world.csv'), true)
        });
    });
});

describe('readData', function () {
    describe('#readData()', function () {
        it('should return the content of the CSV file', function () {
            assert.equal(csv.readData('hello-world.csv').replace('\n', ''), 'h,e,l,l,o, ,w,o,r,l,d');
        });
    });
});