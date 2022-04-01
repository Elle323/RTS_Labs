package com.google.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating the private constructor so this class' object
    is not reachable from outside
     */
    private Driver(){}

    /*
    I made my 'driver' instance private so that it is not reachable from outside the class.
    I also made it static, because I want it to run before everything else, and so I could use it in a static method
     */
    private static WebDriver driver;

    /*
    Creating re-usable utility method that will return the same 'driver' instance everytime I call it.
     */
    public static WebDriver getDriver(){

        if (driver == null){

            /*
            The browser type is defined in configuration.properties file.
            The ConfigurationReader class will read the type by using .getProperty method.
             */

            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Switch statement will determine which browser to open
             */
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    //driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }

        /*
        Same driver instance will be returned every time I call Driver.getDriver(); method
         */
        return driver;
    }

    /*
    This method makes sure I have some form of driver session or driver id.
     */
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
