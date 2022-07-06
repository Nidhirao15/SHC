package com.simplilearn.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ManageProductPage extends BasePage{

    private By productname = By.xpath("//input[@id=\"name\" and @placeholder = \"Product Name\"]");
    private By brandname = By.id("brand");
    private By branddescription = By.xpath("//div[@class=\"col-md-8\"]//textarea[@id=\"description\"]");
    private By unitprice = By.id("unitPrice");
    private By quantity = By.id("quantity");
    private By uploadfile = By.xpath("//input[@id=\"file\"]");
    private By category = By.id("categoryId");

    private By addnewcategory = By.xpath("//button[normalize-space()='Add New Category']");
    private By newcategoryname = By.xpath("//div[@class='col-md-8 validate']//input[@id='name']");
    private By newcategorydescription = By.xpath("//div[@class='col-md-8 validate']//textarea[@id='description']");
    private By savecategory = By.xpath("//form[@id='categoryForm']//input[@name='submit']");
    private By categorymessage = By.xpath("//div[@class='col-xs-12 col-md-offset-2 col-md-8']");

    private By saveproduct = By.xpath("(//input[@name='submit'])[1]");    //index xpath
    private By alertmessage = By.xpath("//div[@class='col-xs-12 col-md-offset-2 col-md-8']");
    private By search = By.xpath("//input[@type='search']");
    private By editbutton = By.xpath("//a[@class='btn btn-primary']");
    private By activateproductbutton = By.xpath("//div[@class='slider round']");

    private By activateOK  = By.xpath("//button[@data-bb-handler=\"confirm\"]");
    private By activatecancel = By.xpath("//button[@data-bb-handler=\"cancel\"]");
    private By activationmessage = By.xpath("//div[@class='bootbox-body']");
    private By activeOK2 = By.xpath("//button[@data-bb-handler=\"ok\"]");
    private By activationmessage2 = By.xpath("//div[@class='bootbox modal fade bootbox-alert in']//div[@class='modal-body']");

    public ManageProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void setProductName(String _productname){
        sendKeysValue(productname, _productname);
    }

    public void setBrandname(String _brandname){
        sendKeysValue(brandname, _brandname);
    }

    public void setBranddescription(String _description){
        sendKeysValue(branddescription, _description);
    }

    public void setUnitprice(String _unitprice){
        clearText(unitprice);
        sendKeysValue(unitprice, _unitprice);
    }

    public void setQuantity(String _quantity){
        clearText(quantity);
        sendKeysValue(quantity, _quantity);
    }

    public void setUploadfile(String _file){
        sendKeysValue(uploadfile, _file);
    }

    public void setCategory(String _category){
        sendKeysValue(category, _category);
    }

    public void clickSave(){
        click(saveproduct);
    }

    public void setSearch(String _searchtext){
        sendKeysValue(search, _searchtext);
    }

    public void clickEditbutton(){
        click(editbutton);
    }

    public void clickActivatebutton(){
        click(activateproductbutton);
    }

    public void clickactivatedeactivatebutton(){
        click(activateOK);
    }

    public void clickactivatedeactivatecancelbutton(){
        click(activatecancel);
    }

    public String getactivationmessage(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(activationmessage));
        return getKeyValue(activationmessage);
    }

    public String getactivationmessage2(){
        applyingExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(activationmessage2));
        return getKeyValue(activationmessage2);
    }

    public void clickactivationOK(){

        click(activeOK2);
    }

    public String getAlertMessage(){
        return getKeyValue(alertmessage);
    }

    public void clickAddNewCategory(){
        click(addnewcategory);
    }

    public void setCategoryName(String _categoryname){
        sendKeysValue(newcategoryname, _categoryname);
    }

    public void setCategoryDescription(String _categoryDesp){
        sendKeysValue(newcategorydescription, _categoryDesp);
    }

    public void clickSaveCategory(){
        click(savecategory);
    }

    public String getCategoryAddedmessage(){
        return getKeyValue(categorymessage);
    }

}
