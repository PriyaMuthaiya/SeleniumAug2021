package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadData;

public class BaseClass {
	public ChromeDriver driver;
	public 	Properties prop;
	public static String firstname;
	public String filename;
	public static String firstnameText;
	@BeforeMethod
	public void preCondition() throws IOException {
		
		FileInputStream fis=new FileInputStream("./src/main/resources/config.propeties");
		 prop=new Properties();
		prop.load(fis);
		
	
		
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
	}
	@DataProvider	
	public String[][] sendData() throws IOException {	
		
		return ReadData.readData(filename);
	
	}
	
		
	
	@AfterMethod
	public void postCondition() {
		driver.close();
		
		
	}
}
