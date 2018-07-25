package com.qa.hfmt.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hfmt.base.TestBase;

public class LoginPage extends TestBase{

	TestBase testBase;
	HitachiHomePage hitachiHomePage;
	public LoginPage() throws Exception {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	//Login Page box Title
	@FindBy(xpath="//span[text()='Hitachi Fleet Monitoring Tool']")
	@CacheLookup
	WebElement loginBoxTitle;
	
	
	//login input
	@FindBy(xpath="//input[@id='usernameInput']")
	@CacheLookup
	WebElement loginInput;
	
	//password input
	@FindBy(xpath="//input[@id='password']")
	@CacheLookup
	WebElement passwordInput;
	
	//Login Button
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement loginBtn;
	
	
	public HitachiHomePage userLogin() {
		System.out.println("userLogin Method");
		loginInput.sendKeys(prop.getProperty("username"));
		passwordInput.sendKeys(prop.getProperty("password"));
		loginBtn.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hitachiHomePage;
		
	}
	
	
	
}
