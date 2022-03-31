Feature: Account Page Feature

Background: 
Given user has already logged in to the application
|username|password|
|nityaranjan190592@gmail.com|Selenium@100|


Scenario: Accounts Page Title
Given User is on Accounts page
When user gets the title of the page
Then Page title should be "My account - My Store"


Scenario: Account Section count
Given User is on Accounts page
Then User gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And account section count should be 6
