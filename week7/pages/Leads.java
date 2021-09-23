package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class Leads extends BaseClass{
	
	public Leads(ChromeDriver driver)
	{
		this.driver=driver;
	}
	public CreateLead clickCreateLead()
	{
		driver.findElement(By.linkText("Create Lead")).click();
		return new CreateLead(driver);
	}
	
	public MergeLead clickMergeLead()
	{
		driver.findElement(By.linkText("Merge Leads")).click();
		return new MergeLead(driver);
	}
	public FindLead clickFindLead()
	{
		driver.findElement(By.linkText("Find Leads")).click();
		return new FindLead(driver);
	}
	

}
