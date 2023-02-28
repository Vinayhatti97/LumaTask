package com.Luma.Pages;

import com.Actions.SeleniumActions;
import com.Readfromfile.Readfromjson;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.io.IOException;

public class ShipingAddressPage {
    WebDriver driver;
    SeleniumActions seleniumActions;
    Readfromjson readfromjson;
    public ShipingAddressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumActions = new SeleniumActions(driver);
        readfromjson = new Readfromjson();
    }

    @FindBy (xpath = "//input[@ name='company']")
    WebElement companytextfield;

    @FindBy (xpath ="//input[@ name='street[0]']")
    WebElement addressline1;

    @FindBy(xpath = "//input[@ name='street[1]']")
    WebElement addressline2;

    @FindBy(xpath = "//input[@ name='street[2]']")
    WebElement addressline3;

    @FindBy(xpath = "//input[@ name='city']")
    WebElement citytextfield;

    @FindBy(xpath = "//select[@ name='region_id']")
    WebElement statedropdown;
    @FindBy(xpath = "//input[@ name='postcode']")
    WebElement postcodetextfield;

    @FindBy(xpath = "//select[@ name='country_id']")
    WebElement countrydropdown;

    @FindBy(xpath = "//input[@ name='telephone']")
    WebElement phonenumbertextfield;

    @FindBy(xpath = "//span[.='Next']/..")
    WebElement nextbutton;

    public void fillShippingAddressClickOnNext() throws IOException, ParseException {
    seleniumActions.EnterValueOnTextfield(companytextfield,readfromjson.readFile("company") );
    seleniumActions.EnterValueOnTextfield(addressline1, readfromjson.readFile("address1"));
    seleniumActions.EnterValueOnTextfield(addressline2, readfromjson.readFile("address2"));
    seleniumActions.EnterValueOnTextfield(addressline3, readfromjson.readFile("address3"));
    seleniumActions.EnterValueOnTextfield(citytextfield,readfromjson.readFile("city"));
    seleniumActions.selectValueFromDropDown(countrydropdown,readfromjson.readFile("countryvalue"),"value");
    seleniumActions.selectValueFromDropDown(statedropdown,readfromjson.readFile("statevalue"), "value");
    seleniumActions.EnterValueOnTextfield(postcodetextfield,readfromjson.readFile("postcode"));
    seleniumActions.EnterValueOnTextfield(phonenumbertextfield,readfromjson.readFile("phone"));
    seleniumActions.clickOnElement(nextbutton);
    }

    public void clickOnNext(){
        seleniumActions.waitandClickElement(nextbutton);
    }
}
