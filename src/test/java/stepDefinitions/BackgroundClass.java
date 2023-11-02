package stepDefinitions;

import base.BaseClass;
import constants.LoginCredentials;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class BackgroundClass {
	
	
	
	@Given("I launch the browser")
    public void i_launch_the_browser() {
        BaseClass.initializeDriver();
        
        System.out.println("Lauched the browser Successfully");
    }

    @And("I am on the {string}")
    public void i_am_on_the_login_page(String pageName) {
   
    	switch(pageName) {
    	case "Test Login Page":
    		BaseClass.getDriver().get(LoginCredentials.LOGIN_PAGE_URL);
    		break;
    	default:
    		throw new IllegalArgumentException("Entered " + pageName + " is not valid" );
    	}
    }
    
    @After
    public void tearDown() {
        BaseClass.closeDriver();
    }
	
}
