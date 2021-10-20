package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass{
	@Before
	public void setup() throws IOException
	{
		
		logger=Logger.getLogger("nopCommerce");//added logger
		PropertyConfigurator.configure("log4j.properties");//added logger
		
		//Reading Properties
		configProp=new Properties();
		FileInputStream configProfile=new FileInputStream("config.properties");
		configProp.load(configProfile);
		
		String br=configProp.getProperty("browser");
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
			 driver=new ChromeDriver();
		}
		
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
			 driver=new FirefoxDriver();
		}
		
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",configProp.getProperty("iepath"));
			 driver=new InternetExplorerDriver();
		}
			
		
		logger.info("********** Launching browser ***********");
		
	}
	  
	
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		
		lp=new LoginPage(driver);
	}
	
	  

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		logger.info("********** Opening URL ***********");
		driver.get(url);
	    
	}

	@When("User enter Email as {string} and Password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) {
		logger.info("**********Providing Login Details  ***********");
		 lp.setUserName(email);
		 lp.setPassword(password);
	}
	    
	@When("Click on login")
	public void click_on_login() {
		logger.info("********** Started Login ***********");
		lp.clickLogin();
	    
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
	    if(driver.getPageSource().contains("Login was unsuccessful.")) {
	    	driver.close();
	    	logger.info("********** Login Failed ***********");
	    	Assert.assertTrue(false);
	    }
	    else
	    {logger.info("********** Login Passed ***********");
	    	Assert.assertEquals(title, driver.getTitle());
	    }
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		logger.info("********** click on logout link***********");
		lp.clickLogout();
		Thread.sleep(3000);
	    
	}

	@Then("Close Browser")
	public void close_browser() {
		logger.info("********** Closing browser ***********");
		driver.quit();
	    
	}
	
	
	// Customers feature step definition----------------------------------------------------
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		
		addcust=new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getPageTitle());
		
	    
	}
	
	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(5000);
		addcust.clickOnCustomerMenu();
	   
	}
	@When("Click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(5000);
		addcust.clickOnCustomerMenuItem();
		Thread.sleep(2000);
	    
	}
	@When("Click on add new button")
	public void click_on_add_new_button() throws InterruptedException {
		addcust.clickOnAddnew();
		Thread.sleep(2000);
	   
	}
	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() throws InterruptedException {
		addcust=new AddCustomerPage(driver);
		Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getPageTitle());
		Thread.sleep(2000);
	  
	}
	@When("User enter customer info")
	public void user_enter_customer_info() {
		logger.info("********** Adding new Customer ***********");
		logger.info("********** Providing Customer Details***********");
		String email=randomestring()+"@gmail.com";
		addcust.setEmail(email);
		addcust.setPassword("test123");
		addcust.setFirstName("Srinu");
		addcust.setLastName("veera");
		addcust.setGender("Male");
		addcust.setDob("04/19/1994");
		addcust.setCompanyName("busyQA");
		//addcust.setIstaxexmpt();
		//addcust.setNewsLetter("Test store 2");
		addcust.setCustomerRole("Forum Moderators");
		addcust.setManagerofVendor("Vendor 2");
		//addcust.setActive();
		addcust.setAdminComment("This is for testing..........");
	   
	}
	@When("Click on save button")
	public void click_on_save_button() throws InterruptedException {
		logger.info("********** saving Customer Data ***********");
		addcust.clickOnSave();
		Thread.sleep(2000);
	    
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
		 Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	   
	}
	
	// Steps for searching customer using Email ID---------------------------------------
	
	
	@When("Enter customer Email")
	public void enter_customer_email() {
		logger.info("********** Searching customer by emailId ***********");
		searchCustomer=new SearchCustomerPage(driver);
		searchCustomer.setEmail("victoria_victoria@nopCommerce.com");
	    
	}
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchCustomer.clickSearch();
	   Thread.sleep(3000);
	}
	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
		boolean status=searchCustomer.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}

// Steps for searching customer using First name and Last name----------------------------------------------
	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		logger.info("********** Searching customer by name ***********");
		searchCustomer=new SearchCustomerPage(driver);
		searchCustomer.setFirstName("Victoria");
	}
	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		searchCustomer.setLastName("Terces");
	    
	}
	
	@Then("User should found Name in the search table")
	public void user_should_found_name_in_the_search_table() {
		
		boolean status=searchCustomer.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
	}






}
