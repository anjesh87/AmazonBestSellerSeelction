package com.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Page{

	public BasePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);		
	}

	//generic utility wrappers

	public void doClick(By locator) {
		driver.findElement(locator);
	}

	public void doSendKeys(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

	public void doSendKeybordKeys(By locator, Keys keys) {
		driver.findElement(locator).sendKeys(keys);
	}

}
