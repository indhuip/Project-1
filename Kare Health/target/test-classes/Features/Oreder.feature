Orders page feature


BackGround: User is Logged In
Given browser is launches with url "http://karehealth.menpaniproducts.com/admin/auth/login" and user is on login page 
When user enters username as "admin" and password "admin"
And clicks on login button
Then user should view dashbaord page with title "Admin | Dashboard"


Scenario: Verify Orders page title
Given user is on Dashboard page
When user Clicks on Total Orders panel
then user should view Orders page with title "Admin | Orders"

Scenario: Search for customerin Orders list
Given user is on Orders page with title "Admin | Orders"
WWhen user Clicks on Filter button 
And selects Customer as "Saran"
And Clicks on Search
Then Order with selected customer should be listed
