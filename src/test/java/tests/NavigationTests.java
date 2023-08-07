package tests;

import constants.LoginConst;
import org.testng.annotations.Test;
import testdata.URL;
import static org.testng.Assert.*;
import static utils.SeleniumUtils.*;

public class NavigationTests extends BaseTest{

    @Test(description = "Tests that a user can navigate to Login page")
    public void navigateToLoginPage() {
        navigateTo(URL.HOME_PAGE);
        header.clickAccountButton();
        header.clickLoginButton();

        assertEquals(LoginConst.LOGIN_PAGE_TITLE, loginPage.getLoginPageTitle());
        assertEquals(loginPage.getCurrentUrl(), URL.LOGIN_PAGE);
    }

    @Test(description = "Hover over Men drop down menu")
    public void hoverOverMen() throws InterruptedException {
        navigateTo(URL.HOME_PAGE);
        //navigateTo(URL.HOME_PAGE);
        menu.expandMenuDropDown();
    }
}
