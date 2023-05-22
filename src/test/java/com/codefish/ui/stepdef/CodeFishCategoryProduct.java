package com.codefish.ui.stepdef;

import com.codefish.ui.pages.ProductPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.io.IOException;

public class CodeFishCategoryProduct {
    WebDriver driver = DriverHelper.getDriver();
    ProductPage productPage = new ProductPage(driver);

    @Then("User choose a {string} and validates productName and price belongs to that category")
    public void userChooseAAndValidatesProductNameAndPriceBelongsToThatCategory(String category) throws IOException {
        productPage.categoryProductFunctionality(category);

    }
}
