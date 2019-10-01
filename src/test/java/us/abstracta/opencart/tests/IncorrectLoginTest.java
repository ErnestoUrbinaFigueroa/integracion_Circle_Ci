package us.abstracta.opencart.tests;

import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import framework.tests.BaseTest;
import us.abstracta.opencart.pages.AccountLogin;

public class IncorrectLoginTest extends BaseTest {

    @Test(dataProvider = "LoginProvider")
    @Step("Prueba de Login Incorrecto")
    @Severity(SeverityLevel.MINOR)
    public void loginIncorrect(String user, String password) {
        AccountLogin loginPage;

        loginPage = homePage.login();
        loginPage.inputUser(user);
        loginPage.inputPassword(password);
        loginPage.logonFail();
        assertTrue(loginPage.getErrorLogin().contains("Warning:"));
    }

    @DataProvider(name = "LoginProvider")
    public Object[][] getDataFromDataprovider(Method m) {
        if (m.getName().equalsIgnoreCase("loginIncorrect")) {
            return new Object[][]{{"ernesto@cl.abstracta.us", "xxxxxx"},
                    {"ernesto.urbina@cl.abstracta.us", "notpass"},
                    {"ernesto.nocorrect@cl.abstracta.us", "ernesto"}};
        } else {
            return new Object[][]{{"xxx.xxx@cl.abstracta.us", "xxxxxx"}};
        }
    }

}
