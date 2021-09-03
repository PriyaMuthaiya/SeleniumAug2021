package week4.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErailWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("ms");
		from.sendKeys(Keys.ENTER);
		
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("mdu");
		to.sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("chkSelectDateOnly")).click();
		
		WebElement trainTable = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']"));
		List<WebElement> rowslist = trainTable.findElements(By.tagName("tr"));
		
		System.out.println("There are "+(rowslist.size())+" trains available");
		
		List<String> trainName=new ArrayList<String>();
		
		for (int i = 1; i < rowslist.size(); i++) {
			
			WebElement eachrow = rowslist.get(i);
			List<WebElement> col = eachrow.findElements(By.tagName("td"));
			WebElement trianNames = col.get(1);
			
			System.out.println(trianNames.getText());
			
			trainName.add(trianNames.getText());
			
			
		}
		
		
		
		System.out.println("before sort"+trainName);
		
		Collections.sort(trainName);
		
		System.out.println("after sort"+trainName);
		
		
		
		
		
		

	}

}
