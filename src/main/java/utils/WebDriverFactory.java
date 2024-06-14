package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
//	private static WebDriver driver;
//
//	public static WebDriver getDriver() {
//        if (driver == null) {
//            String browser = ConfigurationManager.getProperty("browser.name");
//            boolean headlessMode = ConfigurationManager.getBooleanProperty("headless.mode");
//
//            if (headlessMode) {
//            	WebDriverManager.chromedriver().setup();
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--headless");
//                driver = new ChromeDriver(options);
//            } else {
//            	switch (browser.toLowerCase()) {
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    return new ChromeDriver();
//                case "edge":
//                    WebDriverManager.edgedriver().setup();
//                    return new EdgeDriver();
//                default:
//                    throw new IllegalArgumentException("Unsupported browser: " + browser);
//            }
//            }
//        }
//        return driver;
//    }
//}
	public static WebDriver getWebDriver(String browser, String headless) {
		if ("true".equals(headless)) {
       	WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
           return new ChromeDriver(options);
		}
		else {
		switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Invalid browser choice: " + browser);
        
		}}
    }
}
