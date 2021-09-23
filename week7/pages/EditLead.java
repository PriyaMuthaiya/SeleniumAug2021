package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class EditLead  extends BaseClass{
	
	public EditLead(ChromeDriver driver)
	{
		this.driver=driver;
	}
	
	public EditLead updateDescription(String description)
	{
		WebElement desc = driver.findElement(By.id("updateLeadForm_description"));
		desc.clear();
		desc.sendKeys(description);
		return this;
	}
	
	public ViewLead clickUpdateButton()
	{
		driver.findElement(By.name("submitButton")).click();
		return new ViewLead(driver);
	}
	
	

}
