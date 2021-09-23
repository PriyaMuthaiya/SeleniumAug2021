package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class CreateLead extends BaseClass{
	
	
	public CreateLead(ChromeDriver driver)
	{
		this.driver=driver;
		
	}
	public CreateLead enterCompanyName(String companyName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		 
		return this;
	}
	public CreateLead enterFirstName(String firstName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		firstname = driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
		 System.out.println(firstname);
		return this;
	}
	
	public CreateLead enterLastName(String lastName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		return this;
	}
	public CreateLead enterPhNo(String phNo) {
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phNo);
		return this;
	}
	public ViewLead clickSubmit() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLead(driver);
	}
	



}
