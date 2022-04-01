package com.google.step_definitions;

import com.google.pages.GoogleSearchPage;
import com.google.utils.ConfigurationReader;
import com.google.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SearchRTSLabs_StepDefs {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @Given("the user is on the google search page")
    public void the_user_is_on_the_google_search_page() {
        //Navigate to “www.google.com”
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        //Verify that we are on Google page
        Assert.assertEquals("Google", Driver.getDriver().getTitle());
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String input) {
        //Select the Main Search Box and enter the text “RTS Labs”
        //and press the Enter key to execute the search and await the results
        googleSearchPage.searchBar.sendKeys(input + Keys.ENTER);
    }

    @When("the user clicks on the first result")
    public void the_user_clicks_on_the_first_result() {
        //Click the first result URL from the search (Normally this will be the RTS Website)
        googleSearchPage.firstResult.click();
    }

    @Then("the user should see the main page of the {string} website")
    public void the_user_should_see_the_main_page_of_the_website(String expectedName) {
        /*
        I decided to add this step to verify that the user is on the RTS Labs website.
        In order to do that I need to find a WebElement that has "RTS Labs" text in it.
        I decided to use Copyright WebElement from the bottom of the page, because it shouldn't change with time, and it contains "RTS Labs" text.
         */
        String copyrightNote = Driver.getDriver().findElement(By.cssSelector("p[class='copyright']")).getText();
        Assert.assertTrue(copyrightNote.contains(expectedName));
        Driver.getDriver().quit();
    }



}
