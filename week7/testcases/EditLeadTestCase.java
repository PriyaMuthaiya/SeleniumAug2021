package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Login;

public class EditLeadTestCase extends BaseClass {

	@BeforeTest
	public void setFile()
	{
		filename="EditLead";
	}
	
	@Test(dataProvider="sendData")
	public void EditLeadTC(String desc)
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
		.clickEditeLead()
		.updateDescription(desc)
		.clickUpdateButton();
		
		
		
		
		
	
	}
	

}
