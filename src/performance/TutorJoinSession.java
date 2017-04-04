package performance;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

import paths.TutorPath;

public class TutorJoinSession {
	 WebDriver driver;
	//@Test(dataProviderClass=Data_Provider.class,dataProvider="TAuthentication")
	@Test
	//public void testTutorSessionJoin(String TUserName,String TPassword)
	public void testTutorSessionJoin()
    { 
	   try{
		   //System.setProperty("webdriver.chrome.driver", "C:\\Documents and Settings\\soumya.rp\\My Documents\\softwares\\chromedriver\\chromedriver.exe");
		    //driver = new ChromeDriver();
		    driver = new FirefoxDriver();
		    driver.get("http://192.168.122.124/FEVRevAmp/");
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		   // driver = new SafariDriver();
	
		    driver.findElement(By.id(TutorPath.UnameID)).clear();
		    //driver.findElement(By.id(TutorPath.UnameID)).sendKeys(TUserName);
		    driver.findElement(By.id(TutorPath.UnameID)).sendKeys("Tutor03");
		    driver.findElement(By.id(TutorPath.PasswordID)).clear();
		    //driver.findElement(By.id(TutorPath.PasswordID)).sendKeys(TPassword);
		    driver.findElement(By.id(TutorPath.PasswordID)).sendKeys("123");
		    driver.findElement(By.xpath(TutorPath.LoginXpath)).click();
		    Thread.sleep(3000);
		    WebDriverWait wait = new WebDriverWait(driver,30);		 
		   // wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TutorPath.GoOnlineMasterXpath)));
			if(driver.findElement(By.xpath(TutorPath.GoOnlineMasterXpath)).isDisplayed()==true)
			{
			driver.findElement(By.xpath(TutorPath.GoOnlineMasterXpath)).click();
			}
			Thread.sleep(6000);
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TutorPath.CommonODSessionJoinXpath1)));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TutorPath.CommonODSessionJoinXpath1)));
		    System.out.println("Found element , clicking on join now ");
		    
		    Set handle = driver.getWindowHandles();
		    String shandle = driver.getWindowHandle();
		    System.out.println(handle);
		    System.out.println(shandle+":S handle");
		    WebDriverWait  wait1 = new WebDriverWait(driver,20);
		    //wait1.until(ExpectedConditions.elementToBeClickable(By.linkText("Join Now")));
		    driver.findElement(By.xpath(TutorPath.CommonODSessionJoinXpath1)).click();
		    Thread.sleep(10000);
		    Set handles = driver.getWindowHandles();
		    System.out.println(handles);
		    handles.removeAll(handle);
		    System.out.println(handles);
		    String Present_Handle = (String)handles.iterator().next();
		    String AHandle = Present_Handle;
		    driver.switchTo().window(AHandle);
		    System.out.println("Switch to the window and frame for tutor  ");
		    Thread.sleep(3000);
		    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='messageBox']")));
		    driver.findElement(By.id("messageBox")).sendKeys("Hello I am "+"TUserName"+"\n");
		    driver.switchTo().window(shandle);
		    if(isAlertPresent())
	     {
	    	    driver.switchTo().alert();
	            driver.switchTo().alert().accept();
	            driver.switchTo().defaultContent();
	     }
		    /*String MHandle = (String)handle.iterator().next();
		    String MotHandle = MHandle;
		    System.out.println(MotHandle);
		    driver.switchTo().window(MotHandle);*/
		    System.out.println("Trying to switch to "+shandle);
		    driver.switchTo().window(shandle);
		    String currentHandle = driver.getWindowHandle();
		    System.out.println(currentHandle);
		   // Thread.sleep(5000);
		   // driver.close();
		    driver.quit();
		    driver.quit();
		    System.gc();
	  }catch(Exception e)
	  {
		  e.printStackTrace();
	  }
    } 
	 @AfterMethod
	   public boolean isAlertPresent(){
	        try{
	            driver.switchTo().alert();
	            return true;
	        }//try
	        catch(Exception e){
	            return false;
	        }//catch
}



}
