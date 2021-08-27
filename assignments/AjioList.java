package week3.day2.assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.messages.internal.com.google.protobuf.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AjioList {
	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.ajio.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//2 In the search box, type as "bags" and press enter
		/*
		 * WebElement close = driver.findElement(By.className("ic-close-quickview"));
		 * if(close.isDisplayed()) { close.click(); }
		 */
		WebElement search = driver.findElement(By.name("searchVal"));
		search.sendKeys("Bags");
		search.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//label[contains(text(),'Men')]")).click();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//label[contains(text(),'Fashion Bags')]")).click();
		List<WebElement> allBags = driver.findElements(By.xpath("//div[@class='brand']"));
		
		int totalCountOfBags = allBags.size();
		System.out.println("total Count Of Bags are :"+totalCountOfBags);
		 List<WebElement> brands = driver.findElements(By.xpath("//a[@class='rilrtl-products-list__link']//div[@class='brand']"));
		for (WebElement eachBrand : brands) {
			
			String text = eachBrand.getText();
			System.out.println(text);
		}
		
		
		
		
		
	}

}

