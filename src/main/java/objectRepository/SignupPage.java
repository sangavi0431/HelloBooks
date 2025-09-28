package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HelloBooks.genericlibrary.BaseClass;

public class SignupPage extends BaseClass {
//Deceration
	
    @FindBy(xpath="//button[text()='Sign up']") 
    private WebElement signupbuttonf;
	
	@FindBy(id="input_first_name")
	    private WebElement firstnamefield;
	
	@FindBy(id="input_last_name")
	    private WebElement lastnamefield;
	
	@FindBy(id="input_your_working_email")
	    private WebElement emailfield;
	
	@FindBy(id="input_password")
	private WebElement passwordfield;
	
	@FindBy(id="input_confirm_password")
	private WebElement confirmpasswordfield;
	
	@FindBy(id="terms")
	private WebElement termscheckbox;
	
	@FindBy(xpath="//div[text()='Sign Up']")
	private WebElement signupbutton;
	
	@FindBy(xpath="//div[text()='E-Mail already exists, please pick a different one.']")
	private WebElement emailexsitsbanner;


//Initialization
public SignupPage(WebDriver driver) {
	super();
	PageFactory.initElements(driver, this);
}
//Buisness logic (Action Methods)
public CodeVerificationPage filAndSubmitSignup(String fName, String lName, String email, String password) {
	s.clickElement(signupbuttonf);
	s.enterText(firstnamefield, fName);
	s.enterText(lastnamefield, lName);
	s.enterText(emailfield, email);
	s.enterText(passwordfield, password);
	s.enterText(confirmpasswordfield, password);
	s.clickElement(termscheckbox);
	s.clickElement(signupbutton);
	return new CodeVerificationPage(driver);
}
public boolean isEmailExitsErrorDisplayed() {
	return s.isElementDisplayed(emailexsitsbanner);
}
}


















