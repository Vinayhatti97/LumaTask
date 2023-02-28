package com.Luma.Pages;

import com.Actions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewAndPaymentsPage {

    WebDriver driver;
    SeleniumActions seleniumActions;
    public ReviewAndPaymentsPage(WebDriver driver){
    this.driver= driver;
    PageFactory.initElements(driver, this);
    seleniumActions = new SeleniumActions(driver);
    }

    @FindBy(xpath = "//button[@ class ='action primary checkout']")
    WebElement placeorder;

    public void clickOnPlacorder(){
        seleniumActions.javaScriptExcecutorClick(placeorder, driver);
    }

}
