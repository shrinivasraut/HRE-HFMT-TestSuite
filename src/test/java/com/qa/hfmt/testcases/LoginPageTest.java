package com.qa.hfmt.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hfmt.base.TestBase;
import com.qa.hfmt.pages.HitachiHomePage;
import com.qa.hfmt.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HitachiHomePage hitachiHomePage;
	LoginPageTest loginPageTest;
	
	public LoginPageTest() {
		super();
		System.out.println("Login Test Page constructor");
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws Exception {
	initialization();	
	loginPage = new LoginPage();
	System.out.println("before method");
	}
	
	@Test
	public void userlogin() {
		System.out.println("in Test method");	
		hitachiHomePage=loginPage.userLogin();
		
	}
	
	
	@AfterMethod
	public void closePage() {
		driver.close();
	}
	
}
