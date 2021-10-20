package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	public WebDriver ldriver;
	WebElement listitem;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver,this);
	}
	By lnkCustomers_menu=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/p");
	By lnkCustomers_menuitem=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
	By btnAddnew=By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	By txtEmail=By.xpath("//*[@id=\"Email\"]");
	By txtPassword=By.xpath("//*[@id=\"Password\"]");
	By txtFirstName=By.xpath("//*[@id=\"FirstName\"]");
	By txtLastName=By.xpath("//*[@id=\"LastName\"]");
	By rdGenderMale=By.id("Gender_Male");
	By rdGenderFemale=By.id("Gender_Female");
	By txtDob=By.xpath("//*[@id=\"DateOfBirth\"]");
	By txtCompanyName=By.xpath("//*[@id=\"Company\"]");
	By rdistaxexempt=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[8]/div[1]/div/div/i");
	By txtNewsletter=By.xpath("*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div");
	By listitemyourstorename=By.xpath("//*[@id=\"09a8225f-d1b7-4848-aa0c-19f254e2c7b7\"]");
	By listitemteststore2=By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[2]");
	By txtcustomerRoles=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
	By listitemAdministrators=By.xpath("//*[@id=\'SelectedCustomerRoleIds_listbox\']/li[1]");
	By listitemForumModarators=By.xpath("//*[@id=\'SelectedCustomerRoleIds_listbox\']/li[2]");
	By listitemGuests=By.xpath("//*[@id=\'SelectedCustomerRoleIds_listbox\']/li[3]");
	By listitemRegistered=By.xpath("//*[@id=\'SelectedCustomerRoleIds_listbox\']/li[4]");
	By listitemVendors=By.xpath("//*[@id=\"0db30297-8d87-4bfc-8140-05895574b000\"]");
	By drpmgrofVendor=By.xpath("//*[@id=\"VendorId\"]");
	By rdActive=By.xpath("//*[@id=\"Active\"]");
	By txtAdminComment=By.xpath("//*[@id=\"AdminComment\"]");
	By btnSave=By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]");
	
	//Action methods

	
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	
	
	public void clickOnCustomerMenu()
	{
		ldriver.findElement(lnkCustomers_menu).click();
	}
	public void clickOnCustomerMenuItem()
	{
		ldriver.findElement(lnkCustomers_menuitem).click();
	}
	public void clickOnAddnew()
	{
		ldriver.findElement(btnAddnew).click();
	}
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	public void setPassword(String password)
	{
		ldriver.findElement(txtPassword).sendKeys(password);	
	}
	public void setFirstName(String fname)
	{
		ldriver.findElement(txtFirstName).sendKeys(fname);
	}
	public void setLastName(String Lname)
	{
		ldriver.findElement(txtLastName).sendKeys(Lname);
	}
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(rdGenderMale).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(rdGenderFemale).click();
		}
		else
		{
			ldriver.findElement(rdGenderMale).click();
		}
	}
	public void setDob(String dob)
	{
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	
	public void setCompanyName(String compname)
	{
		ldriver.findElement(txtCompanyName).sendKeys(compname);
	}
	 
	public void setIstaxexmpt()
	{
		ldriver.findElement(rdistaxexempt).click();
	}
	/*public void setNewsLetter(String newsletter)
	{
		WebElement listitem;
		if(newsletter.equals("Your store name"))
		{
			listitem=ldriver.findElement(listitemyourstorename);
		}
		else
		{
			listitem=ldriver.findElement(listitemteststore2);
		}
		listitem.click();
	}*/
	public void setCustomerRole(String role)
	{
		ldriver.findElement(txtcustomerRoles).click();;
		
		
		if(role.equals("Administrators"))
		{
			listitem=ldriver.findElement(listitemAdministrators);
		}
		else if(role.equals("Forum Moderators"))
		{
			listitem=ldriver.findElement(listitemForumModarators);
		}
		else if(role.equals("Guests"))
		{
			listitem=ldriver.findElement(listitemGuests);
		}
		else if(role.equals("Registered"))
		{
			listitem=ldriver.findElement(listitemRegistered);
		}
		else if(role.equals("Vendors"))
		{
			listitem=ldriver.findElement(listitemVendors);
		}
		
		//listitem.click();
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click()", listitem);
	}
	public void setManagerofVendor(String value)
	{
		Select drp=new Select(ldriver.findElement(drpmgrofVendor));
		drp.selectByVisibleText(value);
	}
	public void setActive()
	{
		ldriver.findElement(rdActive).click();	
	}
	public void setAdminComment(String comment)
	{
		ldriver.findElement(txtAdminComment).sendKeys(comment);
	}
	public void clickOnSave()
	{
		ldriver.findElement(btnSave).click();
	}
}
