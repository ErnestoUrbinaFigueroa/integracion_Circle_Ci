package us.abstracta.opencart.tests;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.tests.BaseTest;
import us.abstracta.opencart.pages.SearchResult;

public class SearchItemTest extends BaseTest {

	@Test(dataProvider = "ItemProvider")
	public void searchItem(String producto) {
		SearchResult searchResult;

		homePage.searchProduct(producto);
		searchResult = homePage.clickSearchButton();
		assertEquals(searchResult.getProductName(), producto);
	}

	@DataProvider(name = "ItemProvider")
	public Object[][] getDataFromDataprovider(Method m) {
		if (m.getName().equalsIgnoreCase("searchItem")) {
			return new Object[][] { { "MacBook" } };
		} else {
			return new Object[][] { { "xxxxxx" } };
		}
	}

}
