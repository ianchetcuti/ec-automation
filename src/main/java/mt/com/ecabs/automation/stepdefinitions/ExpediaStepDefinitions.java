package mt.com.ecabs.automation.stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mt.com.ecabs.automation.entities.interfaces.ExpediaPage;
import mt.com.ecabs.automation.entities.pageobjects.Expedia;
import mt.com.ecabs.automation.utils.Driver;

import java.util.HashMap;

public class ExpediaStepDefinitions {

    public ExpediaPage expediaPage = new Expedia();
    public String origAirport = new String();
    public HashMap<String,Integer> itenarary = new HashMap<>();

    private Driver driver = new Driver();

    public ExpediaStepDefinitions(){
        driver.startWebDriver();
    }

    @Given("^I access the expedia flights page$")
    public void iAccessTheExpediaFlightsPage() {
        expediaPage.get();
    }

    @And("^I click on the multi-flight button$")
    public void iClickOnTheMultiFlightButton() {
        expediaPage.clickMultiFlightButton();
    }

    @And("^I add (\\d+) travellers$")
    public void iAddTravellers(int travellers) {
        expediaPage.addTravellers(travellers);
    }

    @And("^I input the first flight origin airport \"([^\"]*)\"$")
    public void iInputTheFirstFlightOriginAirport(String originAirport) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.origAirport = originAirport;
    }

    @And("^I input a flight destination airport \"([^\"]*)\" and date \"([^\"]*)\"$")
    public void iInputAFlightDestinationAirportAndDate(String destinationAirport, String dateInt) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        itenarary.put(destinationAirport,Integer.parseInt(dateInt));
        expediaPage.setFlightItenarary(origAirport,itenarary);
    }

    @When("^I search for flights$")
    public void iSearchForFlights() {
    }

    @Then("^I should get some results$")
    public void iShouldGetSomeResults() {
    }


}
