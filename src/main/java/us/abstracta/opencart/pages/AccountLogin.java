package us.abstracta.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import framework.pages.BasePage;

public class AccountLogin extends BasePage {

	@FindBy(how = How.XPATH, using = "//input[@id='input-email']")
	private WebElement emailAddress;

	@FindBy(how = How.XPATH, using = "//input[@id='input-password']")
	private WebElement password;

	@FindBy(how = How.XPATH, using = "//input[@class='btn btn-primary']")
	private WebElement logon;

	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-danger']")
	private WebElement failLogin;

	private By pageLoadedlocator = By.xpath("//h2[contains(text(),'Returning Customer')]");

	public AccountLogin(WebDriver driver) {
		super(driver);

		if (!isLoaded()) {
			throw new IllegalStateException("This is not Abstracta Cart Login Page");
		}
	}

	public void inputUser(String user) {
		emailAddress.sendKeys(user);
	}

	public void inputPassword(String pass) {
		password.sendKeys(pass);
	}

	public MyAccountPage logon() {
		logon.click();
		return PageFactory.initElements(driver, MyAccountPage.class);
	}
	
	public void logonFail() {
		logon.click();
	}

	public String getErrorLogin() {
		return failLogin.getText();
	}

	@Override
	public By getPageLoadedLocator() {
		return pageLoadedlocator;
	}

}
