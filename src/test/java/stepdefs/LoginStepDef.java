package stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {

	WebDriver driver = Hooks.driver;
	
	@Given("I have launched the application")
	public void i_have_launched_the_application() {
	    driver.get("https://www.saucedemo.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
	}

	@When("I enter the correct username as {string} and password as {string}")
	public void i_enter_the_correct_username_as_and_password_as(String usernameVal, String passwordVal) {
	    WebElement username = driver.findElement(By.id("user-name"));
	    username.sendKeys(usernameVal);
	    
	    WebElement password = driver.findElement(By.id("password"));
	    password.sendKeys(passwordVal);
	}
	
	@When("I enter the correct username and password")
	public void i_enter_the_correct_username_and_password() {
		WebElement username = driver.findElement(By.id("user-name"));
	    username.sendKeys("standard_user");
	    
	    WebElement password = driver.findElement(By.id("password"));
	    password.sendKeys("secret_sauce");
	}

	@When("I click on the Login Button")
	public void i_click_on_the_Login_Button() {
	    WebElement loginBtn = driver.findElement(By.id("login-button"));
	    loginBtn.click();
	}

	@Then("I should land on the home page")
	public void i_should_land_on_the_home_page() {
	    WebElement inventoryContainer = driver.findElement(By.id("inventory_container"));
	    Assert.assertTrue(inventoryContainer.isDisplayed());
	}

	@When("I enter the incorrect username as {string} and password as {string}")
	public void i_enter_the_incorrect_username_as_and_password_as(String usernameVal, String passwordVal) {
		 WebElement username = driver.findElement(By.id("user-name"));
		    username.sendKeys(usernameVal);
		    
		    WebElement password = driver.findElement(By.id("password"));
		    password.sendKeys(passwordVal);
	}

	@Then("I should get the error message {string}")
	public void i_should_get_the_error_message(String expError) {
	    WebElement error = driver.findElement(By.xpath("//h3[@data-test='error']"));
	    String actError = error.getText();
	    
	    Assert.assertEquals(expError, actError);
	}
	
}
