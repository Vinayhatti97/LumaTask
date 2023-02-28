package com.Luma.TestLuma;

import com.Luma.Baseclass.BaseClass;
import com.Luma.Pages.*;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestLuma  extends BaseClass {

    BagsPage bagsPage;
    LoginPage loginPage;
    LumaHomePage lumaHomePage;
    WishListPage wishListPage;

    ReviewAndPaymentsPage reviewAndPaymentsPage;
    ShipingAddressPage shipingAddressPage;

    ThankyouPage thankyouPage;
    @BeforeClass
    public void initializePages(){
        loginPage = new LoginPage(driver);
        lumaHomePage = new LumaHomePage(driver);
        bagsPage = new BagsPage(driver);
        wishListPage = new WishListPage(driver);
        shipingAddressPage = new ShipingAddressPage(driver);
        reviewAndPaymentsPage = new ReviewAndPaymentsPage(driver);
        thankyouPage = new ThankyouPage(driver);
    }

    @Test
    public void luanchApp(){
        driver.get("https://magento.softwaretestingboard.com/customer/account/");
    }

    @Parameters({"email","password"})
    @Test
    public void entoEndTestLuma(String email, String password) throws IOException, ParseException, InterruptedException {
        loginPage.loginLuma("vinayhatti5@gmail.com","ViN@19619541");
        lumaHomePage.navigateTobagsPage();
        lumaHomePage.clickOnCartIcon();
        WebElement textincart = driver.findElement(By.xpath("//div[@data-role='dropdownDialog']/div/div/following-sibling::div/strong"));
        System.out.println(textincart.getText());
        Assert.assertTrue(textincart.isDisplayed());
        String nameofiteminbagspage = bagsPage.getNameOfItem(bagsPage.getHighestPrice());
        System.out.println("Item name in the cart "+bagsPage.getNameOfItem(bagsPage.getHighestPrice()));
        bagsPage.addItemToWishList(bagsPage.getNameOfItem(bagsPage.getHighestPrice()));
        String  itemnameinwishlist = driver.findElement(By.xpath("//*[@class='page-title-wrapper']/following-sibling::form/descendant::strong/a")).getText();
        System.out.println(itemnameinwishlist);
        Assert.assertEquals(nameofiteminbagspage,itemnameinwishlist);
        Thread.sleep(1000);
        wishListPage.addtoCartItemFromWishList(nameofiteminbagspage);
        WebElement msginwishlish = driver.findElement(By.xpath("//div[@ class='message info empty']"));
        Assert.assertTrue(msginwishlish.isDisplayed());
        wishListPage.clickOnCartAndProceedtoCheckout();
        try {
            shipingAddressPage.fillShippingAddressClickOnNext();
        }catch (Exception nse) {
            shipingAddressPage.clickOnNext();
        }
        WebElement addressdetails = driver.findElement(By.xpath("//div[@ class='checkout-billing-address']"));
        Assert.assertTrue(addressdetails.isDisplayed());
        reviewAndPaymentsPage.clickOnPlacorder();
        thankyouPage.cilckOnOrderNumber();
        WebElement orderheading = driver.findElement(By.xpath("//h1"));
        Assert.assertTrue(orderheading.isDisplayed());
    }
//
//    @Parameters({"email","password"})
//    @Test
//    public void verifyWishListItemDetails (String email, String password){
//        loginPage.loginLuma("vinayhatti5@gmail.com","ViN@19619541");
//        lumaHomePage.navigateTobagsPage();
//        String nameofiteminbagspage = bagsPage.getNameOfItem(bagsPage.getHighestPrice());
//        System.out.println("Item name in the cart"+bagsPage.getNameOfItem(bagsPage.getHighestPrice()));
//        bagsPage.addItemToWishList(bagsPage.getNameOfItem(bagsPage.getHighestPrice()));
//        String  itemnameinwishlist = driver.findElement(By.xpath("//span[@ data-bind='text: product_name']")).getText();
//        System.out.println(itemnameinwishlist);
//        //Assert.assertEquals(nameofiteminbagspage,itemnameinwishlist);
//
//        //div[@ class ='product-item-details']/strong[@ class ='product-item-name']/a/span
//    }
//    @Parameters({"email", "password"})
//    @Test
//    public void verifyNoItemsInWishlist() throws IOException, ParseException {
//        loginPage.loginLuma("vinayhatti5@gmail.com","ViN@19619541");
//        lumaHomePage.navigateTobagsPage();
//        System.out.println("Item name in the cart"+bagsPage.getNameOfItem(bagsPage.getHighestPrice()));
//        bagsPage.addItemToWishList(bagsPage.getNameOfItem(bagsPage.getHighestPrice()));
//        wishListPage.addtoCartItemFromWishList(bagsPage.getNameOfItem(bagsPage.getHighestPrice()));
//        WebElement msginwishlish = driver.findElement(By.xpath("//div[@ class='message info empty']"));
//        Assert.assertTrue(msginwishlish.isDisplayed());
//        wishListPage.clickOnCartAndProceedtoCheckout();
//        shipingAddressPage.fillShippingAddress();
//
//    }






}
