package com.codefish.ui.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartPage {

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[2]")
    List<WebElement> allProductsName;

    @FindBy(xpath = "//td[3]")
    List<WebElement> allProductPrice;

    @FindBy(xpath = "//td[4]")

    List<WebElement> allRemoveButton;


    public void validateAllProductsNames() throws InterruptedException {

        List<String> expectedProductNames = Arrays.asList("Sputnik Vaccine", "Paracetamol");
        Thread.sleep(3000);
        for (int i = 0; i < allProductsName.size(); i++) {
            System.out.println(BrowserUtils.getText(allProductsName.get(i)));
            Assert.assertEquals(expectedProductNames.get(i), BrowserUtils.getText(allProductsName.get(i)));

        }
    }

    public void validateAllProductPrices() {

        List<String> expectedProductPrice = Arrays.asList("6.59", "10.29");

        for (int i = 0; i < allProductPrice.size(); i++) {
            System.out.println(BrowserUtils.getText(allProductPrice.get(i)));
            Assert.assertEquals(expectedProductPrice.get(i), BrowserUtils.getText(allProductPrice.get(i)));


        }
    }

    public void validateRemoveButtonVisible() {

        for (int i = 0; i < allRemoveButton.size(); i++) {
            System.out.println(allRemoveButton.get(i).getText());
            Assert.assertTrue(allRemoveButton.get(i).getText().equals("Remove"));

        }

    }


}






