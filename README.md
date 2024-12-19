Introduction:
This coding challenge was done using Selenium in Java, TestNG, and Cucumber BDD Framework.
The framework, dependencies and repo were built from scratch.


Pre-requisites:
IDE: IntelliJ or Eclipse
Plugins (Go to Settings > Plugins > Marketplace) : Cucumber for Java, Gherkin, Lombok
Run Configuration : Junit
Java 22 and up
Chrome Browser vVersion 131.0.6778.86 (Official Build) (64-bit)
ChromeDriver v131 (Already added in under drivers folder)


Structure:
I used a Page Object Model while integrating it to Cucumber BDD framework.
Feature files are located under Test > java > features. Covering the Login and Checkout scenarios.
Step Definition files are located under Test > java > stepdefs
While the Page Class are defined in Test > java > pages. This is where the elements and methods are defined.
I also created a BasePage for all the elements or methods that can be reused, separated WebDriverManager for better maintenance, and added Environment Properties file for all the links/url.
Added Extent Reports to generate reports after each run
Lastly, the Runner File located in test > java > runner > RunnerTest. This is where you identify the tag of the scenario that you will be running.


To run the test:
Go to RunnerTest file. add tags = "@RegressionSuite" if you would like to run all the screnarios, or tags = "@" if you like to run specific scenarios.


Test Case Coverage:
Login
End to End Checkout Scenario
Some Negative Scenarios
