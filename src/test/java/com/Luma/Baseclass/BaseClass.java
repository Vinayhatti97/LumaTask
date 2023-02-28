package com.Luma.Baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseClass {
        public WebDriver driver;
        DesiredCapabilities desiredCapabilities;
        ChromeOptions chromeOptions;
        EdgeOptions edgeOptions;


        @Parameters({"browserName","serverlink"})
        @BeforeTest
        public void OpenbrowserAndLaunchapp(String browserName,@Optional("")String  serverlink) throws MalformedURLException {
            switch(browserName.toLowerCase()) {
                case "chrome":
                    //driver = new ChromeDriver();
                    desiredCapabilities = new DesiredCapabilities();
                    chromeOptions = new ChromeOptions();
                    desiredCapabilities.setCapability("browser","chrome");
                    desiredCapabilities.merge(chromeOptions);
                    driver = new RemoteWebDriver(new URL(serverlink),chromeOptions);
                    // driver.manage().window().setSize(new Dimension(0,500));
                    break;
                case "edge":
                    //driver = new EdgeDriver();
                    desiredCapabilities = new DesiredCapabilities();
                    edgeOptions = new EdgeOptions();
                    desiredCapabilities.setCapability("browser","edge");
                    desiredCapabilities.merge(edgeOptions);
                    driver = new RemoteWebDriver(new URL(serverlink),edgeOptions);
                    //driver.manage().window().setPosition(new Point(400,400));
                    //driver.manage().window().setSize(new Dimension(100,500));
                    break;
                default	:
                    System.out.println("Browser name is invalid");
                    break;
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
        }

        //@AfterTest
       // public void closebrowser() {
         //   driver.quit();
        //}
}

