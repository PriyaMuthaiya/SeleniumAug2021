package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class DeleteLead extends BaseClass{
	
	public DeleteLead(ChromeDriver driver)
	{
		this.driver=driver;
	}

	
	public DeleteLead selectReason()
	{
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWindow=new ArrayList<String>(windowHandles);
		
		String child = listWindow.get(1);
		String parent= listWindow.get(0);
		driver.switchTo().window(child);
		
		driver.findElement(By.linkText("THE ADMINISTRATOR (admin)")).click();
		
		driver.switchTo().window(parent);
		return this;
		
		
	}
	
	
	public Leads clickDeleteLink()
	{
		driver.findElement(By.linkText("Delete")).click();
		return new Leads(driver);
	}
}
