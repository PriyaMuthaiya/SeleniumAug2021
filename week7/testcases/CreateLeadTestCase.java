package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Login;

public class CreateLeadTestCase extends BaseClass{
	@BeforeTest
	public void setFileName()
	{
		filename="CreateLead";
		
	}
	
	@Test(dataProvider="sendData")
	public void createLead(String companyName,String firstName,String lastName,String mobile) {
		Login lp=new Login(driver,prop);
		lp.enterUserName()
		.enterPassord()
		.clickLoginButton()
		.clickCRMSFAlink()
		.clickLeadsLink()
		.clickCreateLead()		
		.enterCompanyName(companyName)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.enterPhNo(mobile)
		.clickSubmit()
		.verifyLeadFirstname();
		
		
		
		
	}
	

}
