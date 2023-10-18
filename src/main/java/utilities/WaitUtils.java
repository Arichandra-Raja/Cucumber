package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;
import java.time.Duration;



public class WaitUtils {
	private static WebDriver driver = BaseClass.getDriver();

public static void waitForElementToBeClickable(WebElement element, int timeout) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    wait.until(ExpectedConditions.elementToBeClickable(element));
}

public static void waitForElementToBeVisible(WebElement element, int timeout) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    wait.until(ExpectedConditions.visibilityOf(element));
}



}


