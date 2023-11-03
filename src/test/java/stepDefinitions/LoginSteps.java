package stepDefinitions;

import io.cucumber.java.en.*;
import pages.LoginPage;
import constants.LoginCredentials;
import constants.Messages;
import utilities.RandomDataGenerator;
import static org.junit.Assert.assertEquals;

public class LoginSteps {
	
	LoginPage loginPage = new LoginPage();
    
	@When("^I enter a \"([^\"]*)\" in the .* field$")
	public void i_enter_in_the_field(String value) {
        switch(value) {
            case "Valid username":
                loginPage.enterUsername(LoginCredentials.VALID_USERNAME);
                break;
            case "Valid password":
                loginPage.enterPassword(LoginCredentials.VALID_PASSWORD);
                break;
            case "invalid username":
                loginPage.enterUsername(RandomDataGenerator.generateRandomString());
                break;
            case "invalid password":
                loginPage.enterPassword(RandomDataGenerator.generateRandomString());
                break;
            default:
                throw new IllegalArgumentException("Value " + value + " not recognized.");
                
        }
    }

    @When("I Click the {string}")
    public void i_click_the_button(String buttonName) {
        if ("Login button".equals(buttonName)) {
            loginPage.clickLoginButton();
        }else {
        	throw new IllegalArgumentException("Button name of " + buttonName + " not recognized.");
        }
        
    }

    @Then("I should see the {string} in the {string} field")
    public void i_should_see_the_message_in_the_field(String messageKey, String fieldName) {
        String expectedMessage;
        
        switch(messageKey) {
            case "successful message":
                expectedMessage = Messages.SUCCESSFUL_LOGIN_MESSAGE;
                break;
            case "username error":
                expectedMessage = Messages.USERNAME_ERROR;
                break;
            case "password error":
                expectedMessage = Messages.PASSWORD_ERROR;
                break;
            default:
                throw new IllegalArgumentException("Message key " + messageKey + " not recognized.");
        }
        
        switch(fieldName) {
            case "error":
                assertEquals(expectedMessage, loginPage.getErrorMessage());
                break;
            case "home page":
                assertEquals(expectedMessage, loginPage.getSuccessMessage());
                break;
            default:
                throw new IllegalArgumentException("Field " + fieldName + " not recognized.");
		System.out.println("Catch the message successfully");
        }
    }


    
}
