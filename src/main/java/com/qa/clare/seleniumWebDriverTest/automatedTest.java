package com.qa.clare.seleniumWebDriverTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class automatedTest {

	WebDriver driver;

	String googleURL = "https://www.google.co.uk";
	
	@Before
	public void startUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Admin\\Downloads/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void methodTestEnter() {
		driver.get(googleURL);
		WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input"));
		checkElement.sendKeys("Potatoes");
		checkElement.sendKeys(Keys.ENTER);
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
}
