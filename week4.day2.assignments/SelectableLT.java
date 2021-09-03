package week4.day2.Assignments;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectableLT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();

		Actions builder = new Actions(driver);

		WebElement src = driver.findElement(By.xpath("//li[text()='Item 1']"));

		WebElement dest = driver.findElement(By.xpath("//li[text()='Item 4']"));

		builder.clickAndHold(src).moveToElement(dest).release().perform();

		File source = src.getScreenshotAs(OutputType.FILE);
		File destnation = new File(".\snaps\selectable.png");
		

		driver.close();

	}

}
