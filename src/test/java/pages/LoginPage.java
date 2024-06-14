package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	
	private By loginTextElement = By.xpath("//span[contains(text(),'Login')]");
	private By emailInputElement = By.cssSelector("input[class='r4vIwl BV+Dqf']");
	private By emailInputTextElement = By.cssSelector("input[class='r4vIwl _5BVqVB BV+Dqf']");
	private By signupElement = By.xpath("//a[.='New to Flipkart? Create an account']");
	private By signupVerifyElement = By.xpath("//span[contains(text(),\"Looks like you're new here!\")]");
	//public static Logger log;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		//log = LogManager.getLogger(LoginPage.class);
		// TODO Auto-generated constructor stub
	}
	
	public String getLoginText() {
        String loginText = driver.findElement(loginTextElement).getText();
        log.info("Login text retrieved: {}", loginText);
        return loginText;
    }
	
	public void enterEmail(String email) {
        driver.findElement(emailInputElement).sendKeys(email);
        log.info("Entered email: {}", email);
    }
	
	public String getEmailInputText() {
		String emailInputText = driver.findElement(emailInputTextElement).getAttribute("value");
		log.info("Email input text retrieved: {}", emailInputText);
		return emailInputText;
	}
	
	public void clickSignupLink() {
        driver.findElement(signupElement).click();
        log.info("Clicked on the Signup link");
    }
	
	public String getSignupText() {
        String signupText = driver.findElement(signupVerifyElement).getText();
        log.info("Signup text retrieved: {}", signupText);
        return signupText;
    }
}
