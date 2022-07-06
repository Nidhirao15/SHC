package com.simplilearn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    private By signup = By.id("signup");
    private By login = By.id("login");
    private By viewproducts = By.id("listProducts");
    private By contact = By.id("contact");
    private By about = By.id("about");
    private By medicare = By.xpath("//a[@class=\"navbar-brand\"]");
    private By logout = By.id("logout");
    private By cart = By.id("cart");
    private By manageproduct = By.id("manageProduct");
    private By dropdown = By.xpath("//a[@class='btn btn-default dropdown-toggle']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignup() {
        click(signup);
    }

    public void clickLogin(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(login));
        click(login);
    }

    public void clickViewProducts(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(viewproducts));
        click(viewproducts);
    }

    public void clickMedicare(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(medicare));
        click(medicare);
    }

    public void clickManageProduct(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(manageproduct));
        click(manageproduct);
    }

}
