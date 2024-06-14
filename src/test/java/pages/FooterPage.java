package pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FooterPage extends BasePage{
	public FooterPage(WebDriver driver) {
        super(driver);
    }
	private By aboutUsLink = By.linkText("About Us");
    private By contactUsLink = By.xpath("//a[@aria-label='Contact Us']");
    private By careersLink = By.xpath("//a[@href='https://www.flipkartcareers.com/?otracker=${otracker}_navlinks']");
    private By privacyPolicyLink = By.xpath("//a[.='Privacy']");
    private By myntraLink = By.xpath("//a[@aria-label='Myntra']");
    private By vrifyContactUs = By.xpath("//h1[contains(text(),'Flipkart Help Center | 24x7 Customer Care Support')]");
    
    public boolean isFooterLinkPresent(By link) {
        return driver.findElements(link).size() > 0;
    }

    public void clickFooterLink(By link) {
        WebElement footerLink = driver.findElement(link);
        footerLink.click();
    }

    public boolean isAboutUsLinkPresent() {
        return isFooterLinkPresent(aboutUsLink);
    }

    public boolean isContactUsLinkPresent() {
        return isFooterLinkPresent(contactUsLink);
    }

    public boolean isCareersLinkPresent() {
        return isFooterLinkPresent(careersLink);
    }

    public boolean isPrivacyPolicyLinkPresent() {
        return isFooterLinkPresent(privacyPolicyLink);
    }

    public boolean isMyntraLinkPresent() {
        return isFooterLinkPresent(myntraLink);
    }

    public void clickAboutUsLink() {
        clickFooterLink(aboutUsLink);
    }

    public void clickContactUsLink() {
        clickFooterLink(contactUsLink);
    }

    public void clickCareersLink() throws InterruptedException {
        clickFooterLink(careersLink);
        Thread.sleep(2000);
    }

    public void clickPrivacyPolicyLink() {
        clickFooterLink(privacyPolicyLink);
    }

    public void clickMyntraLink() {
        clickFooterLink(myntraLink);
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
    
    public boolean verifyContactUsNavigation() {
    	
    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement contactUsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(vrifyContactUs));
        return contactUsElement != null;
    }
}
