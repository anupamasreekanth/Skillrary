package testscripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class ThirdTest extends BaseClass {
	@Test
	
	public void thirdTest() throws InterruptedException {
		SoftAssert soft= new SoftAssert();
		
		home.searchCourse("core java for Selenium");
		soft.assertTrue(coreJava.getPageHeader().isDisplayed());
		coreJava.clickCoreJavaLink();
		
		soft.assertTrue(javaDemo.getPageHeader().isDisplayed());
		web.switchToFrame(0);
		javaDemo.clickPlayButton();
		Thread.sleep(4000);
		javaDemo.clickPauseButton();
		web.switchBackFromFrame();
		javaDemo.clickAddToWishList();
		Thread.sleep(3000);
		soft.assertAll();
		}
	}
