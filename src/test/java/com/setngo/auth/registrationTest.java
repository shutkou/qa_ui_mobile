package com.setngo.auth;
import java.util.Locale;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.setngo.pages.RegistrationPage;
public class registrationTest extends baseUiTest {

	private RegistrationPage registrationPage;
	private Faker faker = new Faker(Locale.ENGLISH);
	
	@BeforeClass
	void setUp() throws Exception{
		registrationPage = new RegistrationPage(dr);
		wait.until(ExpectedConditions.visibilityOf(registrationPage.getFirstBtn()));
		registrationPage.getFirstBtn().click();
	}
	
	@Test
	public void registrationHappyPathTest() throws Exception {
		registrationPage.createAccount()
		.withEmail(faker.internet().emailAddress())
		.withPassword(faker.letterify("???????"))
		.create();
	}
	
	@Test
	public void printTest1() throws Exception {
		System.out.println("Test 1");
	}
	
	@Test
	public void printTest2() throws Exception {
		System.out.println("Test 2");
	}
}
