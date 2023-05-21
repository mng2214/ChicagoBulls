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

    @FindBy(xpath = "//button[@type='button']")
    WebElement removeButton;
    @FindBy(xpath = "//div[@role='alert']")
    WebElement emptyCartMessage;




    public void validateAllProductsNames() throws InterruptedException {

        List<String> expectedProductNames = Arrays.asList("Paracetamol","Sputnik Vaccine");
        Thread.sleep(3000);
        for (int i = 0; i < allProductsName.size(); i++) {
            System.out.println(BrowserUtils.getText(allProductsName.get(i)));
            Assert.assertEquals(expectedProductNames.get(i), BrowserUtils.getText(allProductsName.get(i)));

        }
        Thread.sleep(3000);
    }

    public void validateAllProductPrices(){

        List<String> expectedProductPrice = Arrays.asList("10.29","6.59");

        for (int i=0; i < allProductPrice.size();i++){
            System.out.println(BrowserUtils.getText(allProductPrice.get(i)));
            Assert.assertEquals(expectedProductPrice.get(i),BrowserUtils.getText(allProductPrice.get(i)));


        }



    }

    public void removeProduct() throws InterruptedException {
        Thread.sleep(3000);
        removeButton.click();

    }

    public void validateCartMessage(String expectedMessage) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(expectedMessage,BrowserUtils.getText(emptyCartMessage));
    }





}
