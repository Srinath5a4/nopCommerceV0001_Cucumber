Feature: Login
@sanity
Scenario: Successful Login with Valid Credentilas
	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enter Email as "admin@yourstore.com" and Password as "admin"
	And Click on login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on logout link
	Then Page Title should be "Your store. Login"
	And Close Browser
	
@regression	
Scenario Outline: Login Data Driven
	Given User Launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enter Email as "<email>" and Password as "<password>"
	And Click on login
	Then Page Title should be "Dashboard / nopCommerce administration"
	When User click on logout link
	Then Page Title should be "Your store. Login"
	And Close Browser
	
	
	Examples:
	|email|password|
	|admin@yourstore.com|admin|
	|admin1@yourstore.com|admin123|