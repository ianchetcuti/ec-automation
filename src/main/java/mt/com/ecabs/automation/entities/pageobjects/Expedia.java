package mt.com.ecabs.automation.entities.pageobjects;

import mt.com.ecabs.automation.entities.interfaces.ExpediaPage;
import mt.com.ecabs.automation.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Expedia implements ExpediaPage {

    // Start elements.
    private By multiFlightButton = By.xpath("//a[contains(@aria-controls, 'wizard-flight-tab-multicity')]");
    private By travellersButton = By.xpath("//a[contains(@data-testid, 'travelers-field')]");
    private By addTraveller = By.xpath("//*[@id=\"adaptive-menu\"]/div/div/section/div[1]/div[1]/div/button[2]");
    private By flightDetailButton = By.className("uitk-faux-input");

    private Driver driver = new Driver();


    @Override
    public void get(){
        driver.getWebDriver().navigate().to("https://www.expedia.com/Flights");
    }

    @Override
    public void clickMultiFlightButton(){
        driver.getWebDriver().findElement(multiFlightButton).click();
    }

    @Override
    public void addTravellers(int travellers){
        driver.getWebDriver().findElement(travellersButton).click();

        for(int i = 0; i < travellers; i++){
            driver.getWebDriver().findElement(addTraveller).click();
        }
    }

    @Override
    public void setFlightItenarary(String originAirport, HashMap<String,Integer> iten){
        List<WebElement> flightElements = driver.getWebDriver().findElements(flightDetailButton);

        flightElements.get(2).click();
        flightElements.get(3).click();
    }


}
