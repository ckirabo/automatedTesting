package com.qa.clare.seleniumWebDriverTestAutomationPractise;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
	
	public void selectDressToBasket() throws InterruptedException {
		driver.get(url);
		
		WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		searchBar.click();
		searchBar.sendKeys("dress");
		searchBar.sendKeys(Keys.ENTER);
		
		WebElement dressText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"));
		dressText.click();
		
		WebElement checkOut = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span"));
		checkOut.click();
		
		boolean proceedToCheckOutDisplayed = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"))
				.isDisplayed();
		
		boolean proceedToCheckOutEnables = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"))
				.isEnabled();
		
		if(proceedToCheckOutDisplayed == true &  proceedToCheckOutEnables == true) {
			WebElement proceed = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
			proceed.click();
		}
		
		Thread.sleep(8000);
	}
	
	
	@Test
	@Ignore
	public void checkDress() throws InterruptedException {
        driver.get(url);
		
		WebElement searchBar = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		searchBar.click();
		searchBar.sendKeys("dress");
		searchBar.sendKeys(Keys.ENTER);
		
		WebElement dressText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a"));
		dressText.click();
	
		WebElement selectedDress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1"));
		
		Thread.sleep(8000);
		
		assertEquals("dress not selected","Printed Summer Dress",selectedDress.getText());
		

		
	}
	
	

	
	@After
	public void tearDown() {
		driver.quit();
	}
}
