package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HelloBooks.genericlibrary.BaseClass;

public class LoginPage extends BaseClass {
//decleration
	@FindBy(id="input_your_working_email")                               
	    private WebElement emailfield;
	
	@FindBy(id="input_password")
	    private WebElement passwordfield;
	
	@FindBy(xpath="//div[text()='Sign In']")
	    private WebElement signinbutton;

	@FindBy(xpath="//div[text()='Invalid password']")
	    private WebElement loginerrorbanner;
	
//Intialization
public LoginPage(WebDriver driver) {
	super();
	PageFactory.initElements(driver, this);
}

//Buisness logic(Actions methods)
 public DashboardPage login(String email,String password) {
	 s.enterText(emailfield,email);
	 s.enterText(passwordfield,password);
	 s.clickElement(signinbutton);
	 return new DashboardPage(driver);
 }

public String getLoginErrorMessageText(WebDriver driver) {
	s.waitforVisibility(driver,loginerrorbanner,15);
	return loginerrorbanner.getText();
}
}







