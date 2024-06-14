package tests;

import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CartPage;
import pages.FooterPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utils.ConfigurationManager;
import utils.ExcelUtil;
import utils.WebDriverFactory;
import utils.captureScreenshot;


public class BaseTest {
	protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected ProductPage productPage;
    protected CartPage cartPage;
    protected FooterPage footerPage;
    //protected String baseUrl = "https://www.flipkart.com/";
    protected static final Logger log = LogManager.getLogger(BaseTest.class);
    protected static ExtentReports extent;
    protected static ExtentTest test;
    protected String baseUrl;

    @BeforeSuite
    public void setUpSuite() {
    	ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("extent-reports/report.html");
       

        extent = new ExtentReports();
        extent.attachReporter(extentSparkReporter);
    }
    @BeforeMethod
    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get(baseUrl);
//        driver.manage().window().maximize();
//        initializePages();
    	
    	baseUrl = ConfigurationManager.getProperty("application.url");
    	driver = WebDriverFactory.getWebDriver(ConfigurationManager.getProperty("browser.name"),ConfigurationManager.getProperty("headless.mode"));

        // Maximize browser window
        driver.manage().window().maximize();

        // Navigate to base URL
        driver.get(baseUrl);

        // Initialize other pages
        initializePages();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = captureScreenshot.captureScreenshot(driver, result.getName());
            test.log(Status.FAIL, "Test Failed. Screenshot captured: " + test.addScreenCaptureFromPath(screenshotPath));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            String screenshotPath = captureScreenshot.captureScreenshot(driver, result.getName());
            test.log(Status.PASS, "Test Passed. Screenshot captured: " + test.addScreenCaptureFromPath(screenshotPath));
        }

        if (driver != null) {
            driver.quit();
        }
    }
    
    @AfterSuite
    public void tearDownSuite() {
        extent.flush();
    }

    private void initializePages() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        footerPage = new FooterPage(driver);
    }
    
    protected void createTest(String testName) {
        test = extent.createTest(testName);
    }
    @DataProvider(name = "searchData")
    public Iterator<Object[]> searchData() {
        List<Object[]> testData = ExcelUtil.getTestData("TestingData.xlsx", "Sheet1");
        return testData.iterator();
    }
    @DataProvider(name = "loginData")
    public Iterator<Object[]> loginData() {
        List<Object[]> testData = ExcelUtil.getTestData("TestingData.xlsx", "Sheet2");
        return testData.iterator();
    }
    @DataProvider(name = "addToCartData")
    public Iterator<Object[]> addToCartData() {
        List<Object[]> testData = ExcelUtil.getTestData("TestingData.xlsx", "Sheet3");
        return testData.iterator();
    }
   
}
