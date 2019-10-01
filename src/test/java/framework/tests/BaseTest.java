package framework.tests;

import framework.utils.GetProperties;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import us.abstracta.opencart.pages.HomePage;

import java.sql.Driver;

public abstract class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected GetProperties prop = new GetProperties();

    @BeforeTest
    @Description("Descripción en el setUp del test Base")
    @Parameters({"DRIVER"})
    public void setUp(String DRIVER) {
        if (DRIVER.equalsIgnoreCase("Firefox_linux")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
            driver = new FirefoxDriver();
        } else if (DRIVER.equalsIgnoreCase("Chrome_linux")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
            driver = new ChromeDriver();
        } else if (DRIVER.equalsIgnoreCase("Firefox_windows")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver_win64.exe");
            driver = new FirefoxDriver();
        } else if (DRIVER.equalsIgnoreCase("Chrome_windows")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.get(prop.getString("BASE_URL"));
        driver.manage().window().maximize();

        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @AfterTest
    @Description("Descripción en el tearDown del test Base")
    public void tearDown() {
        driver.quit();
    }
}
