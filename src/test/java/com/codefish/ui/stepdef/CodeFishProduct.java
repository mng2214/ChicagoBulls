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


    @Then("User validates  {int} of: picture, names, descriptions, prices and Add to Cart")
    public void userValidatesOfPictureNamesDescriptionsPricesAndAddToCart(int numOfItems) {
        Assert.assertEquals(numOfItems,productPage.getAllToCartButtons());
        Assert.assertEquals(numOfItems,productPage.getProductNames());
        Assert.assertEquals(numOfItems,productPage.getPicturesCount());
        Assert.assertEquals(numOfItems,productPage.getAllProductDescription());
        Assert.assertEquals(numOfItems,productPage.getAllPrices());
    }







}


