package tests;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class CartPageTest extends BaseTest{

	
	@Test(dataProvider = "addToCartData", enabled = true, priority = 1, groups = {"cart"})
    public void verifyProductAddedToCart(String testID, String testName, String executionRequired, String keyword) throws InterruptedException {
		//createTest("verifyProductAddedToCart");
		createTest(testName);
		//homePage.search("iphone 15 plus");
		homePage.search(keyword);
		test.log(Status.INFO, "Searched for " + keyword);
		productPage.clickProduct();
		test.log(Status.INFO, "Clicked on the product");
		productPage.clickAddToCart();
		test.log(Status.INFO, "Clicked on 'Add to Cart'");
		Thread.sleep(2000);
        //Verify product price is greater than 0
        int totalPrice = cartPage.getPrice();
        try {
            Assert.assertTrue(totalPrice > 0, "Product price should be greater than 0.");
            test.log(Status.PASS, "Product added to cart successfully with price: " + totalPrice);
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Product price should be greater than 0.");
            test.log(Status.FAIL, e.getMessage());
            throw e;
        }
    }
	
	@Test(enabled = true, priority = 2, groups = {"cart"})
    public void verifyIncreaseQuantity() throws InterruptedException {
		createTest("verifyIncreaseQuantity");
		homePage.search("iphone 15 plus");
		productPage.clickProduct();
		productPage.clickAddToCart();
		
		Thread.sleep(2000);
        //Verify product price is greater than 0
        //int totalPrice = cartPage.getPrice();
        //Assert.assertTrue(totalPrice > 0, "Product price should be greater than 0.");
		cartPage.increaseQuantity();
		Thread.sleep(2000);
		 try {
	            Assert.assertTrue(cartPage.getQuantity() > 1, "Product quantity should be greater than 1.");
	            test.log(Status.PASS, "Product quantity increased successfully.");
	        } catch (AssertionError e) {
	            test.log(Status.FAIL, "Product quantity should be greater than 1.");
	            test.log(Status.FAIL, e.getMessage());
	            
	            throw e;
	        }
    }
	
	@Test(enabled = true, priority = 3, groups = {"cart"})
    public void verifyRemoveProduct() throws InterruptedException {
		createTest("verifyRemoveProduct");
		homePage.search("iphone 15 plus");
		productPage.clickProduct();
		productPage.clickAddToCart();
		
		Thread.sleep(2000);
        //Verify product price is greater than 0
        //int totalPrice = cartPage.getPrice();
        //Assert.assertTrue(totalPrice > 0, "Product price should be greater than 0.");
		cartPage.clickRemoveLink();
		cartPage.clickRemoveBtn();
		Thread.sleep(2000);
		//Assert.assertEquals("Missing Cart items?", cartPage.getEmptyCartText(), "Empty Cart Text Not Match");
		try {
            Assert.assertEquals(cartPage.getEmptyCartText(), "Missing Cart items?", "Empty Cart Text does not match");
            test.log(Status.PASS, "Product removed from cart successfully.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Empty Cart Text does not match.");
            test.log(Status.FAIL, e.getMessage());
            throw e;
        }
    }

}
