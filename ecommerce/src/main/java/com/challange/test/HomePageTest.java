package com.challange.test;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.test.pages.HomePage;

public class HomePageTest extends BaseTest{

	static boolean success = true;

	@Test(priority = 1)
	public void verifyHomePageTitle() {
		String pageTitle = page.getPageInstance(HomePage.class).getTitle();
		System.out.println("Home Page title is : " +pageTitle);
		Assert.assertEquals(pageTitle, "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");
	}

	@Test(priority = 2)
	public void addBestSellerHeadphonesToCart() {

		// search Headphones in search box
		
		page.getPageInstance(HomePage.class).doSearch("Headphones");
		page.getPageInstance(HomePage.class).doKeyEnter();

		// TODO need to replaced with explicit wait
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Get all the headphones with Badge Type "Best Sellers"
		List<WebElement> bestSellers = driver.findElements(
				By.xpath("//span[text()='Best Seller']" +
						"/ancestor::div[@data-asin and not(.//span[.='Sponsored'])][1]" +
						"//span[@data-component-type='s-product-image']//a"));

		// Keep all the best sellers head phone in List to add into cart	
		List<String> bestSellersHrefs = bestSellers.stream()
				.map(element -> element.getAttribute("href")).collect(Collectors.toList());

		// Iterate through List	
		bestSellersHrefs.forEach(href -> {
			driver.get(href);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-button"))).click();
			success = wait.until(ExpectedConditions.or(
					ExpectedConditions.visibilityOfElementLocated(By.className("success-message")),
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='attachDisplayAddBaseAlert']//h4[normalize-space(.)='Added to Cart']")),
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space(.)='Added to Cart']"))
					));
		});

	}

}
