package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FooterPage;

public class FooterLinkTest extends BaseTest {


    @Test(enabled = true, priority = 1, groups = {"footer"})
    public void verifyAboutUsLinkPresence() {
        //Assert.assertTrue(footerPage.isAboutUsLinkPresent(), "About Us link is not present in the footer.");
    	createTest("verifyAboutUsLinkPresence");
        try {
            Assert.assertTrue(footerPage.isAboutUsLinkPresent(), "About Us link is not present in the footer.");
            test.log(Status.PASS, "About Us link is present in the footer.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
            
            throw e;
        }
    }

    @Test(enabled = true, priority = 2, groups = {"footer"})
    public void verifyContactUsLinkPresence() {
        //Assert.assertTrue(footerPage.isContactUsLinkPresent(), "Contact Us link is not present in the footer.");
    	createTest("verifyContactUsLinkPresence");
        try {
            Assert.assertTrue(footerPage.isContactUsLinkPresent(), "Contact Us link is not present in the footer.");
            test.log(Status.PASS, "Contact Us link is present in the footer.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
            
            throw e;
        }
    }

    @Test(enabled = true, priority = 3, groups = {"footer"})
    public void verifyCareersLinkPresence() {
        //Assert.assertTrue(footerPage.isCareersLinkPresent(), "Careers link is not present in the footer.");
    	createTest("verifyCareersLinkPresence");
        try {
            Assert.assertTrue(footerPage.isCareersLinkPresent(), "Careers link is not present in the footer.");
            test.log(Status.PASS, "Careers link is present in the footer.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
            
            throw e;
        }
    }

    @Test(enabled = true, priority = 4, groups = {"footer"})
    public void verifyPrivacyPolicyLinkPresence() {
        //Assert.assertTrue(footerPage.isPrivacyPolicyLinkPresent(), "Privacy Policy link is not present in the footer.");
    	createTest("verifyPrivacyPolicyLinkPresence");
        try {
            Assert.assertTrue(footerPage.isPrivacyPolicyLinkPresent(), "Privacy Policy link is not present in the footer.");
            test.log(Status.PASS, "Privacy Policy link is present in the footer.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
            
            throw e;
        }
    }

    @Test(enabled = true, priority = 5, groups = {"footer"})
    public void verifyMyntraLinkPresence() {
        //Assert.assertTrue(footerPage.isMyntraLinkPresent(), "Myntra link is not present in the footer.");
    	createTest("verifyReturnPolicyLinkPresence");
        try {
            Assert.assertTrue(footerPage.isMyntraLinkPresent(), "Myntra link is not present in the footer.");
            test.log(Status.PASS, "Myntra link is present in the footer.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
           
            throw e;
        }
    }

    @Test(enabled = true, priority = 6, groups = {"footer"})
    public void verifyNavigationToAboutUsPage() {
        //footerPage.clickAboutUsLink();
        //Assert.assertEquals(driver.getTitle(),"Flipkart Corporate Website", "Failed to navigate to About Us page.");
    	createTest("verifyNavigationToAboutUsPage");
        try {
            footerPage.clickAboutUsLink();
            Assert.assertEquals(driver.getTitle(), "Flipkart Corporate Website", "Failed to navigate to About Us page.");
            test.log(Status.PASS, "Navigated to About Us page successfully.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
            
            throw e;
        }
    }

    @Test(enabled = true, priority = 7, groups = {"footer"})
    public void verifyNavigationToContactUsPage() {
        //footerPage.clickContactUsLink();
        //Assert.assertTrue(footerPage.verifyContactUsNavigation(), "Failed to navigate to Contact Us page.");
    	createTest("verifyNavigationToContactUsPage");
        try {
            footerPage.clickContactUsLink();
            Assert.assertTrue(footerPage.verifyContactUsNavigation(), "Failed to navigate to Contact Us page.");
            test.log(Status.PASS, "Navigated to Contact Us page successfully.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
            
            throw e;
        }
    }

//    @Test(enabled = true, priority = 8, groups = {"footer"})
//    public void verifyNavigationToCareersPage() throws InterruptedException {
//        //footerPage.clickCareersLink();
//        //Assert.assertTrue(driver.getTitle().contains("Careers"), "Failed to navigate to Careers page.");
//    	createTest("verifyNavigationToCareersPage");
//        try {
//            footerPage.clickCareersLink();
//            Assert.assertTrue(driver.getTitle().contains("Careers"), "Failed to navigate to Careers page.");
//            test.log(Status.PASS, "Navigated to Careers page successfully.");
//        } catch (AssertionError e) {
//            test.log(Status.FAIL, e.getMessage());
//            
//            throw e;
//        }
//    }

    @Test(enabled = true, priority = 9, groups = {"footer"})
    public void verifyNavigationToPrivacyPolicyPage() {
        //footerPage.clickPrivacyPolicyLink();
        //Assert.assertTrue(driver.getTitle().contains("Privacypolicy"), "Failed to navigate to Privacy Policy page.");
    	createTest("verifyNavigationToPrivacyPolicyPage");
        try {
            footerPage.clickPrivacyPolicyLink();
            Assert.assertTrue(driver.getTitle().contains("Privacypolicy"), "Failed to navigate to Privacy Policy page.");
            test.log(Status.PASS, "Navigated to Privacy Policy page successfully.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
            
            throw e;
        }
    }

    @Test(enabled = true, priority = 10, groups = {"footer"})
    public void verifyNavigationToMyntraPage() {
        //footerPage.clickMyntraLink();
        //Assert.assertEquals(driver.getTitle(), "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra", "Failed to navigate to Return Policy page.");
    	createTest("verifyNavigationToMyntraPage");
        try {
            footerPage.clickMyntraLink();
            Assert.assertEquals(driver.getTitle(), "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra", "Failed to navigate to Return Policy page.");
            test.log(Status.PASS, "Navigated to Return Policy page successfully.");
        } catch (AssertionError e) {
            test.log(Status.FAIL, e.getMessage());
            
            throw e;
        }
    }

}
