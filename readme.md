# Fund Splitting Checker

This project provides functionality to load and parse XML files containing fund percentage data, returning lists of percentages for each fund. The application is designed to be executed using Maven, allowing you to run tests with `mvn test` and execute the program with `mvn exec:java`.

## Requirements

- Maven with Java 21 must be installed.

## Usage

1. Navigate to the `fund-splitting-checker` directory.
2. Run tests: `mvn test`
3. Run the application: `mvn exec:java`

## General thoughts
The primary purpose of this program is to test the functionality of the PercentageChecker. It may be beneficial to refactor the code in App.java into an integration test. If this is done, consider moving the XML parser and related model classes into the test package as well.

However, it's important to note that I'm not entirely certain whether the XML parsing is considered a core feature of the application. As a result, I did not conduct extensive testing on the XML parser itself; my focus was limited to the two provided XML files.

To facilitate comparison between implementations, I have retained the original src folder with Main.java, allowing for easy reference to the initial code.