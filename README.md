# QA Engineer Test

## Test Automation - Cucumber + Playwright

## Project Overview

This project is a Cucumber BDD framework built using Playwright for UI automation testing. It is designed to provide a structured and efficient way to write, manage, and execute automated tests for web applications.


## Introduction

### This repository contains the following:
1. Maven project with Cucumber BDD and Playwright for UI automation testing.
2. Sample test cases for a Sweet Treats Shop application.
3. Instructions for running the tests and setting up the environment.

### Requirements:
1. Part 1: UI Automation Suite (Sweet Treats Shop)

Create an automated test suite for https://sweetshop.netlify.app/ that includes:
- User registration and login (use the greyed out, pre-populated credentials)
- Product browsing and search functionality
- Shopping basket operations
- Checkout process
- Order history verification

### Instructions

1. Clone this repository to your local machine.
2. Make sure you have Java 17 or higher installed.
3. Install Maven if you haven't already.
4. Open the project in IntelliJ IDEA or any other IDE of your choice.
5. Run the tests using Maven:

### bash
### mvn clean test

6. Observe the test results in the console output. 
7. Test output Reports => ./Test-output => HtmlReport => RestAPIReport.html
      ./Test-output => PdfReport =>ExtentPDF.pdf

## Test Cases

Left to do:
mvn run Command
"mvn test"