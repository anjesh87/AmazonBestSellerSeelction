package com.fromAtoB;


import com.test.pages.HomePage;
import com.test.pages.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PinionTest {

     WebDriver driver;
     WebDriverWait wait;
     public Page page;


    @Test(priority = 1)
    public void verifyHomePageTitle() {

        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", projectPath+"//drivers/gecodriver/geckodriver");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 50);
        driver.get("http://www.fromatob.com");
        //create object of page class
        page = new Page(driver, wait);
        String pageTitle = page.getPageInstance(HomePage.class).getTitle();
        System.out.println("Home Page title is : " +pageTitle);
        Assert.assertEquals(pageTitle, "Train Tickets for Germany including € 19 Specials, Bus, Flight and Carpool in one Search | fromAtoB.com");
        wait = new WebDriverWait(driver, 50);
        driver.findElement(By.xpath("//a[@class='navbar__menu-link navbar__menu-link--login js-navbar-link']")).click();
        driver.findElement(By.xpath("//input[@name='user-reception-email']")).sendKeys("abcd@gmail.com");
        driver.findElement((By.xpath("//input[@name='user-reception-password']"))).sendKeys("1234");
        driver.findElement(By.xpath("//button[@class='modal-buttons__button modal-buttons__button--sign']")).click();
    }
}
