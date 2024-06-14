package pages;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {
	
	private By priceText = By.xpath("(//span[@class='LAlF6k re6bBo'])[1]");
	
	private By qtyAddBtn = By.xpath("//button[contains(.,'+')]");
	private By removeLink = By.xpath("//div[contains(text(),'Remove')]");
	private By removeBtn = By.xpath("//div[@class='sBxzFz fF30ZI A0MXnh']");
	private By qtyTextBox = By.xpath("//input[@class='p6sArZ']");
	private By emptyCartTextElement = By.xpath("//div[.='Missing Cart items?']");
    
    public CartPage(WebDriver driver) {
        super(driver);
        
    }
    public int getPrice() {
        try {
        	log.info("Attempting to find the price element.");
            WebElement priceElement = driver.findElement(priceText);
            String priceText = priceElement.getText();
            log.info("Price text found: {}", priceText);
            String priceValue = priceText.replaceAll("[^\\d]", ""); 
            log.info("Parsed price value: {}", priceValue);
            System.out.println(priceValue);// Remove non-numeric characters
            return Integer.parseInt(priceValue);
        } catch (Exception e) {
            log.error("Price element not found or could not parse the price. Returning 0.");
            return 0;
        }
    }
    public void increaseQuantity() {
        try {
            log.info("Attempting to increase the quantity.");
            WebElement addButton = driver.findElement(qtyAddBtn);
           
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)");

            // Explicit wait for the element to be clickable
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            //wait.until(ExpectedConditions.elementToBeClickable(addButton));

            
            Actions actions = new Actions(driver);
    		actions.moveToElement(addButton).click().build().perform();
    	
            log.info("Quantity increased by 1.");
        } catch (Exception e) {
            log.error("Failed to increase the quantity.", e);
        }
        
        
    }
    public void clickRemoveLink() {
        try {
            log.info("Attempting to click remove link.");
            WebElement removeLinkElement = driver.findElement(removeLink);
           
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)");

            // Explicit wait for the element to be clickable
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            //wait.until(ExpectedConditions.elementToBeClickable(addButton));

            
            Actions actions = new Actions(driver);
    		actions.moveToElement(removeLinkElement).click().build().perform();
    	
            log.info("Remove link clicked.");
        } catch (Exception e) {
            log.error("Failed to click the remove link.", e);
        }
    }
    
    public void clickRemoveBtn() {
    	log.info("Attempting to click remove button.");
    	WebElement removeBtnElement = driver.findElement(removeBtn);
    	removeBtnElement.click();
    }

    public int getQuantity() {
        try {
            log.info("Attempting to find the quantity text box.");
            WebElement qtyElement = driver.findElement(qtyTextBox);
            String qtyText = qtyElement.getAttribute("value");
            log.info("Quantity text found: {}", qtyText);
            return Integer.parseInt(qtyText);
        } catch (Exception e) {
            log.error("Quantity text box not found or could not parse the quantity. Returning 0.", e);
            return 0;
        }
    }
    
    public String getEmptyCartText() {
        String emptyCartText = driver.findElement(emptyCartTextElement).getText();
        log.info("Empty Cart text retrieved: {}", emptyCartText);
        return emptyCartText;
    }
    
}
