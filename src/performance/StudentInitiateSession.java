package performance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import paths.StudentPath;

public class StudentInitiateSession {
	WebDriver driver =null;
	@Test(dataProviderClass=Data_Provider.class,dataProvider="Authentication",priority=1)
	  public void testStudentScheduling(String Username, String Password) throws Exception {
	  //public void testStudentScheduling(){
		  try{
		//System.setProperty("webdriver.chrome.driver", "C:\\Documents and Settings\\soumya.rp\\My Documents\\softwares\\chromedriver\\chromedriver.exe");
	    //driver = new ChromeDriver();
	    driver = new FirefoxDriver();
	    //driver = new SafariDriver();
	    driver.get("http://192.168.122.124/FEVRevAmp/");
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
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(StudentPath.RequestODXpath)));
	   driver.findElement(By.xpath(StudentPath.RequestODXpath)).click();
	   Thread.sleep(5000);
	    new Select(driver.findElement(By.id(StudentPath.SubjectID))).selectByVisibleText("Math");
	    //Thread.sleep(500);
	    new Select(driver.findElement(By.id(StudentPath.CourseID))).selectByVisibleText("Trignometry");
	    driver.findElement(By.xpath(StudentPath.QuestionXpath)).sendKeys("Testing don't pick :");
	    driver.findElement(By.id(StudentPath.InitiateODID)).click();
	    //wait.until(ExpectedConditions.elementToBeClickable(By.xpath(StudentPath.LogOffXpath)));
	    Thread.sleep(5000);
	    driver.findElement(By.xpath(StudentPath.LogOffXpath)).click();
	    if(isAlertPresent())
	     {
	    	    driver.switchTo().alert();
	            driver.switchTo().alert().accept();
	            driver.switchTo().defaultContent();
	     }
	    System.out.println("After Alert Loop");
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
