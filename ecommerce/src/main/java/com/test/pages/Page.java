package com.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

	public WebDriver driver;
	public WebDriverWait wait;

	// page class constructor

	public Page(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	public <EPage extends BasePage> EPage getPageInstance(Class<EPage> pageClass) {

		try {
			return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver, this.wait);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
