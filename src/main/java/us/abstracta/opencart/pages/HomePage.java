package us.abstracta.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import framework.pages.BasePage;

public class HomePage extends BasePage {

	@FindBy(how = How.XPATH, using = "//div[@id='search']//button")
	private WebElement btnSearch;

	@FindBy(how = How.NAME, using = "search")
	private WebElement inpSearch;

	@FindBy(how = How.XPATH, using = "//ul[@class='list-inline']//a[@class='dropdown-toggle']")
	private WebElement myAccount;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Login')]")
	private WebElement login;

	private By pageLoadedlocator = By.id("slideshow0");

	public HomePage(WebDriver driver) {
		super(driver);

		if (!isLoaded()) {
			throw new IllegalStateException("This is not Abstracta Cart Home Page");
		}
	}

	public void searchProduct(String product) {
		inpSearch.sendKeys(product);
	}

	public SearchResult clickSearchButton() {
		btnSearch.click();
		return PageFactory.initElements(driver, SearchResult.class);
	}

	public AccountLogin login() {
		myAccount.click();
		login.click();
		return PageFactory.initElements(driver, AccountLogin.class);
	}

	@Override
	public By getPageLoadedLocator() {
		return pageLoadedlocator;
	}

}
