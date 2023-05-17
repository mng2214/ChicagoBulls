package com.codefish.ui.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    List<WebElement> allPrice;

    @FindBy(xpath = "//div[@class='card-body']//button")
    List<WebElement> allAddToCartButtons;



}
