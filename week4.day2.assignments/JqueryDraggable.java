package week4.day2.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDraggable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		WebElement frame1 = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame1);
		
		WebElement findElement = driver.findElement(By.id("draggable"));
		
		Actions builder=new Actions(driver);
		
		WebElement dest = driver.findElement(By.tagName("body"));
		
		builder.dragAndDrop(findElement, dest).perform();
		
		driver.close();
		
		
		
		
		
		

	}

}
