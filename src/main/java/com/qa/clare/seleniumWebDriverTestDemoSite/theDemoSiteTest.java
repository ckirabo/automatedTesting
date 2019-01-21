package com.qa.clare.seleniumWebDriverTestDemoSite;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class theDemoSiteTest {

	
	WebDriver driver;
	String theDemoSiteURL = "https://www.thedemosite.co.uk"; 
	String username = "urTopLip" ;
	String password = "Looooool";
	
	@Before
    public void startUp() {
    	System.setProperty("webdriver.chrome.driver",
    			"C:\\\\Users\\\\Admin\\\\Downloads/chromedriver_win32/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    }
	
	@Test
	public void methodLogin() throws InterruptedException {
		driver.get(theDemoSiteURL);
		WebElement addUser = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"));
		addUser.click();
		
		WebElement usernameInput = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		usernameInput.click();
		usernameInput.sendKeys(username);
		
		WebElement passwordInput = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		passwordInput.click();
		passwordInput.sendKeys(password);
		
		WebElement saveButton = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
		saveButton.click();
		
		WebElement logIn = driver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]"));
		logIn.click();
		
		WebElement loginUserName = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		loginUserName.clear();
		loginUserName.sendKeys(username);
		
		
		WebElement loginPassWord = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		loginPassWord.clear();
		loginPassWord.sendKeys(password);
		
		WebElement testLoginButton = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		testLoginButton.click();
		
		WebElement loginStatus = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
		
		assertEquals("Login Failed", "**Successful Login**" , loginStatus.getText());
		
		Thread.sleep(8000);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
