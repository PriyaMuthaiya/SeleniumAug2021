package week4.day1.assignments;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(" https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input")).sendKeys("Selenium Leraning");
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following-sibling::input")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		
		WebElement animal = driver.findElement(By.id("animals"));
		Select animalDDD=new Select(animal);
		
		animalDDD.selectByValue("big baby cat");
		
		driver.switchTo().defaultContent();

	}

}
