package week4.day2.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Jquerysortable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		WebElement frame1 = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame1);
		
		WebElement sort1 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement sort2 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		
		
		Actions builder=new Actions(driver);
		builder.dragAndDrop(sort1, sort2).perform();
		

	}

}
