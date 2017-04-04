package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import paths.StudentPath;

public class ODTest {
	
    @Test
    public void loginOD(){ 
    WebDriver driver = new FirefoxDriver();
    //driver = new SafariDriver();
    driver.get("http://192.168.122.124/FEVRevAmp/");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    driver.findElement(By.id(StudentPath.UnameID)).clear();
    driver.findElement(By.id(StudentPath.UnameID)).sendKeys("teststudent10");
    //driver.findElement(By.id(StudentPath.UnameID)).sendKeys("teststudent10");
    driver.findElement(By.id(StudentPath.PasswordID)).clear();
    driver.findElement(By.id(StudentPath.PasswordID)).sendKeys("123");
    //driver.findElement(By.id(StudentPath.PasswordID)).sendKeys("123");
    driver.findElement(By.xpath(StudentPath.LoginXpath)).click();
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(StudentPath.RequestODXpath)));
    driver.findElement(By.xpath(StudentPath.RequestODXpath)).click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(StudentPath.SubjectID)));
    new Select(driver.findElement(By.id(StudentPath.SubjectID))).selectByVisibleText("Math");
    //Thread.sleep(500);
    new Select(driver.findElement(By.id(StudentPath.CourseID))).selectByVisibleText("Trignometry");
    driver.findElement(By.xpath(StudentPath.QuestionXpath)).sendKeys("Testing don't pick :");
   // driver.findElement(By.id(StudentPath.InitiateODID)).click();
    }
}
