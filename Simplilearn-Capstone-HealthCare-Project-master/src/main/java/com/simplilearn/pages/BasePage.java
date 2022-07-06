package com.simplilearn.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    WebDriver driver;

    public WebDriverWait applyingExplicitWait(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        return wait;
    }

    public void click(By byObject) {
        driver.findElement(byObject).click();
    }

    public void sendKeysValue(By byObject, String data){
        driver.findElement(byObject).sendKeys(data);
    }

    public void clearText(By byObject){
        driver.findElement(byObject).clear();
    }

    public String getKeyValue(By byObject){
       return driver.findElement(byObject).getText();
    }

    public List<WebElement> getListofKeyValues(By byObject){
        return  driver.findElements(byObject);
    }

}
