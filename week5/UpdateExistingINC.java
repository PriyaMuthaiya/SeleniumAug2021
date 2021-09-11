package week5.day1.assignments;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import week5.day2.ReadData;

public class UpdateExistingINC  extends BaseClassINC{

	@Test(dataProvider="sendData")
	public void runUpdateINC(String Urgency) {
		// TODO Auto-generated method stub
		
		
		driver.findElement(By.id("filter")).sendKeys("Incident");
		driver.findElement(By.xpath("(//div[text()='Incidents'])[1]")).click();
		driver.findElement(By.xpath("(//div[text()='All']/ancestor::a)[2]")).click();
		driver.switchTo().frame("gsft_main");
		
		WebElement expINC = driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]"));
		expINC.sendKeys(CreateNewInc.incNumber);
		expINC.sendKeys(Keys.ENTER);
		
		WebElement searchInc = driver.findElement(By.xpath("//a[@class='linked formlink']"));		
		searchInc.click();
		
		
		WebElement urgency = driver.findElement(By.id("incident.urgency"));
		Select urgencyDD=new Select(urgency);
		urgencyDD.selectByVisibleText(Urgency);
		
		
		String priority = driver.findElement(By.id("incident.priority")).getText();
		System.out.println("Selected priority is"+priority);
		

		String state = driver.findElement(By.id("incident.state")).getText();
		System.out.println("Selected state is"+state);
		driver.findElement(By.id("sysverb_update_bottom")).click();
	
		
		
	}
	@DataProvider
	public String[][] sendData() throws IOException	
	{
		
		return ReadData.readData("UpdateINC");
		
		
	}

}
