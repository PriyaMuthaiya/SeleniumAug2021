package week5.day1.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteINC extends BaseClassINC{

	@Test
	public void runDeleteINC() {
		driver.findElement(By.id("filter")).sendKeys("Incident");
		driver.findElement(By.xpath("(//div[text()='Incidents'])[1]")).click();
		driver.findElement(By.xpath("(//div[text()='All']/ancestor::a)[2]")).click();
		driver.switchTo().frame("gsft_main");
		
		WebElement expINC = driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]"));
		expINC.sendKeys(CreateNewInc.incNumber);
		expINC.sendKeys(Keys.ENTER);
		
		WebElement searchInc = driver.findElement(By.xpath("//a[@class='linked formlink']"));		
		searchInc.click();
		
		
		driver.findElement(By.id("sysverb_delete")).click();
		
		driver.findElement(By.id("ok_button")).click();
		
		
		
	}
}

