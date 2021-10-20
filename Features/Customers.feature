Feature: Customers

Background: Below are the common steps for each scenario
		Given User Launch Chrome browser
		When User opens URL "https://admin-demo.nopcommerce.com/login"
		And User enter Email as "admin@yourstore.com" and Password as "admin"
	    And Click on login
	    Then User can view Dashboard
	    When User click on customers Menu
	    And Click on customers Menu Item
@sanity
Scenario: Add a new Custome
	    And Click on add new button
	    Then User can view add new customer page
	    When User enter customer info
	    And Click on save button
	    Then User can view confirmation message "The new customer has been added successfully."
	    And Close Browser
@functional	    
Scenario: Search Customer By EmailID
	    And Enter customer Email
	    When Click on search button
	    Then User should found Email in the search table
	    And Close Browser
@regression	    
 Scenario: Search Customer By Name
	    And Enter customer FirstName
	    And Enter customer LastName
	    When Click on search button
	    Then User should found Name in the search table
	    And Close Browser
