# selenium-framework
The framework has been written using the Page Object Model design pattern, with JUnit, Cucumber, Selenium and Java.

### structure of the project
`/scr/main/java/pages` contains all the classes that model the pages of the application
`/src/main/java/utils` contains just the BrowserDriver, a class to manage the webdriver instance
`/src/main/resources` contains the webdriver for chrome (for windows)
`src/test/java/TestRunner` is the main class that will run the test cases
`src/test/java/steps` contains TestSteps, which is the class that contains all the method that model the steps written in Cucumber
`src/test/java/resources` contains the feature file in which the test cases/scenarios are written

### test cases
The test cases were written using Cucumber, for BDD. Here is how they look like:

```cucumber
Scenario Outline: delete an order
    Given user navigates to url '<url>'
    And user purchases product '<product>'
    And user notes down the order id
    And user navigates to 'orders'
    And user searches the order id
    And user deletes the order
    Then order deleted message is displayed

    Examples:
      | url                                     | product |
      | https://online-comics-shop.netlify.app/ | Gyo     |
```

`'<url>'` and `'<product>'` are parameters, which will be replaced in runtime with the values specified in the Examples section.
If we wanted to execute the same test multiple times but with different products, we just need to add more lines to the Examples section. The same can be said about the url.

### running locally
The test cases can then be executed as JUnit test cases, or with a maven goal:
> `mvn clean install`

### report
the test reports are located in `target/cucumber-html-report/index.html`
