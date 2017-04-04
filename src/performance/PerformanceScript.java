package performance;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class PerformanceScript {
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  Properties properties = new Properties();
	  @Test(dataProviderClass=Data_Provider.class,dataProvider="Authentication",priority=1)
	  public void testStudentScheduling(String Username, String Password) throws Exception {
		  try{
		System.setProperty("webdriver.chrome.driver", "C:\\Documents and Settings\\soumya.rp\\My Documents\\softwares\\chromedriver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    //driver = new FirefoxDriver();
	    //driver = new SafariDriver();
	    driver.get("http://tltwb.focuseduvation.com/Login.aspx");
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.id("txtUserName")).clear();
	    driver.findElement(By.id("txtUserName")).sendKeys(Username);
	    driver.findElement(By.id("txtPassword")).clear();
	    driver.findElement(By.id("txtPassword")).sendKeys(Password);
	    driver.findElement(By.id("btnLogin")).click();
	    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlSubject"))).selectByVisibleText("Bio1");
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector("option[value=\"108\"]")).click();
	    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlTopic"))).selectByVisibleText("Anatomy");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtQuestion")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtQuestion")).sendKeys("Testing don't pick 03.04.2015");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnContinue")).click();
	    if(isAlertPresent())
	     {
	    	    driver.switchTo().alert();
	            driver.switchTo().alert().accept();
	            driver.switchTo().defaultContent();
	     }
	    //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
	    Thread.sleep(3000);
	    driver.findElement(By.id("ctl00_lnkbtnLogut")).click();
	    Alert alert = driver.switchTo().alert();
	    alert.getText();
	    alert.accept();
	    driver.quit();
	    System.gc();
	  }catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  }
	  //,dependsOnMethods= { "testStudentScheduling" }
	   /*@Test(dataProviderClass=Data_Provider.class,dataProvider="TAuthentication",dependsOnMethods= { "testStudentScheduling" })
	     public void testTutorSessionJoin(String TUserName,String TPassword)
	      { 
		   try{
			   System.setProperty("webdriver.chrome.driver", "C:\\Documents and Settings\\soumya.rp\\My Documents\\softwares\\chromedriver\\chromedriver.exe");
			    driver = new ChromeDriver();
			 //driver = new FirefoxDriver();
			   // driver = new SafariDriver();
			    driver.get("http://gtwt.focuseduvation.com/Login.aspx");
			    driver.findElement(By.id("txt_username")).clear();
			    driver.findElement(By.id("txt_username")).sendKeys(TUserName);
			    driver.findElement(By.id("txt_password")).clear();
			    driver.findElement(By.id("txt_password")).sendKeys(TPassword);
			    driver.findElement(By.id("btn_submit")).click();
			    Thread.sleep(3000);
			    WebDriverWait wait = new WebDriverWait(driver,30);
				//wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_ContentPlaceHolder1_imgbtnGoOnline")));
			    driver.navigate().to("http://gtwt.focuseduvation.com/Tutor/T_Dashboardnew.aspx");
			    wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_ContentPlaceHolder1_imgbtnGoOnline")));
			    Thread.sleep(2000);
				if(driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgbtnGoOnline")).isDisplayed()==true)
				{
				driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgbtnGoOnline")).click();
				}
				Thread.sleep(6000);
			    wait.until(ExpectedConditions.elementToBeClickable((By.id("ctl01_gvTutor_ctl02_lnkSelect"))));
			    driver.findElement(By.id("ctl01_gvTutor_ctl02_lnkSelect")).click();
			    Alert alert = driver.switchTo().alert();
			    alert.getText();
			    alert.accept();
			    Set handle = driver.getWindowHandles();
			    System.out.println(handle);
			    WebDriverWait  wait1 = new WebDriverWait(driver,20);
			    wait1.until(ExpectedConditions.elementToBeClickable(By.linkText("Join Now")));
			    driver.findElement(By.linkText("Join Now")).click();
			    Thread.sleep(10000);
			    Set handles = driver.getWindowHandles();
			    System.out.println(handles);
			    handles.removeAll(handle);
			    System.out.println(handles);
			    String Present_Handle = (String)handles.iterator().next();
			    String AHandle = Present_Handle;
			    driver.switchTo().window(AHandle);
			    driver.switchTo().frame("iframeNE");
			    System.out.println("Switch to the window and frame for tutor  "+TUserName);
			    Thread.sleep(3000);
			    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='messageBox']")));
			    driver.findElement(By.id("messageBox")).sendKeys("Hello I am "+TUserName+"\n");
			    driver.close();
			    String MHandle = (String)handle.iterator().next();
			    String MotHandle = MHandle;
			    driver.switchTo().window(MotHandle);
			    Thread.sleep(5000);
			    driver.close();
			    driver.quit();
			    driver.quit();
			    System.gc();
		  }catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	      } */
	  //*,dependsOnMethods= { "testTutorSessionJoin" }
	    /*@Test(dataProviderClass=Data_Provider.class,dataProvider="Authentication")
		  public void testStudentJoiningSession(String Username, String Password) throws Exception {
			  try{
				  System.setProperty("webdriver.chrome.driver", "C:\\Documents and Settings\\soumya.rp\\My Documents\\softwares\\chromedriver\\chromedriver.exe");
				     driver = new ChromeDriver();
				    driver.get("http://tltwb.focuseduvation.com/Login.aspx");
				    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				    driver.findElement(By.id("txtUserName")).clear();
				    driver.findElement(By.id("txtUserName")).sendKeys(Username);
				    driver.findElement(By.id("txtPassword")).clear();
				    driver.findElement(By.id("txtPassword")).sendKeys(Password);
				    driver.findElement(By.id("btnLogin")).click();
		    WebDriverWait wait  = new WebDriverWait(driver, 10);
		    Thread.sleep(2000);
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnJoinSession']")));
		    driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnJoinSession']")).click();
		    Thread.sleep(2000);
		    driver.switchTo().frame("iframeNE");
		    Thread.sleep(3000);
		    driver.findElement(By.xpath("//*[@id='messageBox']")).sendKeys("Hello\n");
		    driver.findElement(By.xpath("//*[@id='messageBox']")).sendKeys("My  name is\n");
		    driver.findElement(By.xpath("//*[@id='messageBox']")).sendKeys(Username+"\n");
		    driver.switchTo().defaultContent();
		    Thread.sleep(3000);
		    driver.quit();
		    driver.quit();
		    System.gc();
			  }catch(Exception e)
			  {
				  e.printStackTrace();
			  }
			  
		  }*/
	    //(dependsOnMethods="testTutorSessionJoin")
	  /* @Test(dependsOnMethods="testStudentJoiningSession")
	   public void sleep()
	   {
		   try{
			   //properties.load(new FileInputStream("C:\\Documents and Settings\\soumya.rp\\Selenium\\WhiteBoard\\src\\performance\\Test.properties"));
			   //String time = properties.getProperty("SleepTime");
			   //Integer time1 = Integer.parseInt(time.toString());
			   //Integer Time = time1;
			   long SleepTime = 7200;
			   SimpleDateFormat DF = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			   Date date = new Date();
			   long WaitMins = ((SleepTime/1000)/60);
			   System.out.println("Present date and time is "+DF.format(date)+" waiting for  " + WaitMins +" minutes");
			   Thread.sleep(SleepTime);
			   SimpleDateFormat DF1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			   Date date1 = new Date();
			   System.out.println("Present date and time  after waiking up  "+DF1.format(date1));
			   System.gc();
			   
		   }catch(Exception e)
		   {
			   e.printStackTrace();
		   }
	   }*/
	  //dependsOnMethods={"sleep"}
	   /*@Test(dataProviderClass = Data_Provider.class,dataProvider="TAuthentication",dependsOnMethods={"sleep"})
	   public synchronized void endSession(String TUserName,String TPassword)
	   {
		   try{
			  // for(int i=1;i<=50;i++){
			   
			     System.setProperty("webdriver.chrome.driver", "C:\\Documents and Settings\\soumya.rp\\My Documents\\softwares\\chromedriver\\chromedriver.exe");
			     driver = new ChromeDriver();
				   //driver = new FirefoxDriver();
				    //driver = new SafariDriver();
			    driver.get("http://gt.focuseduvation.com/Login.aspx");
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    driver.findElement(By.id("txt_username")).clear();
			    driver.findElement(By.id("txt_username")).sendKeys(TUserName);
			    driver.findElement(By.id("txt_password")).clear();
			    driver.findElement(By.id("txt_password")).sendKeys(TPassword);
			    driver.findElement(By.id("btn_submit")).click();
			    Thread.sleep(3000);
			    WebDriverWait wait = new WebDriverWait(driver,30);
				//wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_ContentPlaceHolder1_imgbtnGoOnline")));
			    //driver.navigate().to("http://gtwt.focuseduvation.com/Tutor/T_Dashboardnew.aspx");
				if(driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgbtnGoOnline")).isDisplayed()==true)
				{
				driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgbtnGoOnline")).click();
				}
				 //driver.navigate().to("http://gtwt.focuseduvation.com/Tutor/T_Dashboardnew.aspx");
				Set handle = driver.getWindowHandles();
				System.out.println(handle);
				Thread.sleep(2000);
			    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl01_gvTutor_ongoingsessions']/tbody/tr[2]/td[10]/a")));
			    driver.findElement(By.xpath("//*[@id='ctl01_gvTutor_ongoingsessions']/tbody/tr[2]/td[10]/a")).click();
			    System.out.println("Window title after joining the session  : "+driver.getTitle());
			    Thread.sleep(10000);
			    Set handles = driver.getWindowHandles();
			    System.out.println(handle);
			    handles.removeAll(handle);
			    System.out.println(handles);
			    String Present_Handle = (String)handles.iterator().next();
			    String AHandle = Present_Handle;
			    driver.switchTo().window(AHandle);
			    Thread.sleep(5000);
			    driver.switchTo().frame("iframeNE");
			    Thread.sleep(4000);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("divendbtn")));
			    driver.findElement(By.id("divendbtn")).click();
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='messageBox']")));
		        driver.findElement(By.xpath("//*[@id='messageBox']")).sendKeys("Hello I Am Tutor  mike@fev.com \n");
		                            
		        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='btnSessionEnd']")));
			    driver.findElement(By.xpath("//*[@id='btnSessionEnd']")).click();
			    Thread.sleep(1000);
			    driver.findElement(By.id("alertify-ok")).click();
			    driver.switchTo().defaultContent();
			   Thread.sleep(5000);
			   driver.findElement(By.id("txt_Followup")).sendKeys("NA");
			   driver.findElement(By.id("txt_TopicsCovered")).sendKeys("NA");
			   driver.findElement(By.id("txt_StuUnderstanding")).sendKeys("NA");
			   driver.findElement(By.id("txt_TutOpinion")).sendKeys("NA");
			   driver.findElement(By.id("txt_helpneeded")).sendKeys("NA");
			   driver.findElement(By.name("btnSubmitNotes")).click();
			   driver.close();
			   System.out.println("feedback page submitted");
			   String Parent_Handle = (String)handle.iterator().next();
			   String Mother_Handle = Parent_Handle ;
			   driver.switchTo().window(Mother_Handle);
			   System.out.println("I am now searching for EndSession button");
			   driver.navigate().refresh();
			   wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_lnkbtnLogout")));
			    driver.findElement(By.id("ctl00_lnkbtnLogout")).click();
			   Thread.sleep(2000);
			   Alert alert = driver.switchTo().alert();
			   alert.getText();
			    alert.accept();
			    driver.quit();
			    System.out.println("Driver destroyed");
			    driver.quit();
			    System.gc();
		   }catch(Exception e)
		   {
			   e.printStackTrace();		   
		  }
	   }*/
	   /*@Test(dataProviderClass=Data_Provider.class,dataProvider="Authentication",dependsOnMethods= { "endSession" })
	   public void testSessionDuration(String Username,String Password)
	   {
		   try{
			
			   System.setProperty("webdriver.chrome.driver", "C:\\Documents and Settings\\soumya.rp\\My Documents\\softwares\\chromedriver\\chromedriver.exe");
			    driver = new ChromeDriver();
			   //driver = new FirefoxDriver();
			    //driver = new SafariDriver();
			    driver.get("http://tltwb.focuseduvation.com/Login.aspx");
			    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			    driver.findElement(By.id("txtUserName")).clear();
			    driver.findElement(By.id("txtUserName")).sendKeys(Username);
			    driver.findElement(By.id("txtPassword")).clear();
			    driver.findElement(By.id("txtPassword")).sendKeys(Password);
			    driver.findElement(By.id("btnLogin")).click();
			    driver.findElement(By.xpath("//*[@id='smoothmenu1']/ul/li[3]/a")).click();
			    driver.navigate().refresh();
			    WebElement we1 = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_gvPreviousSessions_ctl02_lblDate']"));
			    String DateString = we1.getText();
			    String[] ADate = DateString.split(" ");
			    List<String> LDate = new ArrayList<String>();
			    LDate = Arrays.asList(ADate);
			    String DateValue = LDate.get(0);
			    //System.out.println(DateValue);
			    WebElement we2 = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceHolder1_gvPreviousSessions_ctl02_lblDuration']"));
			    String Stime = we2.getText();
				Integer Time = Integer.parseInt(Stime.replaceAll("[\\D]", ""));
				//System.out.println(Time);
			    //System.out.println("Date is  :"+ DateValue+"  Time is   :"+Time);
				SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
				Date date = new Date();
				String Sdate = format.format(date);
				String SystemDate = Sdate.substring(1);
				char c = SystemDate.charAt(2);
				String stringValueOf = String.valueOf(c);
				 if(stringValueOf.equals("0"))
				 {
				Utility util = new Utility();
				String NewSystemDate = util.removeCharAt(SystemDate, 2);
				if(NewSystemDate.equals(DateValue))
				{
					System.out.println(" Student "+Username+" Has successfully completed a "+ Time+" minutes session in "+NewSystemDate );
				}
				else{
					System.out.println(" Student "+Username+" faced some problem while taking the   session");
				}
				Assert.assertEquals(DateValue, NewSystemDate);
				 }else{
					 if(SystemDate.equals(DateValue)&& Time>0)
						{
							System.out.println(" Student "+Username+" Has successfully completed a "+ Time+" minutes session in "+SystemDate );
						}
						else{
							System.out.println(" Student "+Username+" faced some problem while taking the   session");
						}
						Assert.assertEquals(DateValue, SystemDate);
				 }
				
			    driver.quit();
			   System.gc();
		   }catch(Exception e)
		   {
			   e.printStackTrace();
		   }
	   }*/
	   
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


