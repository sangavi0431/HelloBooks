package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HelloBooks.genericlibrary.BaseClass;

public class EntitySetupPage extends BaseClass{
	//Decleration 
	@FindBy()
    private WebElement entityheader;
	
	//Initialization
	public EntitySetupPage(WebDriver driver) {
	super();
	PageFactory.initElements(driver, this);
	s.waitforVisibility(driver, entityheader, 10);
}
	//Buinesslogic
	
	public boolean isEntitySetupPageDisplayed() {
		return s.isElementDisplayed(entityheader);
	}
}

	
