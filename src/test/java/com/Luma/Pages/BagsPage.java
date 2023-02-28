package com.Luma.Pages;

import com.Actions.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BagsPage {
    WebDriver driver;

    SeleniumActions seleniumActions;
    public BagsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        seleniumActions = new SeleniumActions(driver);
    }



    public String getHighestPrice(){
        List<WebElement> listofprices =driver.findElements(By.xpath("//span[@ data-price-type='finalPrice']/span"));
        List<Float> allprices = new ArrayList<>();

        for(WebElement element : listofprices){
            allprices.add(Float.parseFloat(element.getText().replace("$","")));
        }
        Float highestprice = Collections.max(allprices);
        String highestpriceinstring =highestprice.toString();
        System.out.println("Highest price in cart:: "+highestpriceinstring);
        return highestpriceinstring;
    }

    public String getNameOfItem(String price){
        String nameofitem = driver.findElement(By.xpath("//span[@ data-price-type='finalPrice']/span[contains(.,'"+price+"')]/parent::span/parent::span/parent::div/preceding-sibling::strong/a")).getText();
        return nameofitem;
    }

    public void addItemToWishList(String name){
        WebElement itemimage = driver.findElement(By.xpath("//img[@ class ='product-image-photo']/parent::span/parent::span/parent::a/following-sibling::div/strong/a[contains(.,'"+name+"')]"));
        seleniumActions.hoverOnElement(itemimage);
    WebElement wishlistbutton = driver.findElement(By.xpath("//a[contains(.,'"+name+"')]/parent::strong[@ class = 'product name product-item-name']/following-sibling::div/following-sibling::div/following-sibling::div/div/div/a[1]"));
    seleniumActions.clickByAction(wishlistbutton);
    }
}
