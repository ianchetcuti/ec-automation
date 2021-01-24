package mt.com.ecabs.automation.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import mt.com.ecabs.automation.utils.HttpRequest;
import mt.com.ecabs.automation.utils.HttpResponse;
import org.apache.commons.lang3.math.NumberUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.commons.validator.routines.EmailValidator;
import static org.junit.Assert.assertTrue;

public class ApiStepDefinitions {

    private HttpRequest httpRequest = new HttpRequest();
    private HttpResponse httpResponse = new HttpResponse();

    String uri = null;
    String verb = null;
    JSONObject body = new JSONObject();

    @Given("^I create a \"([^\"]*)\" request on \"([^\"]*)\"$")
    public void iCreateARequestOn(String verb, String uri) throws Throwable {
        this.verb = verb;
        this.uri = uri;
    }

    @When("^I input an e-mail address \"([^\"]*)\"$")
    public void iInputAnEMailAddress(String email) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        body.put("email",email);
    }

    @And("^I input a password \"([^\"]*)\"$")
    public void iInputAPassword(String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        body.put("password",password);
    }

    @And("^I send the request$")
    public void iSendTheRequest() {
        httpResponse = httpRequest.sendHttpRequest(this.uri,this.verb,this.body);
    }

    @Then("^I should be able to register a user successfully$")
    public void iShouldBeAbleToRegisterAUserSuccessfully() {
        assertTrue(httpResponse.getHttpCode() == 200);
        assertTrue(httpResponse.getBody().getObject().get("id") != null);
        assertTrue(httpResponse.getBody().getObject().get("token") != null);
    }


    @Then("^I should get a missing password error$")
    public void iShouldGetAnError() {
        assertTrue(httpResponse.getHttpCode() == 400);
        assertTrue(httpResponse.getBody().getObject().get("error").toString().equalsIgnoreCase("Missing password"));
    }

    @Then("^I should get a list of users$")
    public void iShouldGetAListOfUsers() {
        assertTrue(httpResponse.getHttpCode() == 200);
        // retrieve the parsed JSONObject from the response
        JSONObject obj = new JSONObject(httpResponse.getBody().toString());
        JSONArray arr = obj.getJSONArray("data");

        assertTrue(arr.length() > 0);

        for(Object o: arr){
            JSONObject user = new JSONObject(o.toString());
            assertTrue(NumberUtils.isCreatable(user.get("id").toString()));
            assertTrue(user.get("first_name")!=null);
            assertTrue(user.get("last_name")!=null);
            assertTrue(EmailValidator.getInstance().isValid(user.get("email").toString()));
        }
    }
}
