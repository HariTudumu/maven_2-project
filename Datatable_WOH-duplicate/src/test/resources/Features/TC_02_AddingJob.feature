Feature: I am automating Orange Hrm Application

Background: common re-usable steps

Given user launch the browser
Then user enter url as "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"


Scenario: TC002_add Job Record_creating Job Record

Then user enters credentials as 
|Admin|admin123|
Then user go to Job Page
And user enter the job details as 

|Testing|Testing Desc|testing Note|
|Manual|Manual Desc|Manual Note|
|Agile|Agile Desc|Agile Note|

And user save the Job Record
Then user logout from the application
And user close the browser
 

