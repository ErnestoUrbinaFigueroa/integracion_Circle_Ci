package framework.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.utils.Constants;
import framework.utils.WebdriverUtils;

public abstract class BasePage {
	public static WebDriver driver;

	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		driver.manage().timeouts().implicitlyWait(Constants.PAGELOADTIME, TimeUnit.SECONDS);
	}

	public final boolean isLoaded() {
		return WebdriverUtils.isElementPresent(BasePage.driver, this.getPageLoadedLocator());
	}

	public abstract By getPageLoadedLocator();
}
