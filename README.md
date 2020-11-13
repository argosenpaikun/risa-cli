Instruction:
Inside this project there is two language provided, which are Java and JavaScript.
The JavaScript is located in the js directory.

Java:
For Java, I have created a jar application in the target directory, you can build it by using Maven 
assembly which I have configured via pom.xml. The name of the file is risa-cli-jar-with-dependencies.jar. 
To execute the program,shows on the following command line:

java -jar risa-cli-jar-with-dependencies.jar "hello world".

The test script was provided in the project src directory located under test directory.
You can conduct the unit test on the application functionality.

JavaScript:
For JavaScript, I have created both scripts which are risa-cli and risa-array.

risa-cli is a JavaScript application that is similar as the Java application. For risa-array,
is a JavaScript application that handles the flatten array. Where I wrote the flatten script
without using any existing flat feature that was provided by NodeJS.

In order to run the script, is show as follows:
risa-cli: node main.js "hello world"
risa-array: node main.js

The test script was provided on each of the script directory that are located on test directory.
The name of the test script is test.js.

In order to execute, the test script shows on the following command line:
npm test

Note: Please make sure mocha is install, if does not install use this following command:
npm i -g mocha (globally install mocha)
