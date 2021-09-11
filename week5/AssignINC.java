package week5.day1.assignments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week5.day2.ReadData;

public class AssignINC extends BaseClassINC{
	
	@Test(dataProvider="sendData")
	public void runAssignINC(String AssignmentGroup) {
		
		driver.findElement(By.id("filter")).sendKeys("Incident");
		driver.findElement(By.xpath("(//div[text()='Incidents'])[1]")).click();
		driver.findElement(By.xpath("(//div[text()='All']/ancestor::a)[2]")).click();
		driver.switchTo().frame("gsft_main");
		
		WebElement expINC = driver.findElement(By.xpath("(//input[@placeholder='Search'])[1]"));
		expINC.sendKeys(CreateNewInc.incNumber);
		expINC.sendKeys(Keys.ENTER);
		
		WebElement searchInc = driver.findElement(By.xpath("//a[@class='linked formlink']"));		
		searchInc.click();
		
		
		driver.findElement(By.id("lookup.incident.assignment_group")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList=new ArrayList<String>(windowHandles);
		System.out.println(windowHandlesList);
		
		String first = windowHandlesList.get(1);
		
		
		driver.switchTo().window(first);
		
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(AssignmentGroup,Keys.ENTER);
		
		driver.findElement(By.linkText("Software")).click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windowHandlesList1=new ArrayList<String>(windowHandles1);
		System.out.println(windowHandlesList1);	
		
		driver.switchTo().window(windowHandlesList1.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("sysverb_update_bottom")).click();
		
		
		
		
		
		
		
	}
	@DataProvider
	public String[][] sendData() throws IOException	
	{
		
		return ReadData.readData("AssignINC");
		
		
	}
	
	
	

}
