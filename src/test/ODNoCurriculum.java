package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import paths.StudentPath;

public class ODNoCurriculum {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\soumya.rp\\Desktop\\Chromedriver\\chromedriver.exe");
   WebDriver  driver = new ChromeDriver();
    //driver = new FirefoxDriver();
    //driver = new SafariDriver();
    driver.get("http://192.168.122.124/FEVRevAmp/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    driver.findElement(By.id(StudentPath.UnameID)).clear();
    driver.findElement(By.id(StudentPath.UnameID)).sendKeys("Soumya1");
    //driver.findElement(By.id(StudentPath.UnameID)).sendKeys("teststudent10");
    driver.findElement(By.id(StudentPath.PasswordID)).clear();
    driver.findElement(By.id(StudentPath.PasswordID)).sendKeys("123");
    driver.findElement(By.xpath(StudentPath.LoginXpath)).click();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    Thread.sleep(3000);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(StudentPath.RequestODXpath)));
    driver.findElement(By.xpath(StudentPath.RequestODXpath)).click();
   // new Select(driver.findElement(By.xpath(StudentPath.GradeXpath))).selectByVisibleText("First");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(StudentPath.SubjectWCID)));
    new Select(driver.findElement(By.id(StudentPath.SubjectWCID))).selectByVisibleText("Math11");
    Thread.sleep(500);
    new Select(driver.findElement(By.id(StudentPath.CourseWCID))).selectByVisibleText("Algebra");
    driver.findElement(By.xpath(StudentPath.QuestionWCXpath)).sendKeys("Testing don't pick ");
    //driver.findElement(By.id(StudentPath.InitiateODID)).click();
    Thread.sleep(5000);
    driver.findElement(By.xpath(StudentPath.LogOffXpath)).click();
    Alert alert = driver.switchTo().alert();
    alert.getText();
    alert.accept();

    driver.close();
    driver.quit();
    System.gc();


}
}
