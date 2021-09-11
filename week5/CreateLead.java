package testcase;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import week5.day2.ReadData;

public class CreateLead extends BaseClass{

	@Test(dataProvider ="sendData")
	public void runCreate(String companyName,String firstName,String lastName,String mobile ) {
		System.out.println("create lead");

		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(mobile);
		driver.findElement(By.name("submitButton")).click();
		
}
	
	@DataProvider	
	public String[][] sendData() throws IOException {	
		
		return ReadData.readData("CreateLead");
	
	}
}






