package us.abstracta.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.pages.BasePage;

public class MyAccountPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//div[@id='search']//button")
	private WebElement btnSearch;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'My Account')]")
	private WebElement accountTitle;

	private By pageLoadedlocator = By.xpath("//h2[contains(text(),'My Account')]");

	public MyAccountPage(WebDriver driver) {
		super(driver);

		if (!isLoaded()) {
			throw new IllegalStateException("This is not Abstracta My Account Page");
		}
	}

	public String getAccountTitle() {
		return accountTitle.getText();
	}

	@Override
	public By getPageLoadedLocator() {
		return pageLoadedlocator;
	}

}
