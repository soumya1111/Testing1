package performance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import paths.StudentPath;

public class CancelODSession {
	WebDriver driver;
	boolean isAlertPresent = false;
	Alert alert;
	 @Test(dataProviderClass=Data_Provider.class,dataProvider="Authentication",priority=1)
	  //@Test
	  public void testStudentScheduling(String Username, String Password) throws Exception {
	  //public void testStudentScheduling(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\soumya.rp\\Desktop\\Chromedriver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    //driver = new FirefoxDriver();
	    //driver = new SafariDriver();
	    driver.get("http://192.168.122.124/FEVRevAmp/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    driver.findElement(By.id(StudentPath.UnameID)).clear();
	    driver.findElement(By.id(StudentPath.UnameID)).sendKeys(Username);
	    //driver.findElement(By.id(StudentPath.UnameID)).sendKeys("teststudent10");
	    driver.findElement(By.id(StudentPath.PasswordID)).clear();
	    driver.findElement(By.id(StudentPath.PasswordID)).sendKeys(Password);
	    driver.findElement(By.xpath(StudentPath.LoginXpath)).click();
	    Thread.sleep(2000);
	  if(driver.findElement(By.xpath(StudentPath.CancelSessionPath)).isEnabled())
	  {
		  driver.findElement(By.xpath(StudentPath.CancelSessionPath)).click();
		  driver.findElement(By.xpath(StudentPath.LogOffXpath)).click();
		  alert = driver.switchTo().alert();
		    alert.getText();
		    alert.accept();
	  }
	 	else{
	 		 driver.findElement(By.xpath(StudentPath.LogOffXpath)).click();
	 		    alert = driver.switchTo().alert();
	 		    alert.getText();
	 		    alert.accept();
	 	}
	 }
	 @AfterMethod
	 	   public void quitAll()
	 	   {
	 		driver.close();
 		    driver.quit();
 		    System.gc();
	 	   }
}
