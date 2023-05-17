package com.codefish.ui.stepdef;

import com.codefish.ui.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class CpdefishLogin {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);


    @When("User provides  correct credentials and login")
    public void userProvidesCorrectCredentialsAndLogin() {
        loginPage.login();
    }

    @Then("User validates title {string}")
    public void userValidatesTitle(String title) {
        loginPage.loginValidateTitle(title, driver);
        loginPage.logout();
    }

    @When("User provides  {string} and {string} and login")
    public void userProvidesUsernameAndPasswordAndLogin(String username, String password) {
        loginPage.loginNegative(username, password);
    }

    @Then("User validates message {string}")
    public void userValidatesMessage(String errorMessage) {
        Assert.assertEquals(errorMessage, loginPage.loginValidateMessage());
    }

}
