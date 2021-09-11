package week5.day1.assignments;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassINC {
	
	public WebDriver driver;

	@Parameters({"url","userName","password"})
	@BeforeMethod
	public void RunPreRequisite(String url,String UName,String pwd) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		driver.switchTo().frame("gsft_main");

		driver.findElement(By.id("user_name")).sendKeys(UName);
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		driver.findElement(By.id("sysverb_login")).click();
		driver.switchTo().defaultContent();

	}

	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}

}
