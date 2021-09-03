package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraProject {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement Men = driver.findElement(By.xpath("//a[text()='Men']"));

		Actions builder = new Actions(driver);
		builder.moveToElement(Men).perform();

		driver.findElement(By.linkText("Jackets")).click();

		String totalJackets = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		String total = totalJackets.replaceAll("[^0-9]", "");
		System.out.println("Total number of jacket is " + total);
		int allTotal = Integer.parseInt(total);

		String cat1 = driver.findElement(By.xpath("//label[text()='Jackets']//span")).getText();

		String cat1Count = cat1.replaceAll("[^0-9]", "");
		int cat1CountInt = Integer.parseInt(cat1Count);
		System.out.println("total number of normal jacket is" + cat1CountInt);

		String cat2 = driver.findElement(By.xpath("//label[text()='Rain Jacket']//span")).getText();

		String cat2Count = cat2.replaceAll("[^0-9]", "");
		int cat2CountInt = Integer.parseInt(cat2Count);

		System.out.println("total number of normal jacket is" + cat2CountInt);

		int sum = 0;
		sum = cat1CountInt + cat2CountInt;

		if (allTotal == sum) {
			System.out.println("count matches");

		} else {
			System.out.println("count not matches");
		}

		// check jackets
		driver.findElement(By.xpath("//label[text()='Jackets']//div")).click();
		driver.findElement(By.className("brand-more")).click();
		driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("Duke");
		driver.findElement(By.xpath("//label[text()='Duke']//div")).click();
		driver.findElement(By.xpath("//span[contains(@class,'close')]")).click();
		List<WebElement> allDuke = driver.findElements(By.xpath("//h3[text()='Duke']"));
		for (WebElement webElement : allDuke) {
			String text = webElement.getText();
			if (text.contains("Duke")) {
				System.out.println("All jackets are Duke brands");
			}
		}

		
	
		WebElement sort = driver.findElement(By.className("sort-sortBy"));
		//sort.click();
		builder.moveToElement(sort).perform();
		
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();

		WebElement ele = driver.findElement(By.xpath("//span[@class='product-discountedPrice']"));
		String fristPrice = ele.getText();

		String newprice = fristPrice.replaceAll("[^0-9]","");

		int price = Integer.parseInt(newprice);
		System.out.println("first jacket prize is " + price);
		
		ele.click();
		
		WebElement ele1=ele;
		
		File src=ele1.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/shot.png");
		FileUtils.copyFile(src, dest);
		
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		driver.close();
		

	}

}
