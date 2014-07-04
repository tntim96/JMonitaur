JMonitaur
================================
`mvn verify`


JMonitaur is a showcase template/example of a Java/JavaScript application with the following principles:
* Pure Java/JavaScript
* Separation of Java and JavaScript/CSS roles
* Component architecture testable at all levels
* Automation-centric, but leveraging IDEs

Technology Drivers and Choices
* Testable template language (prefer Thymeleaf over JSP)
* Simple and powerful layout control (prefer Thymeleaf decorator pattern over all others)
* Leverage browser and JavaScript library technologies (use over server-side templates where suitable)
* Maximised leverage of libraries (e.g. Spring boot)
* Separation of web-development and JEE development (prefer all stand-alone JavaScript libraries over tightly coupled client-server solutions)
* Allow choice between Single Page Interface (SPI) and multi-page
* Allow file-system DOM-JavaScript development and testing on multi-page applications
* Prefer multi-browser testing with WebDriver over Selenium, Karma