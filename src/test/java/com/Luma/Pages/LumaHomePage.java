package com.Luma.Pages;

import com.Actions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.XMLFormatter;

public class LumaHomePage {

    WebDriver driver;
    SeleniumActions seleniumActions;
    public LumaHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        seleniumActions = new SeleniumActions(driver);
    }


    @FindBy(xpath = "//span[.='Gear']/preceding-sibling::span/parent::a")
    WebElement gearlink;

    @FindBy(xpath = "//span[.='Bags']/parent::a")
    WebElement Bagslink;

    @FindBy(xpath = "//a[@ class='action showcart']")
    WebElement carticon;


    public void navigateTobagsPage(){
        seleniumActions.hoverOnElement(gearlink);
        seleniumActions.clickByAction(Bagslink);
    }

    public void clickOnCartIcon(){
        seleniumActions.clickOnElement(carticon);
    }
}
