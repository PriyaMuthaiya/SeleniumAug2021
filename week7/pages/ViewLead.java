package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import base.BaseClass;
import testcases.EditLeadTestCase;

public class ViewLead extends BaseClass{
	public ViewLead(ChromeDriver driver)
	{
		this.driver=driver;
	}
	public ViewLead verifyLeadFirstname() {
		String actual = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		Assert.assertEquals(firstname, actual);
	
		return this;
	}
	
	public 	DuplicateLead clickDuplicateLead() {
		driver.findElement(By.linkText("Duplicate Lead")).click();
		return new DuplicateLead(driver);
		
			}
	public 	EditLead clickEditeLead() {
		driver.findElement(By.linkText("Edit")).click();
		return new EditLead(driver);
		
			}
	public 	Leads clickDeleteLead() {
		driver.findElement(By.linkText("Delete")).click();
		return new Leads(driver);
		
			}
	
	public ViewLead getFirstName()
	{
		WebElement firstName = driver.findElement(By.xpath("(//td[contains(@class,'firstName')])[2]//a"));
		 firstnameText = firstName.getText();
		 return this;
	}
	
	public ViewLead verifyDuplicateLead()
	{
		WebElement firstnamesp = driver.findElement(By.id("viewLead_firstName_sp"));
		String firstnamesp1 = firstnamesp.getText();
	
		Assert.assertEquals(firstnamesp1, firstnameText);
		return this;
	}

}
