package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import base.BaseClass;

public class DuplicateLead extends BaseClass{
	
	public DuplicateLead(ChromeDriver driver) {
		this.driver=driver;
	}

	public ViewLead CreateDuplicateLead()
	{
		String title = driver.getTitle();
		System.out.println("title of current page is " + title);
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		return new ViewLead(driver);
	}
	
	
	

}
