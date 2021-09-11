package week5.day1.assignments;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import week5.day2.ReadData;

public class CreateNewInc extends  BaseClassINC{

	
	public static String incNumber;

	@Test(dataProvider="sendData")
	public void runCreateINC(String description) throws InterruptedException {
		// TODO Auto-generated method stub
		

		driver.findElement(By.id("filter")).sendKeys("Incident");
		driver.findElement(By.xpath("(//div[text()='Incidents'])[1]")).click();
		driver.findElement(By.xpath("(//div[text()='All']/ancestor::a)[2]")).click();
		driver.switchTo().frame("gsft_main");

		driver.findElement(By.xpath("//button[text()='New']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		driver.switchTo().defaultContent();

		Set<String> windowset = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(windowset);
		System.out.println(windowList);
		driver.switchTo().window(windowList.get(1));
		driver.findElement(
				By.xpath("(//a[@class='glide_ref_item_link']/following::a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(windowList.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.short_description")).sendKeys("new testleaf inc");

		incNumber = driver.findElement(By.id("incident.number")).getAttribute("value");
		System.out.println(incNumber);
		driver.switchTo().defaultContent();

		WebElement incFrame = driver.findElement(By.xpath("//iframe[contains(@title,' Incident | ServiceNow')]"));
		driver.switchTo().frame(incFrame);

		driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		// driver.switchTo().window(windowList.get(0));

		driver.switchTo().frame("gsft_main");
		WebElement expINC = driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]"));
		expINC.sendKeys(incNumber);
		expINC.sendKeys(Keys.ENTER);

		WebElement searchInc = driver.findElement(By.xpath("//a[@class='linked formlink']"));

		String actual = searchInc.getText();
		System.out.println(actual);

		if (incNumber.equals(actual)) {

			System.out.println("searched same INc");
		}

		else {
			System.out.println("Not same");
		}



	}
	@DataProvider
	public String[][] sendData() throws IOException	
	{
		
		return ReadData.readData("CreateINC");
		
		
	}

}
