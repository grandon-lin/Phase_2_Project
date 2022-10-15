package stepdefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomepageStepDef {

	WebDriver driver = Hooks.driver;
	String productName = "";
	int cartItems = 0;
	
	@Given("I have successfully login")
	public void i_have_successfully_login() {
	    LoginStepDef lsd = new LoginStepDef();
	    lsd.i_have_launched_the_application();
	    lsd.i_enter_the_correct_username_and_password();
	    lsd.i_click_on_the_Login_Button();
	    lsd.i_should_land_on_the_home_page();
	}

	@When("I select the product as {string}")
	public void i_select_the_product_as(String productName) {
		String xpath = "//div[@class='inventory_item_name' and contains(text(), '" + productName + "')]";
	    WebElement product = driver.findElement(By.xpath(xpath));
	    this.productName = productName;
	    product.click();
	}

	@Then("I should land on the product detail page")
	public void i_should_land_on_the_product_detail_page() {
		String productTitle = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText();
	    Assert.assertEquals(productTitle, productName);
	}
	
	@When("I select the ADD_TO_CART button for the {string}")
	public void i_select_the_button_for_the(String productNameVal) {
	    String xpath = "//div[text()='" +  productNameVal + "']//following::button[1]";
	    WebElement addToCartBtn = driver.findElement(By.xpath(xpath));
	    addToCartBtn.click();
	    cartItems++;
	}

	@Then("Cart item number should be increased by one")
	public void cart_item_number_should_be_increased_by_one() {
	    WebElement cartIcon = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
	    Assert.assertTrue(cartIcon.getText().equals(String.valueOf(cartItems)));
	}
}
