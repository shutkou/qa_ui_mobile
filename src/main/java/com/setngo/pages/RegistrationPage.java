package com.setngo.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegistrationPage {
	
	private final AppiumDriver<WebElement> driver;
	private WebDriverWait wait;
	
	public RegistrationPage(AppiumDriver<WebElement> driver) {
		this.wait = new WebDriverWait(driver, 52);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
	}
	
	@FindBy(id = "android:id/button1")
	@AndroidFindBy(id="android:id/button1")
	private WebElement firstBtn;
	
	@AndroidFindBy(id = "com.setngo.setngodriver:id/sign_in")
	private WebElement signInBtn;
	
	@FindBy(id = "com.setngo.setngodriver:id/register")
	@AndroidFindBy(id = "com.setngo.setngodriver:id/register")
	private WebElement registerBtn;
	
	@FindBy(id = "com.setngo.setngodriver:id/email")
	@AndroidFindBy(id = "com.setngo.setngodriver:id/email")
	private WebElement emailField;
	
	@FindBy(id = "com.setngo.setngodriver:id/pass")
	@AndroidFindBy(id = "com.setngo.setngodriver:id/pass")
	private WebElement passwordField;
	
	@FindBy(id = "com.setngo.setngodriver:id/conf_pass")
	@AndroidFindBy(id = "com.setngo.setngodriver:id/conf_pass")
	private WebElement confirmPasswordField;
	
	@FindBy(id = "com.setngo.setngodriver:id/terms_checkbox")
	@AndroidFindBy(id = "com.setngo.setngodriver:id/terms_checkbox")
	private WebElement termsCheckBox;

	@FindBy(id = "com.setngo.setngodriver:id/login")
	@AndroidFindBy(id = "com.setngo.setngodriver:id/login")
	private WebElement finishBtn;

	private String email;
	private String password;
	private String confirmPassword;
	private Boolean termsConfirmed = true;
	
	public WebElement getFirstBtn(){
		return firstBtn;
	}
	
	public WebElement getSignInBtn(){
		return signInBtn;
	}
	
	public WebElement getRegisterBtn(){
		return registerBtn;
	}
	
	public WebElement getEmailField(){
		return emailField;
	}
	
	public WebElement getPasswordField(){
		return passwordField;
	}
	
	public WebElement getConfirmPasswordField(){
		return confirmPasswordField;
	}
	
	public WebElement getTermsCheckBox(){
		return termsCheckBox;
	}
	
	public WebElement getFinishBtn(){
		return finishBtn;
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
