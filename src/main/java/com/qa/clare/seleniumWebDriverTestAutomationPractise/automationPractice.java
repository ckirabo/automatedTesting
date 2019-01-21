package com.qa.clare.seleniumWebDriverTestAutomationPractise;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class automationPractice {

	WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	
	
	@Before
	public void startUp() {
		System.setProperty("webdriver.chrome.driver",
    			"C:\\\\Users\\\\Admin\\\\Downloads/chromedriver_win32/chromedriver.exe");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
		
	}
	
	@Test
	public void selectDress() throws InterruptedException {
		driver.get(url);
		
		WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		searchBar.click();
		searchBar.sendKeys("dress");
		searchBar.sendKeys(Keys.ENTER);
		
		WebElement dressText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"));
		dressText.click();
		
		WebElement checkOut = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
		checkOut.click();
		
		/*
		WebElement continueShopping = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"));
		continueShopping.click();
		
		*/
		Thread.sleep(8000);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
}
