package com.codefish.ui.stepdef;

import com.codefish.ui.pages.LoginPage;
import com.codefish.ui.pages.RegisterPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class CodeFishRegister {
    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    RegisterPage registerPage=new RegisterPage(driver);
    @When("User on Login page click on Register")
    public void user_on_login_page_click_on_register() {
        loginPage.registerUserFunctionality();

    }
    @When("User provides username and password")
    public void user_provides_username_and_password() {
        registerPage.registerUser(ConfigReader.readProperty("newUsername"),ConfigReader.readProperty("newPassword"));


    }
    @Then("User login as a new created user and validates profile same as username")
    public void user_login_as_a_new_created_user_and_validates_profile_same_as_username() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.login(ConfigReader.readProperty("newUsername"),ConfigReader.readProperty("newPassword"));
        Thread.sleep(2000);
        Assert.assertEquals(ConfigReader.readProperty("newUsername"),loginPage.validateProfileName());

    }
}
