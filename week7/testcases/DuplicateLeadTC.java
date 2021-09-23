package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Login;

public class DuplicateLeadTC extends BaseClass {
	
	
	
	
	@Test
	public void CreateDuplicateLead()
	{
		Login lp=new Login(driver,prop);
		lp.enterUserName()
		.enterPassord()
		.clickLoginButton()
		.clickCRMSFAlink()
		.clickLeadsLink()
		.clickFindLead()
		.enterFirstNameSearch()
		.clickFirstMatchedLeadID()
		.clickDuplicateLead()
		.CreateDuplicateLead()
		.verifyDuplicateLead();
		
		
	}
	
}
