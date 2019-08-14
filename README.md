# scc-autoframework
The framework has been written using the Page Object Model design pattern, with JUnit, Cucumber, Selenium and Java.

# test cases
The test cases are located in /test/java/resources, in the feature file

The test cases can be run as JUnit test cases, or with a maven goal:
> mvn clean install

# ci/cd
The framework is deployed in Travis CI after every commit. 
https://travis-ci.com/edugarver/scc-autoframework

# running locally
To run the test cases locally, just checkout the project.
In the BrowserDriver.java class, uncomment the following line:
> System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
And comment the next one:
> System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
Do not commit this change.

# report
If run locally, the test reports are located in target/cucumber-html-report/index.html
If run from Travis, the only reports available are the log files
