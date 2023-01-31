package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.ContactUsPage;
import pomPages.CoreJavaDemoVideoPge;
import pomPages.CoreJavaForSelenium;
import pomPages.SeleniumTrainingPage;
import pomPages.SkillraryDemoAppPage;
import pomPages.SkillraryHomePage;
import pomPages.TestingPage;

public class BaseClass {
	protected PropertiesFileUtility property;
	protected ExcelFileUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected SkillraryHomePage home;
	protected SkillraryDemoAppPage demoApp;
	protected ContactUsPage contact;
	protected SeleniumTrainingPage selenium;
	protected TestingPage testing;
	protected CoreJavaForSelenium coreJava;
	protected CoreJavaDemoVideoPge javaDemo;
	//@BeforeSuite
	//@BeforeTest
	
	@BeforeClass
public void classSetup() {
		property=new PropertiesFileUtility();
		excel=new ExcelFileUtility();
		web=new WebDriverUtility();
		
		property.propertiesInitialization(IConstantPath.PROPERTY_FILE_PATH);
		String browser=property.fetchProperty("browser");
		String url=property.fetchProperty("url");
		long time=Long.parseLong(property.fetchProperty("timeouts"));
		
		driver=web.openApplication(browser,url,time);
		home=new SkillraryHomePage(driver);
		Assert.assertTrue(home.getLogo().isDisplayed());
		}
	@BeforeMethod
	public void methodSetup() {
		excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
		demoApp=new SkillraryDemoAppPage(driver);
		contact=new ContactUsPage(driver);
		selenium=new SeleniumTrainingPage(driver);
		testing=new TestingPage(driver);
		coreJava=new CoreJavaForSelenium(driver);
		javaDemo=new CoreJavaDemoVideoPge(driver);
		}
	@AfterMethod
	public void methodTearDown() {
		excel.closeWorkbook();
	}
	@AfterClass
	public void classTearDown() {
		web.quitBrowser();
	}
	//@AfterTest
	//@Aftersuite
	}