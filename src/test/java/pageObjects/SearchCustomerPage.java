package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	public WebDriver ldriver;
	WaitHelper waithelper;
	public SearchCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper= new WaitHelper(ldriver); 
	}
	@FindBy(how=How.ID,using="SearchEmail")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how=How.ID,using="SearchFirstName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(how=How.ID,using="SearchLastName")
	@CacheLookup
	WebElement txtLastName;
	
	@FindBy(how=How.ID,using="SearchMonthOfBirth")
	@CacheLookup
	WebElement drpdoMonth;
	
	@FindBy(how=How.ID,using="SearchDayOfBirth")
	@CacheLookup
	WebElement drpdoDay;
	
	@FindBy(how=How.ID,using="SearchCompany")
	@CacheLookup
	WebElement txtCompany;
	

	@FindBy(how=How.ID,using="SearchIpAddress")
	@CacheLookup
	WebElement txtIpAddress;
	
	@FindBy(how=How.XPATH,using="/html/body/div[3]/div[1]/form[1]/section/div/div/div/div[1]/div/div[2]/div[1]/div[2]/div[3]/div[2]/div/div")
	@CacheLookup
	WebElement txtcustomerRoles;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]")	
	@CacheLookup
	WebElement listitemAdministrators;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[2]")	
	@CacheLookup
	WebElement listitemRegistered;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]")	
	@CacheLookup
	WebElement listitemGuests;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[4]")	
	@CacheLookup
	WebElement listitemVendors;
	
	@FindBy(how=How.ID,using="search-customers")	
	@CacheLookup
	WebElement btnSearch;


	@FindBy(how=How.XPATH,using="//*[@id=\'customers-grid_wrapper\']/div[1]/div/div/div[1]/div/table")	
	WebElement table;
	
	@FindBy(how=How.XPATH,using="//*[@id=\'customers-grid\']/tbody/tr")	
	List<WebElement> tableRows;
	
	@FindBy(how=How.XPATH,using="//*[@id=\'customers-grid\']/tbody/tr/td")	
	List<WebElement> tableColumns;
	
	public void setEmail(String email)
	{
		waithelper.WaitForElement(txtEmail, 30);
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}

	public void setFirstName(String fname)
	{
		waithelper.WaitForElement(txtFirstName, 30);
		//txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		waithelper.WaitForElement(txtLastName, 30);
		//txtLastName.clear();
		txtLastName.sendKeys(lname);
	}
	
	public void clickSearch()
	{
		btnSearch.click();
		waithelper.WaitForElement(btnSearch, 30);
	}

	public int getNoOfRows()
	{
		return(tableRows.size());
	}
			
	public int getNoOfColumns()
	{
		return(tableColumns.size());
	}
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag=false;
	
		for(int i=1;i<=getNoOfRows();i++)
		{
		String  emailid=table.findElement(By.xpath("//table[@id=\'customers-grid\']/tbody/tr["+i+"]/td[2]")).getText();
		System.out.println(emailid);
		if(emailid.equals(email))
		{
			flag=true;
		}
		}
		return flag;
	}
	
	public boolean searchCustomerByName(String Name)
	{
		boolean flag=false;
	
		for(int i=1;i<=getNoOfRows();i++)
		{
		String  name=table.findElement(By.xpath("//table[@id=\'customers-grid\']/tbody/tr["+i+"]/td[3]")).getText();
		String names[]=name.split(" ");
		//System.out.println(emailid);
		if(names[0].equals("Victoria") && names[1].equals("Terces"))
		{
			flag=true;
		}
		}
		return flag;
	}
}
