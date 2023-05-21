package com.codefish.ui.stepdef;

import com.codefish.ui.pages.CartPage;
import com.codefish.ui.pages.LoginPage;
import com.codefish.ui.pages.ProductPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.Map;

public class CodeFishRemoveProduct {
    WebDriver driver = DriverHelper.getDriver();
    CartPage cartPage = new CartPage(driver);
    ProductPage productPage = new ProductPage(driver);
    LoginPage loginPage=new LoginPage(driver);

    @Given("User add a product to shopping cart")
    public void userAddAProductToShoppingCart(DataTable dataTable) throws InterruptedException {
        loginPage.login(ConfigReader.readProperty("newUsername"),ConfigReader.readProperty("newPassword"));
        Map<String, String> product = dataTable.asMap();
        productPage.addProductToTheCart(product.get("product"), driver);
        productPage.clickCartButton(driver);
    }

    @When("User deletes the product")
    public void userDeletesTheProduct() throws InterruptedException {
        cartPage.removeProduct();
    }

    @Then("User validates message")
    public void userValidatesMessage(DataTable dataTable) throws InterruptedException {
        Map<String, String> messageExpected = dataTable.asMap();
        cartPage.validateCartMessage(messageExpected.get("message"));
    }

}
