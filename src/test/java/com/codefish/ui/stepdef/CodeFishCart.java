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

import java.util.List;
import java.util.Map;

public class CodeFishCart {


    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage= new LoginPage(driver);
   ProductPage productPage = new ProductPage(driver);
    CartPage cartPage =new CartPage(driver);


    @Given("the user is on the product page")
    public void the_user_is_on_the_product_page() {

        loginPage.login(ConfigReader.readProperty("newUsername"), ConfigReader.readProperty("newPassword"));

    }

    @When("the user clicks the Add to cart button for {string}")
    public void the_user_clicks_the_add_to_cart_button_for(String productName) throws InterruptedException {


        productPage.addProductToTheCart(productName, driver);


    }

    @Then("a check mark should be displayed on the Add to cart button")
    public void a_check_mark_should_be_displayed_on_the_add_to_cart_button() {

        productPage.validateCheckMarkIsDisplayed();


    }


    //***********Snips for Second Scenario********************

    @When("User clicks the Add to cart button for multiple product")
    public void user_clicks_the_add_to_cart_button_for_multiple_product(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> products = dataTable.asMaps(String.class, String.class);
        int rowCount = products.size();

        for (int i = 0; i < rowCount; i++) {
            Map<String, String> product = products.get(i);
            String firstItem = product.get("firstItem");
            String secondItem = product.get("secondItem");
            productPage.addMultipleProductToTheCart(firstItem, driver);
            Thread.sleep(2000);
            productPage.addMultipleProductToTheCart(secondItem, driver);


        }

    }

    @When("User navigates to the cart page")
    public void user_navigates_to_the_cart_page() {
        productPage.clickCartButton(driver);
    }


    @Then("User validate all products information name,price and removeButton")
    public void user_validate_all_products_information_name_price_and_remove_button() throws InterruptedException {
        Thread.sleep(2000);
        cartPage.validateAllProductsNames();
        cartPage.validateAllProductPrices();
        cartPage.validateRemoveButtonVisible();
    }










}
