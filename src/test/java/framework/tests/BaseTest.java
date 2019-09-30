package framework.tests;

import framework.utils.GetProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import us.abstracta.opencart.pages.HomePage;

public abstract class BaseTest {

	protected WebDriver driver;
	protected HomePage homePage;
	protected GetProperties prop = new GetProperties();

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get(prop.getString("BASE_URL"));
		driver.manage().window().maximize();

		homePage = PageFactory.initElements(driver, HomePage.class);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
