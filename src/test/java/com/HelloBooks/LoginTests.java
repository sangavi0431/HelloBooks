package com.HelloBooks;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HelloBooks.genericlibrary.BaseClass;

import objectRepository.DashboardPage;
import objectRepository.LoginPage;

public class LoginTests extends BaseClass{
	@Test(priority=1, description= "TC_017: Verify successful login with valid credentials")
	public void verifySucessfulLogin() throws IOException {
		String email=f.readDataFromPropertyFile("username");
		String password=f.readDataFromPropertyFile("password");
		LoginPage loginpage=new LoginPage(driver);
		DashboardPage dashboardPage=loginpage.login(email,password);
	Assert.assertTrue(dashboardPage.isDashboardDisplayed());
	}
	@Test(priority=2,description = "TC_018/019: Verify login failure with invalid password")
	public void verifyInvalidLogin() throws IOException {
		String validemail=f.readDataFromPropertyFile("username");
		String invalidpassword=f.readDataFromPropertyFile("invalidpassword");
		String expectedErrorMessage="Please enter valid email and password";
		LoginPage loginpage=new LoginPage(driver);
		loginpage.login(validemail, invalidpassword);
		String actualErrorMessage=loginpage.getLoginErrorMessageText(driver);
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}
	}


