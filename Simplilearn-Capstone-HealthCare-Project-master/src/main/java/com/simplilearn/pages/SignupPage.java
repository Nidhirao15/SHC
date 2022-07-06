package com.simplilearn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignupPage extends BasePage{

    private By firstname = By.id("firstName");
    private By lastname = By.id("lastName");
    private By email = By.id("email");
    private By contactnumber = By.id("contactNumber");
    private By password = By.id("password");
    private By confirmpassword = By.id("confirmPassword");
    private By userrole = By.id("role1");
    private By supplierrole = By.id("role2");
    private By nextbillingbutton = By.xpath("//button[@class=\"btn btn-primary\"]");
    private By addresslineone = By.id("addressLineOne");
    private By addresslinetwo = By.id("addressLineTwo");
    private By city = By.id("city");
    private By postalcode = By.id("postalCode");
    private By state = By.id("state");
    private By country = By.id("country");
    private By nextconfirmbutton = By.xpath("//button[@name=\"_eventId_confirm\"]");
    private By backpersonalbutton = By.xpath("//button[@name=\"_eventId_personal\"]");
    private By confirmbutton = By.xpath("//a[normalize-space()='Confirm']");
    private By welcometext = By.xpath("//h1[normalize-space()='Welcome!']");


    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstname(String _firstname) {
        sendKeysValue(firstname, _firstname);
    }

    public void setLastname(String _lastname){
        sendKeysValue(lastname, _lastname);
    }

    public void setEmail(String _email){
        sendKeysValue(email, _email);
    }

    public void setPassword(String _password){
        sendKeysValue(password, _password);
    }

    public void setConfirmpassword(String _confirmpassword){
        sendKeysValue(confirmpassword, _confirmpassword);
    }

    public void setContactnumber(String _contact){
        sendKeysValue(contactnumber, _contact);
    }

    public void setrole(String _role){
        if(_role == "USER"){
            click(userrole);
        }else{
            click(supplierrole);
        }
    }

    public void setAddresslineone(String _addressline1){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(addresslineone));
        sendKeysValue(addresslineone, _addressline1);
    }

    public void setAddresslinetwo(String _addressline2){
        sendKeysValue(addresslinetwo, _addressline2);
    }

    public void setCity(String _city){
        sendKeysValue(city, _city);
    }

    public void setPostalcode(String _postalcode){
        sendKeysValue(postalcode, _postalcode);
    }

    public void setState(String _state){
        sendKeysValue(state, _state);
    }

    public void setCountry(String _country){
        sendKeysValue(country, _country);
    }

    public void clickNextconfirmbutton(){
        click(nextconfirmbutton);
    }

    public void clicknextbillingbutton(){
        click(nextbillingbutton);
    }

    public void clickconfirmbutton(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(confirmbutton));
        click(confirmbutton);
    }

    public String getWelcomemesage(){
       return getKeyValue(welcometext);
    }
}
