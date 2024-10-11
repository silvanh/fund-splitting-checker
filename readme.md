# Fund Splitting Checker

This project provides functionality to load and parse XML files containing fund percentage data, returning lists of percentages for each fund. The application is designed to be executed using Maven, allowing you to run tests with `mvn test` and execute the program with `mvn exec:java`.

## Requirements

- Maven with Java 21 must be installed.

## Usage

1. Navigate to the `fund-splitting-checker` directory.
2. Run tests: `mvn test`
3. Run the application: `mvn exec:java`

## General thoughts
In General the purpose of the whole program is to test the PercentageChecker I guess. So It might be a good Idea to 
make the App.java an integration test. And if so, move the Xml Parser and the models into the test package as well.
But I'm not 100% certain if the parsing of the XML is also a feature. Because of this purpose I did not extensive testing
on the xlm parser but restricted the inputs to the 2 given XML files.