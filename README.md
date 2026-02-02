
**Selenium 4 Test Automation Framework**

A robust, scalable, and reusable Java-based Selenium 4 automation framework designed for Web UI testing with support for:

- Environment-based execution.
- Cloud execution using LambdaTest.
- Multiple test data strategies (Excel, CSV, JSON, Faker).
- Allure reporting.
- CLI-based execution via Maven Surefire
- Structured logging with Log4j

This framework is built to demonstrate real-world automation best practices and can be easily extended for enterprise-grade testing.


## Author

- [@Snehadt](https://github.com/Snehadt)
- snehadt7@gmail.com


## 🚀 About Me

Hi , my name is Sneha Dutta. I am a seasoned Quality Engineer with 12+ years of experience in delivering high-quality software across Web, API, and Mobile platforms.

With deep expertise in both manual and automation testing, I specialize in designing enterprise-grade automation frameworks that are scalable, maintainable, and CI/CD ready. This framework is a representation of industry-proven practices and architectural patterns used in real-world automation projects.

My core strengths include:

- Test Automation Architecture
- Cross-browser and Cross-platform Testing
- Data-driven and Environment-driven Framework Design
- Cloud test Execution
- Reporting, Logging, and Maintainability best practices

This project demonstrates how modern test automation should be designed in professional Quality Engineering teams.


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Snehadt)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/sneha-dutta-48755311b/)


## 🛠 Skills
Selenium, RestAssured, Appium, Java, Maven, TestNg, Core Java,Regression Testing, Exploratory testing,Building robust automation framework


## Project Installation Guide

Clone the project

```bash
  git clone https://github.com/Snehadt/Selenium4Project.git
```

Go to the project directory

```bash
  cd Selenium4Project
```
Verify installations
```bash
 - java -version
 - mvn -version
 - allure --version
```

Running the test in lambdatest

```bash
  mvn test -Dbrowser="chrome,firefox,edge" -Denv=lambdatest
```

Running the test in local with chrome

```bash
  mvn test -Dbrowser="chrome" -Denv=qa
```
## Prerequisites

Make sure the following are installed:

- **Java 11+**
- **Maven 3.8+**
- **Allure CLI**
- **Git**
- **IDE** (IntelliJ / Eclipse recommended)

## Tech Stack

- Java 11
- Selenium 4.39
- TestNG 7.11.0
- Maven Surefire
- Apache POI
- OpenCSV
- Gson
- JavaFaker
- Log4j
- Allure
- LambdaTest

## Features

- Page Object Model (POM) design
- Singleton Driver management
- Cross-browser testing using Maven parameters
- Environment selection using Maven parameters
- Test data driven approach (Excel, CSV, JSON, Faker)
- Logging integrated with Log4j
- Allure report with screenshots on failure
- Local and Cloud (LambdaTest) execution supported


## Allure Reporting

After test execution, generate the Allure report using:

```bash
  mvn allure:serve
```

The report includes:
- Test steps
- Screenshots on failure
- Execution timeline
- Environment details

## Viewing Reports

This project uses GitHub actions. Generated Allure reports are published to the gh-pages branch after every pipeline run.

```bash
  allure-maven.html
```

You can open this file from the gh-pages branch or access it via the GitHub Pages link associated with this repository to see the latest execution results.


## Logging

Log4j is integrated for structured logging. Logs are generated for:

- Test start/end
- Step execution
- Failures and exceptions

Logs can be found in the configured log directory.
