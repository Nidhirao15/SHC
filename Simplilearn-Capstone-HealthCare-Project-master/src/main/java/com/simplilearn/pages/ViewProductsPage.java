package com.simplilearn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ViewProductsPage extends BasePage{

    private By categorieslist = By.xpath("//a[@class='list-group-item']");
    private By antipyretics = By.id("a_Antipyretics");
    private By analgesics = By.id("a_Analgesics");
    private By antibiotics = By.id("a_Antibiotics");
    private By painreliever = By.id("a_Plain Reliever");
    private By search = By.xpath("//input[@type='search']");
    private By showproduct1 = By.cssSelector("a[href='/medicare/show/1/product']");
    private By manageproduct1 = By.cssSelector("a[href='/medicare/manage/1/product']");
    private By continueshopping = By.partialLinkText("Continue Shoppi");
    private By addproducttocart = By.xpath("//tr[@class='odd']//a[@class='btn btn-success']");
    private By sortedproductname = By.xpath("//td[normalize-space()='Paracetamol']");


    public ViewProductsPage(WebDriver driver){
        this.driver = driver;
    }

    public void setSearch(String _search){
        sendKeysValue(search, _search);
    }

    public String getproductname(){
        return getKeyValue(sortedproductname);
    }

    public void clickaddproducttocart(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(addproducttocart));
        click(addproducttocart);
    }

}
