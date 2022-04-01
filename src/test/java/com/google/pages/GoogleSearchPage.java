package com.google.pages;

import com.google.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    public GoogleSearchPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@title='Search']")
    public WebElement searchBar;

    @FindBy(xpath = "(//h3)[1]")
    public WebElement firstResult;

}
