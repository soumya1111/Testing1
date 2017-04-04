package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {
	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\soumya.rp\\Desktop\\Chromedriver\\chromedriver.exe");
   WebDriver  driver = new ChromeDriver();
    driver.get("http://192.168.122.124/FEVRevAmp/Student/Student");
	}
}
