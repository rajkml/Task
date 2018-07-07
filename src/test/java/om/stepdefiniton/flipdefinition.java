package om.stepdefiniton;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class flipdefinition {

	@Given("^The user is in flipkart page$")
	public void the_user_is_in_flipkart_page() throws Throwable {
		Hooks.driver.get("https://www.flipkart.com/");
		Hooks.driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
	}

	@Given("^User searh for the product \"([^\"]*)\"$")
	public void user_searh_for_the_product(String phone) throws Throwable {
		Hooks.driver.findElement(By.xpath("//*[@title=\"Search for products, brands and more\"]")).sendKeys(phone,
				Keys.ENTER);
		Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("^The user adds the item \"([^\"]*)\" to the cart$")
	public void the_user_adds_the_item_to_the_cart(Integer itemIndex) throws Throwable {
		++itemIndex;
		Hooks.driver
				.findElement(
						By.xpath("//*[@id='container']/div/div[1]/div/div[2]/div[1]/div[2]/div[" + itemIndex + "]"))
				.click();

	}

	@When("^the user adds the item to the cart$")
	public void the_user_adds_the_item_to_the_cart() throws Throwable {

		Set<String> allwindows = Hooks.driver.getWindowHandles();
		for (String child : allwindows) {

			if (!Hooks.driver.getWindowHandle().equalsIgnoreCase(child)) {
				Hooks.driver.switchTo().window(child);
			}
			String title = Hooks.driver.getTitle();
			System.out.println(title);
		}
		

		Hooks.driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();

		Hooks.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^The user verifies the item \"([^\"]*)\" in the cart$")
	public void the_user_verifies_the_item_in_the_cart(String phone) throws Throwable {
		boolean contains = Hooks.driver.findElement(By.xpath("//div/a[contains(text(),'"+phone+"')]")).getText().contains(phone);
		Assert.assertTrue(contains);
				
		
	}
	}
	   
	
	

