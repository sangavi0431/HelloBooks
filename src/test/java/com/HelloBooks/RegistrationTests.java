package com.HelloBooks;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HelloBooks.genericlibrary.BaseClass;

import objectRepository.CodeVerificationPage;
import objectRepository.EntitySetupPage;
import objectRepository.OrganizationSetupPage;
import objectRepository.SignupPage;

public class RegistrationTests extends BaseClass{
	@Test(priority = 1, description = "TC_001, TC_008: Verify successful full user registration and OTP")
    public void verifyFullRegistrationAndOnboarding() throws IOException {
		String fName = f.readDataFromPropertyFile("regfirstname");
        String lName = f.readDataFromPropertyFile("reglastname");
        String uniqueEmail = f.readDataFromPropertyFile("uniqueemail"); 
        String password = f.readDataFromPropertyFile("regpassword");
        String code = f.readDataFromPropertyFile("validcode"); // Renamed code to otp for clarity
        String orgName = f.readDataFromPropertyFile("orgname");
        String addr1 = f.readDataFromPropertyFile("addr1");
        String city = f.readDataFromPropertyFile("validcountry");
        String state = f.readDataFromPropertyFile("validstate");
        String validZip = f.readDataFromPropertyFile("validzip");
        
        SignupPage signupPage = new SignupPage(driver);
        CodeVerificationPage codePage = signupPage.filAndSubmitSignup(fName, lName, uniqueEmail, password);
        
        OrganizationSetupPage orgPage = codePage.verifyCode(code);
        
        Assert.assertTrue(codePage.isVerificationSucessfull());
        
        EntitySetupPage entityPage = orgPage.submitOrganizationDetails(orgName, addr1, city, state, validZip);
        
        Assert.assertTrue(entityPage.isEntitySetupPageDisplayed());
        
	}
	
@Test(priority = 2, description = "TC_003: Verify registration fails for existing email")
    public void verifyExistingEmailFails() throws IOException {
	String fName = f.readDataFromPropertyFile("regfirstname");
    String lName = f.readDataFromPropertyFile("reglastname");
    String existingEmail = f.readDataFromPropertyFile("existingemail"); 
    String password = f.readDataFromPropertyFile("regpassword");
    
    SignupPage signupPage = new SignupPage(driver);
    signupPage.filAndSubmitSignup(fName, lName, existingEmail, password);
    Assert.assertTrue(signupPage.isEmailExitsErrorDisplayed());
}

@Test(priority = 3, description = "TC_004: Verify password validation for weak password")
public void verifyWeakPasswordFails() throws IOException {
	String fName = f.readDataFromPropertyFile("regfirstname");
    String lName = f.readDataFromPropertyFile("reglastname");
    String email = f.readDataFromPropertyFile("anotheruniqueemail"); 
    String weakPassword = f.readDataFromPropertyFile("weakpassword"); 
    
    SignupPage signupPage = new SignupPage(driver);
    
    CodeVerificationPage codePae=signupPage.filAndSubmitSignup(fName, lName, email, weakPassword);
    
    Assert.assertFalse(codePae.isVerificationSucessfull());
}

  
    
@Test(priority = 4, description = "TC_014: Verify Invalid Zip Code Error - BUG CONFIRMATION")
public void verifyInvalidZipCode() throws IOException {
	String orgName = f.readDataFromPropertyFile("orgname");
    String addr1 = f.readDataFromPropertyFile("addr1");
    String city = f.readDataFromPropertyFile("validcity");
    String state = f.readDataFromPropertyFile("validstate");
    String invalicode = "123456"; // The invalid zip code
    
    OrganizationSetupPage orgPage = new OrganizationSetupPage(driver);
    
    EntitySetupPage entityPage = orgPage.submitOrganizationDetails(orgName, addr1, city, state, invalicode);
    
    Assert.assertFalse(entityPage.isEntitySetupPageDisplayed());
    
}	
}

	
	
