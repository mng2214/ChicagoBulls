package com.codefish.ui.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;
import java.util.Optional;

public class ProductPage {
    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h5[@class='card-title']")
    List<WebElement> allTitles;

    @FindBy(css = ".card-img-top")
    List<WebElement> allPictures;

    @FindBy(css = ".card-title")
    List<WebElement> allProductNames;

    @FindBy(xpath = "//div[@class='card-body']//p[1]")
    List<WebElement> allProductDescription;

    @FindBy(xpath = "//div[@class='card-body']//p[2]")
    List<WebElement> allPrices;

    @FindBy(xpath = "//div[@class='card-body']//button")
    List<WebElement> allAddToCartButtons;

    @FindBy(xpath = "//div[@class='card-body']//i")
    WebElement checkMark;

    @FindBy(xpath = "//a[.='Cart']")
    WebElement cartButton;

    @FindBy(xpath = "//a[.='chicagoBulls']")
    WebElement chicagoBullsButton;



    public int getProductCount() {
        return allTitles.size();
    }

    public int getPicturesCount(){
        return allPictures.size();
    }

    public int getProductNames(){
        return allProductNames.size();
    }

    public int getAllProductDescription(){
        return allProductDescription.size();
    }

    public int getAllPrices(){
        return allPrices.size();
    }

    public int getAllToCartButtons(){
        return allAddToCartButtons.size();
    }


    //===============================================



    public void addProductToTheCart(String productName, WebDriver driver) throws InterruptedException {

        for (int i = 0; i < allProductNames.size(); i++) {

            if (BrowserUtils.getText(allProductNames.get(i)).contains(productName)) {
                BrowserUtils.scrollWithJS(driver, allAddToCartButtons.get(i));
                Thread.sleep(3000);
                BrowserUtils.clickWithJS(driver, allAddToCartButtons.get(i));

            }
        }


    }

    public void clickCartButton(WebDriver driver) {
       BrowserUtils.clickWithJS(driver,chicagoBullsButton);
        BrowserUtils.clickWithJS(driver,cartButton);
    }

    public void validateCheckMarkIsDisplayed() {

        checkMark.isEnabled();
        checkMark.isDisplayed();
    }


    public void addMultipleProductToTheCart(String firstItem,WebDriver driver) throws InterruptedException {

        for (int i = 0; i < allProductNames.size(); i++) {
            if (BrowserUtils.getText(allProductNames.get(i)).contains(firstItem)) {
                BrowserUtils.scrollWithJS(driver, allAddToCartButtons.get(i));
                Thread.sleep(3000);
                BrowserUtils.clickWithJS(driver, allAddToCartButtons.get(i));

            }
        }
    }










}

