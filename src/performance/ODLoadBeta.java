package performance;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import paths.StudentPath;
import paths.TutorPath;
import test.Utility;


public class ODLoadBeta {
	 private WebDriver driver ;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  @Test(dataProviderClass=Data_Provider.class,dataProvider="Authentication",priority=1)
	  //@Test
	  public void testStudentScheduling(String Username, String Password) throws Exception {
	  //public void testStudentScheduling(){
		  try{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\soumya.rp\\Desktop\\Chromedriver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    //driver = new FirefoxDriver();
	    //driver = new SafariDriver();
	    driver.get("http://beta.fevtutor.com");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    driver.findElement(By.id(StudentPath.UnameID)).clear();
	    driver.findElement(By.id(StudentPath.UnameID)).sendKeys(Username);
	    //driver.findElement(By.id(StudentPath.UnameID)).sendKeys("teststudent10");
	    driver.findElement(By.id(StudentPath.PasswordID)).clear();
	    driver.findElement(By.id(StudentPath.PasswordID)).sendKeys(Password);
	    //driver.findElement(By.id(StudentPath.PasswordID)).sendKeys("123");
	    driver.findElement(By.xpath(StudentPath.LoginXpath)).click();
	    WebDriverWait wait = new WebDriverWait(driver, 30);
	    Thread.sleep(3000);
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(StudentPath.RequestODXpath)));
	    driver.findElement(By.xpath(StudentPath.RequestODXpath)).click();
	    //new Select(driver.findElement(By.xpath(StudentPath.GradeXpath))).selectByVisibleText("First");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(StudentPath.SubjectWCID)));
	    new Select(driver.findElement(By.id(StudentPath.SubjectWCID))).selectByVisibleText("Math");
	    Thread.sleep(500);
	    new Select(driver.findElement(By.id(StudentPath.CourseWCID))).selectByVisibleText("Arithametic");
	    driver.findElement(By.xpath(StudentPath.QuestionWCXpath)).sendKeys("Testing don't pick "+Username);
	   //driver.findElement(By.id(StudentPath.InitiateODID)).click();
	    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(StudentPath.LogOffXpath)));
	    Thread.sleep(5000);
	    System.out.println("Scheduled session for "+Username);
	    driver.findElement(By.xpath(StudentPath.LogOffXpath)).click();
	    if(isAlertPresent())
	     {
	    	    driver.switchTo().alert();
	            driver.switchTo().alert().accept();
	            driver.switchTo().defaultContent();
	     }
	    driver.close();
	    driver.quit();
	    System.gc();
	  }catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  }
		  @Test(dataProviderClass=Data_Provider.class,dataProvider="TAuthentication",dependsOnMethods="testStudentScheduling")
			public void testTutorSessionJoin(String TUserName,String TPassword)
		    { 
			   try{
				   System.setProperty("webdriver.chrome.driver", "C:\\Users\\soumya.rp\\Desktop\\Chromedriver\\chromedriver.exe");
				    driver = new ChromeDriver();
				    //driver = new FirefoxDriver();
				    driver.get("http://beta.fevtutor.com");
				    driver.manage().window().maximize();
				    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				   // driver = new SafariDriver();
			
				    driver.findElement(By.id(TutorPath.UnameID)).clear();
				    //driver.findElement(By.id(TutorPath.UnameID)).sendKeys(TUserName);
				    driver.findElement(By.id(TutorPath.UnameID)).sendKeys(TUserName);
				    driver.findElement(By.id(TutorPath.PasswordID)).clear();
				    //driver.findElement(By.id(TutorPath.PasswordID)).sendKeys(TPassword);
				    driver.findElement(By.id(TutorPath.PasswordID)).sendKeys(TPassword);
				    driver.findElement(By.xpath(TutorPath.LoginXpath)).click();
				    Thread.sleep(3000);
				    WebDriverWait wait = new WebDriverWait(driver,30);		 
				   // wait.until(ExpectedConditions.elementToBeClickable(By.xpath(TutorPath.GoOnlineMasterXpath)));
					if(driver.findElement(By.xpath(TutorPath.GoOnlineMasterXpath)).isDisplayed()==true)
					{
					driver.findElement(By.xpath(TutorPath.GoOnlineMasterXpath)).click();
					}
					Thread.sleep(6000);
					String SName ="trainingstudent";
					String question = Utility.getQuestion(SName, TUserName);
				   //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TutorPath.CommonODSessionJoinXpath1)));
				    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+question+"')]")));
				    WebElement we1 = driver.findElement(By.xpath("//td[contains(text(),'"+question+"')]/../td[12]/input[@id='btnJoinNow']"));
				    if(we1.isEnabled())
				    {
					driver.findElement(By.xpath("//td[contains(text(),'"+question+"')]/../td[12]/input[@id='btnJoinNow']")).click();
				    System.out.println("Found element , clicking on join now ");
				   	Set handle = driver.getWindowHandles();
				   	String shandle = driver.getWindowHandle();
				   	System.out.println(handle);
				   	System.out.println(shandle+":S handle");
				   	WebDriverWait  wait1 = new WebDriverWait(driver,20);
				   	//wait1.until(ExpectedConditions.elementToBeClickable(By.linkText("Join Now")));
				   	//driver.findElement(By.xpath(TutorPath.CommonODSessionJoinXpath1)).click();
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
				   	driver.findElement(By.id("messageBox")).sendKeys("Hello I am "+TUserName+"\n");
				   	// To end session 
				   	driver.findElement(By.xpath("//*[@id='btnSessionEnd']")).click();
				    Thread.sleep(1000);
				    driver.findElement(By.id("alertify-ok")).click();
				    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TutorPath.NoShowXpath)));
				    driver.findElement(By.xpath(TutorPath.NoShowXpath)).click();
				    driver.findElement(By.xpath(TutorPath.SubmitDraftXpath)).click();
				    // Till end session
				   	driver.switchTo().window(shandle);
				   	if(isAlertPresent())
				   	{
				   		driver.switchTo().alert();
				   		driver.switchTo().alert().accept();
				   		driver.switchTo().defaultContent();
				   	}
				   	System.out.println("Trying to switch to "+shandle);
				   	driver.switchTo().window(shandle);
				   	String currentHandle = driver.getWindowHandle();
				   	System.out.println(currentHandle);
				   	driver.quit();
				   	driver.quit();
				   	System.gc();
				    }else{
				    	driver.quit();
					   	driver.quit();
					   	System.gc();
				    }
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
@AfterClass
public void closeAll()
{
	 driver.close();
	 System.out.println("Quiting Driver object");
	    driver.quit();
	    driver.quit();
	    System.gc();
}

}
