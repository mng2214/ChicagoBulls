package com.codefish.ui.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='username']")
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//button[@name='loginbtn']")
    WebElement loginButton;
    @FindBy(xpath = "//div[contains(text(),'Authentication failed')]")
    WebElement errorMessage;
    @FindBy(xpath = "//a[.='Logout']")
    WebElement logoutButton;
    @FindBy(xpath = "//button[@name='regbtn']")
    WebElement registerButton;
    @FindBy(xpath = "//a[@href='/profile']")
    WebElement profileButton;


    public void login (String username,String password){
        this.username.clear();
        this.username.sendKeys(username);
        this.password.clear();
        this.password.sendKeys(password);
        loginButton.click();
    }


    public void loginValidateTitle(String expectedTitle, WebDriver driver) {
        Assert.assertEquals(expectedTitle, driver.getTitle().trim());
    }

    public void logout() {
        logoutButton.click();
    }

//    public void loginNegative(String username, String password) {
//        this.username.clear();
//        this.username.sendKeys(username);
//        this.password.clear();
//        this.password.sendKeys(password);
//        loginButton.click();
//    }

    public String loginValidateMessage() {
        return errorMessage.getText();
    }
    public void registerUserFunctionality(){
        this.registerButton.click();
    }

    public String validateProfileName(){
        return this.profileButton.getText().trim();
    }

}


