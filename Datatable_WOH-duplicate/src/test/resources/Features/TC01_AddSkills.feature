Feature: I am automating orange HRM application

Background: Common re-usable steps

Given user launch browser
Then User enters URL as "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"


Scenario Outline:
: TC01_AddSkills Record- creating skills record

And user enters credentials as 
 |Admin|admin123|   
When go to skills page
Then enters skill details as 
 |Java67|Java67 desc|
 |Java68|Java68 desc|
 |Java69|Java69 desc|
Then logout
Then close the browser