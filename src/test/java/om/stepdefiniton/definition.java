package om.stepdefiniton;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class definition {
	static WebDriver driver;

	@Given("^User is in the demoqa page$")
	public void user_is_in_the_demoqa_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rj\\eclipse-workspace\\java sel\\Driv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demoqa.com/registration/");

	}

	@When("^User enters the first name and last name$")
	public void user_enters_the_first_name_and_last_name() throws Throwable {
		driver.findElement(By.id("name_3_firstname")).sendKeys("Fname");
		driver.findElement(By.id("name_3_lastname")).sendKeys("Lname");
	}

	@Then("^User verifies the first name and last name$")
	public void user_verifies_the_first_name_and_last_name() throws Throwable {
		Assert.assertEquals("Fname", driver.findElement(By.id("name_3_firstname")).getAttribute("value"));
		Assert.assertEquals("Lname", driver.findElement(By.id("name_3_lastname")).getAttribute("value"));

	}
	@When("^User selects country as India$")
	public void user_selects_country_as_India() throws Throwable {
		WebElement drop = driver.findElement(By.id("dropdown_7"));
		Select s= new Select(drop);
		s.selectByVisibleText("India"); 
	}

	@Then("^User verifies the selected country$")
	public void user_verifies_the_selected_country() throws Throwable {
		WebElement drop = driver.findElement(By.id("dropdown_7"));
		Select s= new Select(drop);
		s.getFirstSelectedOption().getText().equals("India");
		
	}
	
}
