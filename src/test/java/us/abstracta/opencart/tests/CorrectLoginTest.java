package us.abstracta.opencart.tests;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.tests.BaseTest;
import us.abstracta.opencart.pages.AccountLogin;
import us.abstracta.opencart.pages.MyAccountPage;

public class CorrectLoginTest extends BaseTest {

	@Test(dataProvider = "LoginProvider")
	public void loginCorrect(String user, String password) {
		AccountLogin loginPage;
		MyAccountPage myAccountPage;

		loginPage = homePage.login();
		loginPage.inputUser(user);
		loginPage.inputPassword(password);
		myAccountPage = loginPage.logon();
		assertEquals(myAccountPage.getAccountTitle(), "My Account");
	}

	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromDataprovider(Method m) {
		if (m.getName().equalsIgnoreCase("loginCorrect")) {
			return new Object[][] { { "ernesto.urbina@cl.abstracta.us", "ernesto" } };
		} else {
			return new Object[][] { { "xxx.xxx@cl.abstracta.us", "xxxxxx" } };
		}
	}

}
