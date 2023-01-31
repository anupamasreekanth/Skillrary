package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoreJavaForSelenium {
	//Declaration
	@FindBy(xpath="//h2[text()='core java for selenium']") private WebElement pageHeader;
    @FindBy(linkText=" Core Java For Selenium Trainin")private WebElement coreJavaLink;
    
	//Initialization
	public CoreJavaForSelenium(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//Utilization
	public WebElement getPageHeader() {
		return pageHeader;
	}
	public void clickCoreJavaLink() {
		coreJavaLink.click();
	}
}
