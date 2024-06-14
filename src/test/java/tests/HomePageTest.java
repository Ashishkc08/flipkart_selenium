package tests;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends BaseTest {

    @Test( enabled = true, priority = 1, groups = {"home"})
    public void verifyHomePageTitle() {
    	
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
//        log.info("Actual Title: " + actualTitle);
//        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");
    	createTest("verifyHomePageTitle");
        try {
            String actualTitle = driver.getTitle();
            String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
            log.info("Actual Title: " + actualTitle);
            Assert.assertEquals(actualTitle, expectedTitle, "Home Page title does not match");
            test.log(Status.PASS, "Home Page title matches: " + actualTitle);
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
           
            throw e;
        }
    }
    
    @Test(enabled = true, priority = 2, groups = {"home"})
    public void verifyGroceryNavigation() throws InterruptedException {
//        homePage.clickGroceryLink();
//        String actualGroceryTitle = driver.getTitle();
//        String expectedGroceryTitle = "Flipkart Grocery Store - Buy Groceries Online & Get Rs.1 Deals at Flipkart.com";
//        log.info("Actual Grocery Page Title: " + actualGroceryTitle);
//        Assert.assertEquals(actualGroceryTitle, expectedGroceryTitle, "Grocery page title does not match!");
    	createTest("verifyGroceryNavigation");
        try {
            homePage.clickGroceryLink();
            test.log(Status.INFO, "Clicked on Grocery Link");
            
            String actualGroceryTitle = driver.getTitle();
            String expectedGroceryTitle = "Flipkart Grocery Store - Buy Groceries Online & Get Rs.1 Deals at Flipkart.com";
            log.info("Actual Grocery Page Title: " + actualGroceryTitle);
            Assert.assertEquals(actualGroceryTitle, expectedGroceryTitle, "Grocery page title does not match");
            test.log(Status.PASS, "Grocery page title matches: " + actualGroceryTitle);
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
            
            throw e;
        }
    }
    
    @Test(dataProvider = "searchData",enabled = true, priority = 3, groups = {"home"})
    public void testSearchFunctionality(String testID, String testName, String executionRequired, String keyword, String expectedTitle) {
        //String keyword = "laptop";
        //homePage.search(keyword);       
        //String expectedTitle = keyword + "- Buy Products Online at Best Price in India - All Categories | Flipkart.com";      
        //Assert.assertEquals(driver.getTitle(), StringUtils.capitalize(expectedTitle));
    	 //createTest("testSearchFunctionality");
    	 createTest(testName);
         try {
             //String keyword = "laptop";
             homePage.search(keyword);
             test.log(Status.INFO, "Searched for keyword: " + keyword);
             
             //String expectedTitle = keyword + "- Buy Products Online at Best Price in India - All Categories | Flipkart.com";
             String actualTitle = driver.getTitle();
             //Assert.assertEquals(actualTitle, StringUtils.capitalize(expectedTitle), "Search functionality title does not match");
             Assert.assertEquals(actualTitle, expectedTitle);
             test.log(Status.PASS, "Search functionality title matches: " + actualTitle);
         } catch (AssertionError e) {
             test.log(Status.FAIL, e.getMessage());
             
             throw e;
         }
    }
    
    @Test(enabled = true, priority = 4, groups = {"home"})
    public void testGoToLoginPage() {
    	//homePage.clickLoginLink();
        //Assert.assertEquals(loginPage.getLoginText(), "Login");
    	createTest("testGoToLoginPage");
        try {
            homePage.clickLoginLink();
            test.log(Status.INFO, "Clicked on Login Link");
            
            String actualLoginText = loginPage.getLoginText();
            Assert.assertEquals(actualLoginText, "Login", "Login text does not match");
            test.log(Status.PASS, "Login text matches: " + actualLoginText);
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
            
            throw e;
        }
    }
    
    @Test(enabled = true, priority = 5, groups = {"home"})
    public void verifyCartIconPresence() {
        //boolean isCartIconPresent = homePage.isCartIconPresent();
        //log.info("Is Cart Icon Present: " + isCartIconPresent);
        //Assert.assertTrue(isCartIconPresent, "Cart icon is not present on the homepage.");
    	createTest("verifyCartIconPresence");
        try {
            boolean isCartIconPresent = homePage.isCartIconPresent();
            log.info("Is Cart Icon Present: " + isCartIconPresent);
            Assert.assertTrue(isCartIconPresent, "Cart icon is not present on the homepage");
            test.log(Status.PASS, "Cart icon is present on the homepage");
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
            
            throw e;
        }
    }

    @Test(enabled = true, priority = 6, groups = {"home"})
    public void verifyFlipkartLogoPresence() {
        //boolean isFlipkartLogoPresent = homePage.isFlipkartLogoPresent();
        //log.info("Is Flipkart Logo Present: " + isFlipkartLogoPresent);
        //Assert.assertTrue(isFlipkartLogoPresent, "Flipkart logo is not present on the homepage.");
    	createTest("verifyFlipkartLogoPresence");
        try {
            boolean isFlipkartLogoPresent = homePage.isFlipkartLogoPresent();
            log.info("Is Flipkart Logo Present: " + isFlipkartLogoPresent);
            Assert.assertTrue(isFlipkartLogoPresent, "Flipkart logo is not present on the homepage");
            test.log(Status.PASS, "Flipkart logo is present on the homepage");
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
           
            throw e;
        }
    }
    
   
}
