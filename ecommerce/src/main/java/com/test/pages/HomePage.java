package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	// page locators
	By searchTextBox = By.id("twotabsearchtextbox");
	By keysToSend = By.id("twotabsearchtextbox");

	// page actions
	public String getTitle() {
		return driver.getTitle();
	}

	public void doSearch(String searchTexts) {
		doSendKeys(searchTextBox, searchTexts);
	}

	public void doKeyEnter() {
		doSendKeybordKeys(keysToSend,Keys.ENTER);

	}

}
