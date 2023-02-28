package com.Luma.Pages;

import com.Actions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankyouPage {

    WebDriver driver;

    SeleniumActions seleniumActions;
    public ThankyouPage(WebDriver driver){
        this.driver = driver;
        seleniumActions = new SeleniumActions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@ class='order-number']")
    WebElement ordernumber;

    public void cilckOnOrderNumber(){
        seleniumActions.clickOnElement(ordernumber);
    }

}
