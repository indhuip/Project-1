Feature: Login page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "http://karehealth.menpaniproducts.com/admin/auth/login"

Scenario: Forgot password link
Given the user is on login page
Then the forgot password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters username "admin"
And user enters password "admin"
And user clicks on login button
