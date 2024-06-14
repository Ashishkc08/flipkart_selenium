package pages;

//import java.time.Duration;
import java.util.Set;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {
	private By productLink = By.xpath("//div[contains(text(),'Apple iPhone 15 Plus (Green, 128 GB)')]");
	private By addToCartButton = By.xpath("//button[contains(normalize-space(),'Add to cart')]");
	private By productPageText = By.xpath("//span[.='Apple iPhone 15 Plus (Green, 128 GB)']");
	//private By goToCartLink = By.xpath("//span[text()='Cart']");
	//public static Logger log;
	//private WebDriverWait wait;
	public ProductPage(WebDriver driver) {
		super(driver);
		//log = LogManager.getLogger(ProductPage.class);
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// TODO Auto-generated constructor stub
	}
	
	public void clickProduct() {
        driver.findElement(productLink).click();
        log.info("Clicked on the product link");
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
		
	    }
        }
        
        
    
	
	public String getProductText() {
        String productText = driver.findElement(productPageText).getText();
        log.info("Product text retrieved: {}", productText);
        return productText;
    }
	
	public void clickAddToCart() throws InterruptedException {
		WebElement element = driver.findElement(addToCartButton);
	    //element.click();
	    //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)); 
	    //((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	}
	}

