package us.abstracta.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.pages.BasePage;

public class SearchResult extends BasePage {

	@FindBy(how = How.XPATH, using = "//div[@class='caption']/h4/a")
	private WebElement productNameFirstElement;

	@FindBy(how = How.XPATH, using = "//p[@class='price']")
	private WebElement productoPriceFirstElement;

	@FindBy(how = How.XPATH, using = "//div[@class='button-group']/button[@type='button']/i[@class='fa fa-shopping-cart']")
	private WebElement addItemToCart;

	@FindBy(how = How.XPATH, using = "//div[@class='button-group']/button[@type='button' and @data-original-title='Add to Wish List']")
	private WebElement addItemToWishList;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	private WebElement selectCart;

	@FindBy(how = How.ID, using = "wishlist-total")
	private WebElement selectWishList;

	@FindBy(how = How.XPATH, using = "//td[@class='text-left']//a")
	private WebElement verifyItem;

	@FindBy(how = How.XPATH, using = "//h2")
	private WebElement verifyTitle;

	private By pageLoadLocator = By.xpath("//h2[contains(text(),'Products meeting the search criteria')]");

	public SearchResult(WebDriver driver) {
		super(driver);
		if (!isLoaded()) {
			throw new IllegalStateException("This is not Abstracta Cart SearchResult Page");
		}
	}

	public String getProductName() {
		return productNameFirstElement.getText();
	}

	public String getProductPrice() {
		return productoPriceFirstElement.getText();
	}

	public void addItemToCart() {
		addItemToCart.click();
	}

	public void addItemToWishList() {
		addItemToWishList.click();
	}

	public void openCart() {
		selectCart.click();
	}

	public void openWishList() {
		selectWishList.click();
	}

	public String verifyTitleWishList() {
		return verifyTitle.getText();
	}

	public String verifyItem() {
		return verifyItem.getText();
	}

	@Override
	public By getPageLoadedLocator() {
		return pageLoadLocator;
	}

}
