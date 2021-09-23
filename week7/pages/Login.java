package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Login extends BaseClass{
	
	
	public Login(ChromeDriver driver,Properties prop)
	{
		this.driver=driver;
		this.prop=prop;
	
	}
	
	public Login enterUserName()
	{
	  driver.findElement(By.id("username")).sendKeys(prop.getProperty("userName"));
	   return this;
	}
	
	public Login enterPassord()
	{
	   driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
	   return this;
	}
	
	public HomePage clickLoginButton()
	{
	driver.findElement(By.className("decorativeSubmit")).click();
	   
	  // HomePage hp=new HomePage();
	   
	   return new HomePage(driver);
	}
	

}
