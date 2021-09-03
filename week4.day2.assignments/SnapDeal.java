package week4.day2.Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement mensFashion = driver.findElement(By.xpath("//a[@class='menuLinks leftCategoriesProduct ']//span[contains(text(),'Men')]"));
		Actions builder=new Actions(driver);
		builder.moveToElement(mensFashion).perform();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		
		String count = driver.findElement(By.className("category-count")).getText();
		String allCount = count.replaceAll("[^0-9]","");
		System.out.println("total number of sport shoes are :"+allCount);
		
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		driver.findElement(By.className("sort-label")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//ul[@class='sort-value']//li)[2]")).click();
		
		WebElement blue = driver.findElement(By.xpath("//img[contains(@class,'product-image wooble')]"));
		
		builder.moveToElement(blue).perform();
		Thread.sleep(2000);		
		
		
		driver.findElement(By.xpath("//div[contains(text(),'Quick')]")).click();
		/*
		 * Set<String> setWindow = driver.getWindowHandles(); List<String> allWindow=new
		 * ArrayList<String>(setWindow); String next = allWindow.get(0);
		 * System.out.println(allWindow); driver.switchTo().window(next);
		 */
		
		WebElement ele = driver.findElement(By.className("payBlkBig"));
		String price = ele.getText();
		System.out.println(price);
		String discount = driver.findElement(By.className("percent-desc")).getText();
		System.out.println("product discount is "+discount);
		File src = ele.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/snapdeal.png;");
		FileUtils.copyFile(src, dest);
		driver.findElement(By.xpath("//div[@class='close close1 marR10']")).click();
		driver.close();
		driver.findElement(By.xpath("//label[@for='Brand-Columbus']//a")).click();
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
