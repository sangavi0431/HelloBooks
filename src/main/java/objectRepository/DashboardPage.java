package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HelloBooks.genericlibrary.BaseClass;

public class DashboardPage extends BaseClass {
//Decleration
	@FindBy(xpath="(//button[@type='button'])[7]")
	private WebElement profile;
	
	@FindBy(xpath="(//button[@type='button'])[8])")
	private WebElement logoutbutton;
	
	@FindBy(xpath="//h1[text()='Dashboard']")
	private  WebElement dashboardheader;

//Initialixation
	public DashboardPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);	
}

//Buisnesslogic (Action methods)
	public  boolean isDashboardDisplayed() {
		return s.isElementDisplayed(dashboardheader);
		
	}
	
public LoginPage performlogout() {
		s.clickElement(profile);
		s.clickElement(logoutbutton);
		return new LoginPage(driver);
	}
}