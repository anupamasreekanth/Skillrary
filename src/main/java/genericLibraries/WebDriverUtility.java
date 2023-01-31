package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {
	WebDriver driver;
	public WebDriver openApplication(String browser,String url,long time) {
switch(browser) {
case "chrome":driver=new ChromeDriver();break;
case "firefox":driver=new FirefoxDriver();break;
case "edge":driver=new EdgeDriver();break;
default:System.out.println("Invalid browser information");break;
}
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	return driver;
	}
	public void mouseHover(WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	
		public void DoubleClickonElement(WebElement element) {
			Actions a=new Actions(driver);
			a.doubleClick(element).perform();
		}
		
			public void dragAndDropElement (WebElement source,WebElement target) {
				Actions a=new Actions(driver);
				a.dragAndDrop(source,target).perform();
			}
			

				public void dropdown(WebElement element,int index) {
					Select s=new Select(element);
					s.selectByIndex(index);
				}
					
					
					public void dropdown(WebElement element,String value) {
						Select s=new Select(element);
						s.selectByValue(value);
					}	
				
					
					public void handleChildBrowser() {
					 Set<String>windows=driver.getWindowHandles();
					 for(String id:windows) {
						 driver.switchTo().window(id);
					 }
					} 
					 
					 public void switchToFrame(int index) {
					 driver.switchTo().frame(index);
					 }
					 
					  public void switchBackFromFrame() {
					 driver.switchTo().defaultContent();
					 
					  }
					 
					 public void handleAlert() {
					 driver.switchTo().alert().accept();
					}
					
					public void scrollTillElement(WebElement element) {
						JavascriptExecutor js=(JavascriptExecutor)driver;
						js.executeScript("arguments[0].scrollIntoView(true)",element);
						}
					
					public void screenshot()	{
					TakesScreenshot ts=(TakesScreenshot)driver;
					File src=ts.getScreenshotAs(OutputType.FILE);
					File dest=new File("./Screenshot/"+driver.getTitle()+".png");
					
					try {
						FileUtils.copyFile(src,dest);
					}catch(IOException e) {
						e.printStackTrace();
					}
					}
					public void closeCurrentWindow() {
						driver.close();
				}
					public void quitBrowser() {
						driver.quit();
					}
				
				
}				
					
					
					
					
					
					
					
					
					
					
					
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
					 
