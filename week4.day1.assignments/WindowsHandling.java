package week4.day1.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling {

	public static void main(String[] args) throws InterruptedException {

		// * 1. Launch URL "http://leaftaps.com/opentaps/control/login"

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();

		// 5. Click on Leads Button

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[1]")).click();
		// frist window
		Set<String> setWindow = driver.getWindowHandles();
		List<String> listWindow = new ArrayList<String>(setWindow);
		String first = listWindow.get(1);
		System.out.println(listWindow);

		driver.switchTo().window(first);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//label[text()='First name:']/following::input[@name='firstName']"))
				.sendKeys("priya");
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//td[contains(@class,'partyId')])[2]//a")).click();
		// switch back to old window

		String main = listWindow.get(0);

		driver.switchTo().window(main);
		String title = driver.getTitle();
		System.out.println(title);

		// to lead

		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click(); // frist window

		Set<String> setWindow1 = driver.getWindowHandles();
		List<String> listWindow1 = new ArrayList<String>(setWindow1);
		System.out.println(listWindow1);

		driver.switchTo().window(listWindow1.get(1));

		driver.findElement(By.xpath("//label[text()='First name:']/following::input[@name='firstName']"))
				.sendKeys("priya");
		driver.findElement(By.xpath("//button[text()='Find Contacts']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//td[contains(@class,'partyId')])[3]//a")).click();

		driver.switchTo().window(listWindow1.get(0));
		Thread.sleep(1000);
		driver.findElement(By.linkText("Merge")).click();

		Alert alert = driver.switchTo().alert();
		alert.accept();

		String title2 = driver.getTitle();
		System.out.println(title2);
		
		driver.close();

		// 6. Click on create Lead Button
		// * 2. Enter UserName and Password Using Id Locator

		// * 3. Click on Login Button using Class Locator
		/*
		 * * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */
	}

}
