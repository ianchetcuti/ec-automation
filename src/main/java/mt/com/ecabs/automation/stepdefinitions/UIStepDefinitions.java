package mt.com.ecabs.automation.stepdefinitions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mt.com.ecabs.automation.entities.interfaces.LandingPage;
import mt.com.ecabs.automation.entities.interfaces.LoginPage;
import mt.com.ecabs.automation.entities.pageobjects.Landing;
import mt.com.ecabs.automation.entities.pageobjects.Login;
import mt.com.ecabs.automation.utils.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.util.Locale;

import static org.junit.Assert.assertTrue;

public class UIStepDefinitions {
    private Driver driver = new Driver();

    public UIStepDefinitions(){
        driver.startWebDriver();
    }

    private LandingPage landingPage = new Landing();
    private LoginPage loginPage = new Login();


    @Given("^I access the homepage$")
    public void iAccessTheHomepage() {
        landingPage.get();
    }

    @And("^I click on the sign-in link$")
    public void iClickOnTheSignInLink() {
        landingPage.clickLoginLink();
    }

    @When("^I leave the credentials empty$")
    public void iLeaveTheCredentialsEmpty() {
    }

    @When("^I input empty credentials$")
    public void iInputEmptyCredentials() {
        loginPage.inputUsername("");
        loginPage.inputPassword("");
    }

    @When("^I input the password \"([^\"]*)\"$")
    public void iInputThePassword(String password) throws Throwable {
        loginPage.inputPassword(password);
    }

    @When("^I input the username \"([^\"]*)\"$")
    public void iInputTheUsername(String username) throws Throwable {
        loginPage.inputUsername(username);
    }

    @And("^I click on the sign-in button$")
    public void iClickOnTheSignInButton() {
        loginPage.clickSignIn();
    }

    @Then("^I should get an error \"([^\"]*)\"$")
    public void iShouldGetAnError(String errorMessage) throws Throwable {
        assertTrue(loginPage.returnErrorContainerText().toLowerCase().contains(errorMessage.toLowerCase()));
    }
}
