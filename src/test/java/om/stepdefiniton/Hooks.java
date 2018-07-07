package om.stepdefiniton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.Before;

public class Hooks {
	public static WebDriver driver;

	@Before
	public static void Flipkartpage() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Rj\\eclipse-workspace\\java sel\\Driv\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	//@After
	//public static void quit() {
	//	driver.close();
	//	driver.quit();
	//}

}
