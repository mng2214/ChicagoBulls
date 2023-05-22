package com.codefish.ui.pages;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

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
    @FindBy(xpath = "//button[.='Vaccines']")
    WebElement vaccinesButton;
    @FindBy(tagName = "h5")
    List<WebElement> listOfCategoryProductsName;
    @FindBy(tagName = "b")
    List<WebElement> listOfCategoryProductPrices;

    @FindBy(xpath = "//button[.='Drugs']")
    WebElement drugsButton;

    @FindBy(xpath = "//button[.='Tools']")
    WebElement toolsButton;
    @FindBy(xpath = "//button[.='Machinery']")
    WebElement machineryButton;



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

    public void categoryProductFunctionality(String category) throws IOException {
        File excelFile=new File("src/test/resources/codefishProject.xlsx");
        FileInputStream fileInputStream=new FileInputStream(excelFile);
        XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);
        Map <String,String> expectedData=new TreeMap<>();
        Map <String,String> actualData=new TreeMap<>();

        switch (category.toLowerCase()){

            case "vaccines":
                XSSFSheet vaccinesPage= workbook.getSheet("vaccines");
                for(int i=vaccinesPage.getFirstRowNum();i<=vaccinesPage.getLastRowNum();i++){
                    XSSFRow currentRow=vaccinesPage.getRow(i);
                    for(int k=currentRow.getFirstCellNum();k<= currentRow.getLastCellNum();k++){
                        expectedData.put(String.valueOf(currentRow.getCell(0)),String.valueOf(currentRow.getCell(1)));
                    }
                }
                this.vaccinesButton.click();
                for(int i=0;i<listOfCategoryProductsName.size();i++){
                    actualData.put(listOfCategoryProductsName.get(i).getText().trim(),listOfCategoryProductPrices.get(i).getText().trim());
                }
                Assert.assertEquals(expectedData,actualData);
                break;
            case "drugs":
                XSSFSheet drugs= workbook.getSheet("Drugs");
                for(int i=drugs.getFirstRowNum();i<=drugs.getLastRowNum();i++){
                    XSSFRow currentRow=drugs.getRow(i);
                    for(int k=currentRow.getFirstCellNum();k<= currentRow.getLastCellNum();k++){
                        expectedData.put(String.valueOf(currentRow.getCell(0)),String.valueOf(currentRow.getCell(1)));
                    }
                }
                this.drugsButton.click();
                for(int i=0;i<listOfCategoryProductsName.size();i++){
                    actualData.put(listOfCategoryProductsName.get(i).getText().trim(),listOfCategoryProductPrices.get(i).getText().trim());
                }
                Assert.assertEquals(expectedData,actualData);
                break;
            case "tools":
                XSSFSheet tools= workbook.getSheet("Tools");
                for(int i=tools.getFirstRowNum();i<=tools.getLastRowNum();i++){
                    XSSFRow currentRow=tools.getRow(i);
                    for(int k=currentRow.getFirstCellNum();k<= currentRow.getLastCellNum();k++){
                        expectedData.put(String.valueOf(currentRow.getCell(0)),String.valueOf(currentRow.getCell(1)));
                    }
                }
                this.toolsButton.click();
                for(int i=0;i<listOfCategoryProductsName.size();i++){
                    actualData.put(listOfCategoryProductsName.get(i).getText().trim(),listOfCategoryProductPrices.get(i).getText().trim());
                }
                Assert.assertEquals(expectedData,actualData);
                break;
            case "machinery":
                XSSFSheet machinery= workbook.getSheet("Machinery");
                for(int i=machinery.getFirstRowNum();i<=machinery.getLastRowNum();i++){
                    XSSFRow currentRow=machinery.getRow(i);
                    for(int k=currentRow.getFirstCellNum();k<= currentRow.getLastCellNum();k++){
                        expectedData.put(String.valueOf(currentRow.getCell(0)),String.valueOf(currentRow.getCell(1)));
                    }
                }
                this.machineryButton.click();
                for(int i=0;i<listOfCategoryProductsName.size();i++){
                    actualData.put(listOfCategoryProductsName.get(i).getText().trim(),listOfCategoryProductPrices.get(i).getText().trim());
                }
                Assert.assertEquals(expectedData,actualData);
                break;
        }


    }










}

