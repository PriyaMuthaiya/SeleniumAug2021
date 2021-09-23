package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class FindLead extends BaseClass{
	
	public FindLead(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	public FindLead enterFirstNameSearch()
	{
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("priya");
		return this;
		
	}
	
	public FindLead searchFindLead() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(5000);
		return this;
	}
	
	public ViewLead clickFirstMatchedLeadID()
	{
		driver.findElement(By.xpath("(//td[contains(@class,'partyId')])[2]//a")).click();
		return new ViewLead(driver);
	}
	
	

}
