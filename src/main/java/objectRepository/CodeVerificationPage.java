package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HelloBooks.genericlibrary.BaseClass;

public class CodeVerificationPage extends BaseClass{
	//Decleration
	@FindBy(xpath="(//input[@maxlength='6'])[1]")
	 private WebElement codeinput;
	
	@FindBy(xpath="//div[text()='Verify']")
	private WebElement verifybutton;
	
	@FindBy(xpath="//div[text()='Email verified successfully!']")
	private WebElement successmessage;
	
	//Initialization
public CodeVerificationPage(WebDriver driver) {
	super();
	PageFactory.initElements(driver, this);
}

//Buisnesslogic (Actions methods)
public OrganizationSetupPage verifyCode(String code) {
	s.enterText(codeinput, code);
	s.clickElement(verifybutton);
	return new OrganizationSetupPage(driver);	
}
public boolean isVerificationSucessfull() {
	return s.isElementDisplayed(successmessage);
}

}
























//span[text()='Resend Code']   resend code
//div[text()='Enter the code'] enter the code page
//div[text()='Back']