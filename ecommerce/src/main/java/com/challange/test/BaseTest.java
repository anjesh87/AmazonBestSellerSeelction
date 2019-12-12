package com.challange.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.test.pages.Page;

public class BaseTest {

	public WebDriver driver;
	public WebDriverWait wait;
	public Page page;


	@BeforeClass
	public void setUp() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", projectPath+"//drivers/gecodriver/geckodriver");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 50);
		//	driver.manage().window().fullscreen();	
		driver.get("https://www.amazon.com");
		//create object of page class	
		page = new Page(driver, wait);
	}

	@AfterClass
	public void tearDown() {
		driver.close();
		//driver.quit();
	}

}
