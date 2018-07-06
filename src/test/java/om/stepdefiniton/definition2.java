package om.stepdefiniton;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class definition2 {
	static WebDriver driver;

	@Given("^User is in demoqa page$")
	public void user_is_in_demoqa_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rj\\eclipse-workspace\\java sel\\Driv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demoqa.com/registration/");
	}

	@When("^User enters the first name, last name, etc$")
	public void user_enters_the_first_name_last_name_etc(DataTable mydata) throws Throwable {

		List<List<String>> list = mydata.asLists(String.class);
		driver.findElement(By.id("name_3_firstname")).sendKeys(list.get(0).get(0));
		driver.findElement(By.id("name_3_lastname")).sendKeys(list.get(0).get(1));
		driver.findElement(By.id("phone_9")).sendKeys(list.get(0).get(2));
		driver.findElement(By.id("username")).sendKeys(list.get(0).get(3));
		driver.findElement(By.id("email_1")).sendKeys(list.get(0).get(4));
		driver.findElement(By.id("description")).sendKeys(list.get(0).get(5));
		driver.findElement(By.id("password_2")).sendKeys(list.get(0).get(6));
		driver.findElement(By.id("confirm_password_password_2")).sendKeys(list.get(0).get(7));

	}

	@Then("^User verifies the first name, last name, etc$")
	public void user_verifies_the_first_name_last_name_etc() throws Throwable {
		Assert.assertEquals("Raj", driver.findElement(By.id("name_3_firstname")).getAttribute("value"));
		Assert.assertEquals("Kamal", driver.findElement(By.id("name_3_lastname")).getAttribute("value"));
		Assert.assertEquals("9888898888", driver.findElement(By.id("phone_9")).getAttribute("value"));
		Assert.assertEquals("rajkml", driver.findElement(By.id("username")).getAttribute("value"));
		Assert.assertEquals("rajkml@outlook.com", driver.findElement(By.id("email_1")).getAttribute("value"));
		Assert.assertEquals("About your self", driver.findElement(By.id("description")).getAttribute("value"));
		Assert.assertEquals("raj55555", driver.findElement(By.id("password_2")).getAttribute("value"));
		Assert.assertEquals("raj55555", driver.findElement(By.id("confirm_password_password_2")).getAttribute("value"));

	}

	@When("^User selects marital status$")
	public void user_selects_marital_status() throws Throwable {
		driver.findElement(By.xpath("//*[@type='radio'][2]")).click();

	}

	@Then("^User verifies the selected marital status$")
	public void user_verifies_the_selected_marital_status() throws Throwable {
		Assert.assertEquals("married", driver.findElement(By.xpath("//*[@type='radio'][2]")).getAttribute("value"));

	}

	@When("^User selects hobby$")
	public void user_selects_hobby() throws Throwable {
		driver.findElement(By.xpath("//*[@type=\"checkbox\"][1]")).click();
		driver.findElement(By.xpath("//*[@type=\"checkbox\"][2]")).click();
		driver.findElement(By.xpath("//*[@type=\"checkbox\"][3]")).click();

	}

	@Then("^User verifies the selected hobby$")
	public void user_verifies_the_selected_hobby() throws Throwable {
		Assert.assertEquals("dance", driver.findElement(By.xpath("//*[@type=\"checkbox\"][1]")).getAttribute("value"));
		Assert.assertEquals("reading",
				driver.findElement(By.xpath("//*[@type=\"checkbox\"][2]")).getAttribute("value"));
		Assert.assertEquals("cricket ",
				driver.findElement(By.xpath("//*[@type=\"checkbox\"][3]")).getAttribute("value"));
	}

	@When("^User selects country and dob$")
	public void user_selects_country_and_dob() throws Throwable {
		WebElement drop = driver.findElement(By.id("dropdown_7"));
		WebElement month = driver.findElement(By.id("mm_date_8"));
		WebElement day = driver.findElement(By.id("dd_date_8"));
		WebElement year = driver.findElement(By.id("yy_date_8"));
		Select s = new Select(drop);
		s.selectByVisibleText("India");
		Select m = new Select(month);
		m.selectByVisibleText("8");
		Select d = new Select(day);
		d.selectByVisibleText("30");
		Select y = new Select(year);
		y.selectByVisibleText("1989");

	}

	@Then("^User verifies the selected country and dob$")
	public void user_verifies_the_selected_country_and_dob() throws Throwable {
		WebElement drop = driver.findElement(By.id("dropdown_7"));
		WebElement month = driver.findElement(By.id("mm_date_8"));
		WebElement day = driver.findElement(By.id("dd_date_8"));
		WebElement year = driver.findElement(By.id("yy_date_8"));
		Select s = new Select(drop);
		s.getFirstSelectedOption().getText().equals("India");
		Select m = new Select(month);
		m.getFirstSelectedOption().getText().equals("8");
		Select d = new Select(day);
		d.getFirstSelectedOption().getText().equals("30");
		Select y = new Select(year);
		y.getFirstSelectedOption().getText().equals("1989");
	}

}
