package us.abstracta.opencart.tests;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.tests.BaseTest;
import us.abstracta.opencart.pages.SearchResult;

public class AddItemToCartTest extends BaseTest {

	@Test(dataProvider = "ItemProvider")
	@Step("Agregar producto al Carro de Compras")
	@Severity(SeverityLevel.CRITICAL)
	public void addItemToCart(String producto) {
		SearchResult searchResult;

		homePage.searchProduct(producto);
		searchResult = homePage.clickSearchButton();
		assertEquals(searchResult.getProductName(), producto);
		searchResult.addItemToCart();
		searchResult.openCart();
		assertEquals(searchResult.verifyItem(), producto);
	}

	@DataProvider(name = "ItemProvider")
	public Object[][] getDataFromDataprovider(Method m) {
		if (m.getName().equalsIgnoreCase("addItemToCart")) {
			return new Object[][] { { "MacBook" } };
		} else {
			return new Object[][] { { "xxxxxx" } };
		}
	}

}
