package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Login;

public class MergeLeadTC extends BaseClass{
	
	
	@BeforeTest
	public void setFileName()
	{
		filename="MergeLead";
		
	}
	@Test(dataProvider="sendData")
	public void createLead(String from,String to) throws InterruptedException {
		Login lp=new Login(driver,prop);
		lp.enterUserName()
		.enterPassord()
		.clickLoginButton()
		.clickCRMSFAlink()
		.clickLeadsLink()
		.clickMergeLead()
		.clickToLead(from)
		.clickFromLead(to)
		.clickMergeLeadButton();
		
	}

}
