package tests;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	
	

    
    @Test(dataProvider = "loginData", enabled = true, priority = 1, groups = {"login"})
    public void testEnterEmail(String TestID, String TestName,String ExecutionRequired, String Email, String ExpectedResult
) {
//        String email = "example@test.com";
//        homePage.clickLoginLink();
//        loginPage.enterEmail(email);
//        Assert.assertEquals(loginPage.getEmailInputText(), email);
    	createTest(TestName);
        try {
            //String email = "example@test.com";
            homePage.clickLoginLink();
            test.log(Status.INFO, "Clicked on Login Link");
            
            loginPage.enterEmail(Email);
            test.log(Status.INFO, "Entered email: " + Email);
            
            String actualEmail = loginPage.getEmailInputText();
            Assert.assertEquals(actualEmail, Email, "Entered email does not match");
            test.log(Status.PASS, "Email input matches: " + actualEmail);
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
            
            throw e;
        }
    }
    
    @Test(enabled = true, priority = 2, groups = {"login"})
    public void testGoToSignupPage() {
//        homePage.clickLoginLink();
//    	loginPage.clickSignupLink();
//        Assert.assertEquals(loginPage.getSignupText(), "Looks like you're new here!");
    	createTest("testGoToSignupPage");
        try {
            homePage.clickLoginLink();
            test.log(Status.INFO, "Clicked on Login Link");
            
            loginPage.clickSignupLink();
            test.log(Status.INFO, "Clicked on Signup Link");
            
            String actualSignupText = loginPage.getSignupText();
            Assert.assertEquals(actualSignupText, "Looks like you're new here!", "Signup text does not match");
            test.log(Status.PASS, "Signup text matches: " + actualSignupText);
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
            
            throw e;
        }
    }
    
   
}
