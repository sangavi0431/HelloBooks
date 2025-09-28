package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HelloBooks.genericlibrary.BaseClass;

public class OrganizationSetupPage extends BaseClass{
	//Decleration
	@FindBy(id="input_organization_name")
	private WebElement oganiationnamefield;
	
	@FindBy(id="[id='input_address_line_1']")
	private WebElement adressline1field;
	
	@FindBy(xpath="//div[text()='India (INR)']")
	private WebElement countrydropdown;
	
	@FindBy(xpath="//div[text()='Tamil Nadu']")
	private WebElement statedropdown;
   	
	@FindBy (id="input_zip_code")
	private WebElement zipcodefield;
	
	@FindBy(xpath="//div[text()='Next']")
	private WebElement nextbutton;
	
	//Initialization
	public OrganizationSetupPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}
	
	//Buisnesslogic (Actions methods)
	public EntitySetupPage submitOrganizationDetails(String orgName, String add1, String country, String state, String zipCode) {
		s.enterText(oganiationnamefield, orgName);
		s.enterText(adressline1field, add1);
		s.selectDropdownByVisibleText(countrydropdown, country);
		s.selectDropdownByVisibleText(statedropdown, state);
		s.enterText(zipcodefield, zipCode);
		s.clickElement(nextbutton);
		return new EntitySetupPage(driver);
	
	}
public OrganizationSetupPage verifyCode(String code) {
		// TODO Auto-generated method stub
		return null
	;
	}	
}
