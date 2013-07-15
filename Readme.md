JMonitaur
================================

JMonitaur is a showcase template/example of a Java/JavaScript application with the following principles:
* Pure Java/JavaScript
* Separation of Java and JavaScript/CSS roles
* Component architecture testable at all levels
* Script-centric, but leveraging IDEs

Technology Drivers and Choices
* Component architecture (prefer multi-Maven project over Ant)
* Leverage browser and JavaScript library technologies (use over server-side templates where suitable)
* Testable template language (prefer Freemarker over JSP - reviewing Thymeleaf)
* Simple and powerful layout control (prefer Sitemesh over all others - reviewing Tiles3)
* Maximised leverage of libraries (e.g. Spring, Jackson)
* Separation of web-development and JEE development (prefer all stand-alone JavaScript libraries tightly coupled client-server solutions)
* Allow choice between Single Page Interface (SPI) and multi-page
* Allow file-system DOM-JavaScript development and testing on multi-page applications
* Prefer multi-browser testing with WebDriver over Selenium, Karma