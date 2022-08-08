# Backbase Mobile QA Assignment

## Description
This assessment is to measure the candidate's knowledge with Git, test cases creation, test reporting and the ability to adapt with automation tools.

## Application under test
A simple native Android application that shows a list of cities which you can search and when you choose a city the app shows a pin on a map. Then you can go back and repeat the process.

Prerequisites
- Github account
- Android Studio

## Deliverables:
1. Create a series of testcases based on the application functionality. Make sure that you give detailed instructions for each test case (step preconditions, steps to execute test case, expected results, etc). You can use any format you prefer.
2. Automate at least 5 (the more, the better!) of the previously created test cases. Use of Espresso as an automation tool is highly preferred. As an alternative you can use UI Automator. No other tool is accepted.
3. Provide a clear set of instructions how to run tests.
4. Provide a test report for executed test cases (manual and automated)
5. In the case of finding bugs, provide a separate bug report
6. Provide an overall evaluation test report for the application (issues, risks, recommendation, etc.). Make it personal! Explain why you decided to automate what you’ve automated, why you decided to test what you’ve tested, what test strategies you decided to use and why... Summarising, guide us through your mind!

All manual deliverables should be added to a "Reports" folder in root of project.

Once you are done,  push your test assignment to your fork. Please provide user **bb-qa** access to your fork and share a link to your fork when you are done with the assignment.

**Bonus Question:**
Part of the app functionality is currently not working. Fix it if you can.

**NOTE:**
If you need to take any assumptions please note them as part of your answers.


## Common info:
For tests used next AVD:
Pixel 4 (API 30)

## For create report execute this commands:
$ adb -d shell "run-as app.com.mobileassignment cat /data/data/app.com.mobileassignment/files/allure-results" > allure-results
$ adb pull /data/local/tmp/allure-results

## For open allure report execute this command:
$ allure serve

## Test cases:
1. Opening app
   Steps:
    1. Open app
       Expected: App is open
       Result: +
       Status: Automated
2. Closing app
   Steps:
    1. Open app
       Expected: App is open
       Result: +
    2. Click on HOME button
       Expected: Open menu with all active apps
       Result: +
    3. Swipe up on MobileAssignment app tab
       Expected: App is closed
       Result: +
       Status: Manual

3. On first page are showed list of cities and search panel
   Steps:
    1. Open app
       Expected: App is open. List of cities and search panel are showed
       Status: Automated

4. Search city, positive case (search city that exist in cities.json by cityName)
   Steps:
    1. Open app
    2. Type cityName string from cities.json to search field
       Expected: showed list of cities with that name or name that contains that cityName as part
       Result: +
       Status: Automated

4. Search city, positive case (search city that exist in cities.json by Country)
   Steps:
    1. Open app
    2. Type Country string from cities.json to search field
       Expected: showed list of cities from that Country
       Result: -
       Status: Automated

5. Search city, negative case (search by string not from cities.json)
   Steps:
    1. Open app
    2. Type incorrect string to search field (for automated test used "ABCDEF")
       Expected: You don't get any result (blank page)
       Result: +
       Status: Automated

6. Open map for city from original list
   Steps:
    1. Open app
    2. Click on first city in list
       Expected: Open map with marker for this city
       Result: +
       Status: Automated

7. Open map for city from search request
   Steps:
    1. Open app
    2. Type cityName string from cities.json to search field
    3. Click on first city in answer
       Expected: Open map with marker for this city
       Result: +
       Status: Automated

8. Return to list of cities
   Steps:
    1. Open app
    2. Click on first city in list
    3. Click on BACK button
       Expected: Return from map to view with list of cities
       Result: +
       Status: Manual
