package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import constants.ElementLocators;
import utilities.WaitUtils;

public class LoginPage {

   
    protected WebDriver driver;

    private By usernameField = By.id(ElementLocators.USERNAME_FIELD);
    private By passwordField = By.id(ElementLocators.PASSWORD_FIELD);
    private By submitField = By.id(ElementLocators.SUBMIT_FIELD);
    private By errorMessage = By.id(ElementLocators.ERROR_FIELD);
    private By successMessage = By.xpath(ElementLocators.SUCCESS_MESSAGE_LOCATOR);

   

	public LoginPage() {
		driver = BaseClass.getDriver();
		}
    public void enterUsername(String username) {
        WebElement element = driver.findElement(usernameField);
        element.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement element = driver.findElement(passwordField);
        element.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement element = driver.findElement(submitField);  
        WaitUtils.waitForElementToBeClickable(element, 10);
        element.click();
    }

    public String getErrorMessage() {
        WebElement element = driver.findElement(errorMessage);
        WaitUtils.waitForElementToBeVisible(element, 10);
        return element.getText();
    }

    public String getSuccessMessage() {
        WebElement element = driver.findElement(successMessage);
        WaitUtils.waitForElementToBeVisible(element, 10);
        return element.getText();
    }
}
