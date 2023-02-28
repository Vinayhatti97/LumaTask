package com.Luma.Pages;

import com.Actions.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
    WebDriver driver;
    SeleniumActions seleniumActions;
    public WishListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        seleniumActions = new SeleniumActions(driver);
    }

    @FindBy(xpath = "//div/div[@data-block='minicart']")
    WebElement carticoninwsihlist;

    @FindBy(id = "top-cart-btn-checkout")
    WebElement proceedtocheckoutbutton;

    public void addtoCartItemFromWishList(String name){
        WebElement iteminWishlist = driver.findElement(By.xpath("//span[contains(.,'"+name+"')]/parent::a/parent::strong/parent::div[@ class ='product-item-details']/strong[@ class ='product-item-name']/a/span/parent::a/parent::strong/following-sibling::div/following-sibling::div/div/button"));
        seleniumActions.waitandClickElement(iteminWishlist);
    }

    public void clickOnCartAndProceedtoCheckout() throws InterruptedException {
        Thread.sleep(2000);
        seleniumActions.clickOnElement(carticoninwsihlist);
        seleniumActions.clickByAction(proceedtocheckoutbutton);
    }
}
