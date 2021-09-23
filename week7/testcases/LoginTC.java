package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.Login;

public class LoginTC extends BaseClass{

	
	@Test
	public void LoginTestcase() {
		Login lp=new Login(driver,prop);
		lp.enterUserName()
		.enterPassord()
		.clickLoginButton();
		
		
	}
		

}


