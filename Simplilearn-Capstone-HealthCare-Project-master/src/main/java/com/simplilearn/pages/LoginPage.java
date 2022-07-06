package com.simplilearn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{

    private By txt_username = By.id("username");
    private By txt_password = By.id("password");
    private By login = By.xpath("//input[@class=\"btn btn-primary\"]");
    private By registerhere = By.cssSelector("a[href='/medicare/membership']");
    private By fullname = By.id("userModel");
    private By invalidmessage = By.xpath("//div[@class='alert alert-danger fade in']");
    private By dropdown = By.xpath("//a[@class='btn btn-default dropdown-toggle']");
    private By logout = By.id("logout");
    private By loggedoutmessage = By.xpath("//div[@class='alert alert-success']");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public void clickLoginButton(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(login));
        click(login);
    }

    public void setUsername(String _username){
        sendKeysValue(txt_username, _username);
    }

    public void setPassword(String _password){
        sendKeysValue(txt_password, _password);
    }

    public String getusername(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(fullname));
        return getKeyValue(fullname);
    }

    public String getinvalidmessage(){
        return getKeyValue(invalidmessage);
    }

    public void clickdropdown(){
        click(dropdown);
    }

    public void clicklogout(){
        click(logout);
    }
}
