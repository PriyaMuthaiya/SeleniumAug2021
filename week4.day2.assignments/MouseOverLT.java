package week4.day2.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOverLT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/mouseOver.html");
		driver.manage().window().maximize();
		
		WebElement mouse = driver.findElement(By.partialLinkText("TestLeaf"));
		Actions builder=new Actions(driver);
		builder.moveToElement(mouse).perform();
		
		List<WebElement> course = driver.findElements(By.className("listener"));
		for (WebElement ele : course) {
			String text = ele.getText();
			System.out.println(text);
			
		}
		driver.close();
		

		
		
	}

}
