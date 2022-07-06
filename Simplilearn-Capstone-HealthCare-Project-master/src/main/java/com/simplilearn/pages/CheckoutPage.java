package com.simplilearn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends  BasePage{

    private By removeproduct = By.xpath("//a[@class='btn btn-danger btn-sm']");
    private By checkout = By.xpath("//a[normalize-space()='Checkout']");
    private By selectaddress = By.xpath("//a[normalize-space()='Select']");
    private By txt_cardnumber = By.id("cardNumber");
    private By txt_expiryMonth = By.id("expityMonth");
    private By txt_expiryyear = By.id("expityYear");
    private By txt_cvvcode = By.id("cvCode");
    private By pay = By.linkText("Pay");
    private By txt_orderconfirmation = By.xpath("//h3[normalize-space()='Your Order is Confirmed!!']");


    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickremoveproductbutton(){
        click(removeproduct);
    }

    public void clickcheckoutbutton(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(checkout));
        click(checkout);
    }

    public void clickselectaddressbutton(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(selectaddress));
        click(selectaddress);
    }

    public void setCardnumber(String _cardnumber){
        sendKeysValue(txt_cardnumber, _cardnumber);
    }

    public void setExpiryMonth(String _expirymonth){
        sendKeysValue(txt_expiryMonth, _expirymonth);
    }

    public void setexpiryyear(String _expiryyear){
        sendKeysValue(txt_expiryyear, _expiryyear);
    }

    public void setcvvcode(String _cvvcode){
        sendKeysValue(txt_cvvcode, _cvvcode);
    }

    public void clickpaybutton(){
        click(pay);
    }

    public String getorderconfirmation(){
        return getKeyValue(txt_orderconfirmation);
    }

}
