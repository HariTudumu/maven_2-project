Feature: I am automating the Orange HRM Application

Background: Common Re-usable steps

Given user launch the browser
Then user enter the URL as "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

Scenario: TC003_adding Nationality
And user enter the credentials as 

|Admin|admin123|

Then user go to Nationalities page
And user add Nationalities as and save the nationalities
|india|
|africa|
|poland|
Then user logout from the application
Then user close the browser




