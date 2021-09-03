package week4.day2.Assignments;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		//driver.switchTo().frame(0);
		WebElement brands = driver.findElement(By.id("brand_arrowUp"));
			

		
		Actions builder=new Actions(driver);
		builder.moveToElement(brands).perform();
		Thread.sleep(2000);
		WebElement popular = driver.findElement(By.xpath("//a[text()='Popular']"));
		builder.moveToElement(popular).perform();
		//Thread.sleep(2000);
		
		WebElement loreal = driver.findElement(By.xpath("//img[contains(@src,'lorealparis')]"));
		loreal.click();
		
		Set<String> setWindows = driver.getWindowHandles();
		 List<String> allWindows=new ArrayList<String>(setWindows);
		 String second = allWindows.get(1);
		driver.switchTo().window(second);
		 
		
		String title = driver.getTitle();
		
		System.out.println("current title of the page "+title);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)","");
		
		driver.findElement(By.xpath("//span[text()='Sort By : ']")).click();
		driver.findElement(By.xpath("//div[@class='control__indicator radio']/preceding-sibling::span[text()='customer top rated']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[text()='Category']")).click();
		driver.findElement(By.xpath("//div[@class='category-filter-name']//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//div[@class='category-filter-name']//span[text()='Hair Care']")).click();
		
		driver.findElement(By.xpath("//div[@class='control__indicator']/preceding::span[text()='Shampoo']")).click();
		
		
		
		String text = driver.findElement(By.xpath("//ul[@class='pull-left applied-filter-lists']//li")).getText();
		String trim = text.trim();
		System.out.println(trim);
		if(trim.contains("Shampoo")) {
			System.out.println("Filter applied with shampoo");
		}
		
		driver.findElement(By.xpath("//span[contains(text(),'Colour Protect Shampoo')]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> allWindowsList=new ArrayList<String>(windowHandles);
		System.out.println(allWindowsList);
		String current = allWindowsList.get(2);
		
		driver.switchTo().window(current);
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//span[text()='175ml']")).click();
		String price = driver.findElement(By.className("post-card__content-price-offer")).getText();
		driver.findElement(By.xpath("//button[contains(@class,'combo-add-to-btn prdt-de')]")).click();
		
		
		driver.findElement(By.className("AddBagIcon")).click();
		
		String GrandTotal = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		String GrandTotal1 = GrandTotal.replaceAll("[^0-9]", "");
		
		System.out.println(GrandTotal1);
		
		driver.findElement(By.className("proceed-arrow")).click();
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();
		
		String finalGrandTotal = driver.findElement(By.xpath("//div[text()='Grand Total']//following-sibling::div//span")).getText();
		
		System.out.println(finalGrandTotal);
		
		if(GrandTotal1.equals(finalGrandTotal)) {
			System.out.println("Grand Total same");
		}
		else {
			System.out.println("Grand Total not same");
		}
		
		driver.close();
		
		

	}

}
