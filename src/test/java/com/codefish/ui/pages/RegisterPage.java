package com.codefish.ui.pages;

import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class RegisterPage {
    public RegisterPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name='username']") //chicagoBulls
    WebElement username;
    @FindBy(xpath = "//input[@name='password']") //12345
    WebElement password;
    @FindBy(xpath = "//button[contains(text(),'Register')]")
    WebElement registerButton;

    @FindBy(xpath = "//div[contains(text(),'already taken')]")
    WebElement alreadyRegisteredErrorMessage;

    @FindBy(xpath = "//input[@type = 'checkbox']")
    WebElement checkBoxAdmin;

    public void registerUser(String newUsername,String newPassword){
        this.username.clear();
        this.username.sendKeys(newUsername);
        this.password.clear();
        this.password.sendKeys(newPassword);
        if(checkBoxAdmin.isDisplayed() && checkBoxAdmin.isEnabled() && !checkBoxAdmin.isSelected()){
            checkBoxAdmin.click();
        }
        registerButton.click();
    }

    public String registeredUserValidation () {
        return BrowserUtils.getText(alreadyRegisteredErrorMessage);
    }
}
