package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class MyHome extends BaseClass{
	public MyHome(ChromeDriver driver)
	{
		this.driver=driver;
	}
	public Leads clickLeadsLink()
	{
		driver.findElement(By.linkText("Leads")).click();
		return new Leads(driver);
		
	}

}
