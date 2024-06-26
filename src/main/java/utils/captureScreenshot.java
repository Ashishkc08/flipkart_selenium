package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class captureScreenshot {
	public static String captureScreenshot(WebDriver driver, String screenshotName) {
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destPath = "screenshots/" + screenshotName + "_" + timeStamp + ".png";

        try {
            Path destination = Paths.get(destPath).toAbsolutePath();
            Files.createDirectories(destination.getParent());
            Files.copy(screenshot.toPath(), destination);
            return destination.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
	}
}
