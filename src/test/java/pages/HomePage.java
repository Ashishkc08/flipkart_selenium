package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;



public class HomePage extends BasePage {
	private By searchBox = By.name("q");
    //private By searchButton = By.xpath("//button[@class='_2iLD__']");
    private By loginLink = By.xpath("//span[.='Login']");
    private By groceryLink = By.xpath("//img[@alt='Grocery']");
    private By cartIcon = By.xpath("//img[@src='https://static-assets-web.flixcart.com/batman-returns/batman-returns/p/images/header_cart-eed150.svg']");
    private By flipkartLogo = By.xpath("//img[@title='Flipkart']");
    //public static Logger log;
    
    public HomePage(WebDriver driver) {
        super(driver);
        //log = LogManager.getLogger(HomePage.class);
    }

    public void search(String keyword) {
    	//log= LogManager.getLogger(HomePage.class);
    	driver.findElement(searchBox).sendKeys(keyword + Keys.ENTER);
    	log.info("Performed search for keyword: {}", keyword);
    }
    
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
        log.info("Clicked on the Login link");
    }
    
    public void clickGroceryLink() throws InterruptedException {
    	Thread.sleep(3000);
        driver.findElement(groceryLink).click();
        log.info("Clicked on the Grocery link");
    }
    
    public boolean isCartIconPresent() {
        WebElement cartElement = driver.findElement(cartIcon);
        boolean isPresent = cartElement.isDisplayed();
        log.info("Cart icon present: " + isPresent);
        return isPresent;
    }

    public boolean isFlipkartLogoPresent() {
        WebElement logoElement = driver.findElement(flipkartLogo);
        boolean isPresent = logoElement.isDisplayed();
        log.info("Flipkart logo present: " + isPresent);
        return isPresent;
    }
}
