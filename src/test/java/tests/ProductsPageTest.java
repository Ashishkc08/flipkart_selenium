package tests;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;


public class ProductsPageTest extends BaseTest {
	

	
	@Test(enabled = true, priority = 1, groups = {"addToCart"})
    public void testAddToCart() throws InterruptedException {
		
//		homePage.search("iphone 15 plus");
//		productPage.clickProduct();
//		productPage.clickAddToCart();
//		Thread.sleep(2000);
//		Assert.assertEquals(driver.getTitle(),"Shopping Cart | Flipkart.com");
		createTest("testAddToCart");
        try {
            homePage.search("iphone 15 plus");
            test.log(Status.INFO, "Performed search for 'iphone 15 plus'");
            
            productPage.clickProduct();
            test.log(Status.INFO, "Clicked on a product");
            
            productPage.clickAddToCart();
            test.log(Status.INFO, "Clicked on Add to Cart button");
            
            Thread.sleep(2000);
            Assert.assertEquals(driver.getTitle(), "Shopping Cart | Flipkart.com");
            test.log(Status.PASS, "Successfully navigated to Shopping Cart page");
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
            
            throw e;
        }
    }
	
	
	
}
