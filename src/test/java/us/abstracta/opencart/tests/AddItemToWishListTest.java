package us.abstracta.opencart.tests;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.tests.BaseTest;
import us.abstracta.opencart.pages.AccountLogin;
import us.abstracta.opencart.pages.MyAccountPage;
import us.abstracta.opencart.pages.SearchResult;

public class AddItemToWishListTest extends BaseTest {

	@Test(dataProvider = "dataProvider")
	public void AddItemToWishList(String user, String pass, String product) {
		SearchResult searchResult;
		AccountLogin loginPage;
		MyAccountPage myAccountPage;

		loginPage = homePage.login();
		loginPage.inputUser(user);
		loginPage.inputPassword(pass);
		myAccountPage = loginPage.logon();
		assertEquals(myAccountPage.getAccountTitle(), "My Account");

		homePage.searchProduct(product);
		searchResult = homePage.clickSearchButton();
		assertEquals(searchResult.getProductName(), product);
		searchResult.addItemToWishList();
		searchResult.openWishList();
		assertEquals(searchResult.verifyTitleWishList(), "My Wish List");
		assertEquals(searchResult.verifyItem(), product);
	}

	@DataProvider(name = "dataProvider")
	public Object[][] getDataFromDataprovider(Method m) {
		if (m.getName().equalsIgnoreCase("AddItemToWishList")) {
			return new Object[][] { { "ernesto.urbina@cl.abstracta.us", "ernesto", "MacBook" } };
		} else {
			return new Object[][] { { "xxxxxx", "xxxxxx", "xxxxxx" } };
		}
	}

}
