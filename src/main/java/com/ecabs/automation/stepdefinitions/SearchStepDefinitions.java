package com.ecabs.automation.stepdefinitions;

import com.ecabs.automation.entities.interfaces.LandingPage;
import com.ecabs.automation.entities.pageobjects.Landing;
import com.ecabs.automation.utils.Driver;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchStepDefinitions {

    private LandingPage landingPage = new Landing();

    @Given("^I access the askgamblers website and I input \"([^\"]*)\"$")
    public void iAccessTheAskgamblersWebsiteAndIInput(String searchTerm) throws Throwable {
        Driver.startWebDriver();
        landingPage.get();
        landingPage.enterSearch(searchTerm);
    }

    @When("^I click on the Search button$")
    public void iClickOnTheSearchButton() {
        landingPage.clickSearch();
    }

    @Then("^I should be redirected to the results page$")
    public void iShouldBeRedirectedToTheResultsPage() {

    }

    @And("^I should be able to verify the \"([^\"]*)\"$")
    public void iShouldBeAbleToVerifyThe(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I access the askgamblers website and I click on complaints$")
    public void iAccessTheAskgamblersWebsiteAndIClickOnComplaints() {
        Driver.startWebDriver();
        landingPage.get();
        landingPage.clickComplaints();
    }

    @When("^I am redirected to the page$")
    public void iAmRedirectedToThePage() {
    }

    @Then("^I should be able to see the complaints$")
    public void iShouldBeAbleToSeeTheComplaints() {
    }

    @Given("^I access the askgamblers website and I click on button \"([^\"]*)\"$")
    public void iAccessTheAskgamblersWebsiteAndIClickOnButton(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Driver.startWebDriver();
        landingPage.get();
        landingPage.clickComplaints();
    }

    @Then("^I go back to the landing page$")
    public void iGoBackToTheLandingPage() {
        landingPage.get();
    }
}
