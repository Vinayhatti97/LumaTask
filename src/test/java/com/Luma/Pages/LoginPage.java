package com.Luma.Pages;

import com.Actions.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    SeleniumActions seleniumActions;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    seleniumActions = new SeleniumActions(driver);
    }

    @FindBy(id = "email")
    WebElement emailtextfield;

    @FindBy(id="pass")
    WebElement passwordtextfield;

    @FindBy(xpath = "//button[@ class='action login primary']")
    WebElement signinbutton;

    public void loginLuma(String  email, String password){
        seleniumActions.EnterValueOnTextfield(emailtextfield,email);
        seleniumActions.EnterValueOnTextfield(passwordtextfield, password);
        seleniumActions.clickOnElement(signinbutton);
    }


}
