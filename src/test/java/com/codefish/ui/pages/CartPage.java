package com.codefish.ui.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        List<String> actualProductsNames = new ArrayList<>();

        Thread.sleep(3000);
        for (int i = 0; i < allProductsName.size(); i++) {
            actualProductsNames.add(BrowserUtils.getText(allProductsName.get(i)));
        }
        Collections.sort(expectedProductNames);
        Collections.sort(actualProductsNames);
        Assert.assertEquals(expectedProductNames, actualProductsNames);
    }

    public void validateAllProductPrices() {

        List<Double> expectedProductPrice = Arrays.asList(6.59, 10.29);
        List<Double> actualProductsPrice = new ArrayList<>();
        for (int i = 0; i < allProductPrice.size(); i++) {
            actualProductsPrice.add(Double.parseDouble(BrowserUtils.getText(allProductPrice.get(i))));
        }
        Collections.sort(expectedProductPrice);
        Collections.sort(actualProductsPrice);
        Assert.assertEquals(expectedProductPrice, actualProductsPrice);
    }


}
