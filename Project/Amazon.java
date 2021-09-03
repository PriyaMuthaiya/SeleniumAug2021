package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro", Keys.ENTER);
		String price = driver.findElement(By.className("a-price-whole")).getText();
		String replaceAll = price.replaceAll("[^0-9]", "");
		int firstPrice = Integer.parseInt(replaceAll);
		System.out.println("first price of phone is : s" + firstPrice);

		String rating = driver
				.findElement(By.xpath("//span[contains(text(),'5 stars')]/following::span//a[@class='a-link-normal']"))
				.getText();
		String ratingPoint = rating.replaceAll("[^0-9]", "");
		System.out.println("customer rating of first producr is: " + ratingPoint);

		WebElement stars = driver.findElement(By.xpath("(//span[contains(text(),'5 stars')])[1]"));
		Actions builder = new Actions(driver);

		builder.doubleClick(stars).perform();

		Thread.sleep(1000);
		String percentage = driver
				.findElement(By.xpath(
						"(//span[@data-hook='total-rating-count']//following::td[@class='a-text-right a-nowrap'])[1]"))
				.getText();

		System.out.println("customer rating percentage is :" + percentage);

		driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)","");
		
		
		WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
		
	
		builder.moveToElement(addToCart).doubleClick().perform();
		String text = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();

		String cartPrice = text.replaceAll("[^0-9]", "");

		int cartPrice1 = Integer.parseInt(cartPrice);

		if (cartPrice1 == firstPrice) {
			System.out.println("price is same");
		} else {
			System.out.println("price is not same");
		}

	}

}
