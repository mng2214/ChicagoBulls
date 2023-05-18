package com.codefish.ui.stepdef;

import com.codefish.ui.pages.LoginPage;
import com.codefish.ui.pages.ProductPage;
import io.cucumber.java.en.Then;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import static org.junit.Assert.assertEquals;

public class CodeFishProduct {
    WebDriver driver = DriverHelper.getDriver();
    ProductPage productPage = new ProductPage(driver);


    @Then("User should see multiple products displayed")
    public void user_should_see_multiple_products_displayed() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(9, productPage.getProductCount());
    }

    @Then("User should see the picture of each product")
    public void user_should_see_the_picture_of_each_product()  {
        Assert.assertEquals(9, productPage.getPicturesCount());
    }


    @Then("User should see the name of each product")
    public void user_should_see_the_name_of_each_product() {
        Assert.assertEquals(9, productPage.getProductNames());
    }

    @Then("User should see the description of each product")
    public void user_should_see_the_description_of_each_product() {
        Assert.assertEquals(9, productPage.getAllProductDescription());
    }

    @Then("User should see the price of each product")
    public void user_should_see_the_price_of_each_product() {
        Assert.assertEquals(9, productPage.getAllPrices());
    }

    @Then("User should see an Add to Cart button for each product")
    public void user_should_see_an_add_to_cart_button_for_each_product() {
        Assert.assertEquals(9, productPage.getAllToCartButtons());
    }
}


