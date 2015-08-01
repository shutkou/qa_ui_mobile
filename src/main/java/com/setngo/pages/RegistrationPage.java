package com.setngo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class RegistrationPage {
	
	private final AppiumDriver<WebElement> driver;
	private WebDriverWait wait;
	
	public RegistrationPage(AppiumDriver<WebElement> driver) {
		this.wait = new WebDriverWait(driver, 3200000);
		this.driver = driver;
	}

	private By firstBtn = By.id("android:id/button1");
	private By signInBtn = By.id("com.setngo.setngodriver:id/sign_in");
	private By registerBtn = By.id("com.setngo.setngodriver:id/register");
	private By emailField = By.id("com.setngo.setngodriver:id/email");
	private By passwordField = By.id("com.setngo.setngodriver:id/pass");
	private By confirmPasswordField = By.id("com.setngo.setngodriver:id/conf_pass");
	private By termsCheckBox = By.id("com.setngo.setngodriver:id/terms_checkbox");
	private By finishBtn = By.id("com.setngo.setngodriver:id/login");
	
	private String email;
	private String password;
	private String confirmPassword;
	private Boolean termsConfirmed = true;
	
	
	public WebElement getFirstBtn(){
		return driver.findElement(firstBtn);
	}
	
	public WebElement getSignInBtn(){
		return driver.findElement(signInBtn);
	}
	
	public WebElement getRegisterBtn(){
		return driver.findElement(registerBtn);
	}
	
	public WebElement getEmailField(){
		return driver.findElement(emailField);
	}
	
	public WebElement getPasswordField(){
		return driver.findElement(passwordField);
	}
	
	public WebElement getConfirmPasswordField(){
		return driver.findElement(confirmPasswordField);
	}
	
	public WebElement getTermsCheckBox(){
		return driver.findElement(termsCheckBox);
	}
	
	public WebElement getFinishBtn(){
		return driver.findElement(finishBtn);
	}
	
	public RegistrationPage createAccount() {
		return this;
	}
	
	public RegistrationPage withEmail(String email) {
		this.email = email;
		return this;
	}
	
	public RegistrationPage withPassword(String password) {
		this.password = password;
		return this;
	}
	
	public RegistrationPage withConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
		return this;
	}
	
	public RegistrationPage withTerms(Boolean termsConfirmed) {
		this.termsConfirmed = termsConfirmed;
		return this;
	}
	
	public void create() {
		wait.until(ExpectedConditions.elementToBeClickable(this.getRegisterBtn()));
		this.getRegisterBtn().click();
		this.fillOutEmail(email);
		this.fillOutPassword(password);
		this.fillOutConfirmPassword(confirmPassword);
		this.confirmTerms(termsConfirmed);
		this.getFinishBtn().click();
	}
	
	public void fillOutEmail(String email){
		this.getEmailField().sendKeys(email);
	}
	
	public void fillOutPassword(String password){
		this.getPasswordField().sendKeys(password);
	}
	
	public void fillOutConfirmPassword(String confirmPassword){
		if(confirmPassword == null)
			confirmPassword = this.password;
		this.getConfirmPasswordField().sendKeys(confirmPassword);
	}
	
	public void confirmTerms(Boolean termsConfirmed){
		if(termsConfirmed)
		this.getTermsCheckBox().click();
	}
}
