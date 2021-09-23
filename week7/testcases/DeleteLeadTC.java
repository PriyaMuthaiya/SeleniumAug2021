package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Login;

public class DeleteLeadTC extends BaseClass{
	
	@Test
	public void DeleteLead()
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
		.clickDeleteLead();		
		
		
		
	}

}
