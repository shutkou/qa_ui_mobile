package com.setngo.auth;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.setngo.pages.RegistrationPage;

public class registrationTest extends baseUiTest {

	private RegistrationPage registrationPage;
	
	@BeforeClass
	void setUp() throws Exception{
		super.setUpAndroidDriver();
		registrationPage = new RegistrationPage(dr);
		wait.until(ExpectedConditions.visibilityOf(registrationPage.getFirstBtn()));
		registrationPage.getFirstBtn().click();
	}
	
	@Test
	public void registrationHappyPathTest() throws Exception {
		registrationPage.createAccount()
		.withEmail("nick@nikolas.com")
		.withPassword("12345678")
		.create();
	}
}
