package week4.day2.Assignments;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortableActions {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://leafground.com/pages/sortable.html");
		driver.manage().window().maximize();
		
		Actions builder=new Actions(driver);
		
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		
		Point location = item5.getLocation();
		int x = location.getX();
		int y = location.getY();
		builder.dragAndDropBy(item1, x, y).perform();
		
		File src = item1.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snap/sortable.png");
		FileUtils.copyFile(src, dest);
		
		driver.close();
		
		
	
		
		
		
		
		
		
		
		

	}

}
