package com.setngo.auth;

import java.util.Locale;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import com.setngo.pages.RegistrationPage;
public class loginTest extends baseUiTest {

	private RegistrationPage registrationPage;
	private Faker faker = new Faker(Locale.ENGLISH);
	
	@BeforeClass
	void setUp() throws Exception{
		super.setUpAndroidDriver();
		registrationPage = new RegistrationPage(dr);
		wait.until(ExpectedConditions.visibilityOf(registrationPage.getFirstBtn()));
		registrationPage.getFirstBtn().click();
	}
	
	@Test
	public void loginHappyPathTest() throws Exception {
		registrationPage.loginAs(faker.internet().emailAddress())
		.withPassword(faker.letterify("???????"))
		.login();
	}
}
