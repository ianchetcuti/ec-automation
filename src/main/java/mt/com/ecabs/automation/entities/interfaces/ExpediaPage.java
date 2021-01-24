package mt.com.ecabs.automation.entities.interfaces;

import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public interface ExpediaPage {
    void get();

    void clickMultiFlightButton();

    void addTravellers(int i);

    void setFlightItenarary(String originAirport, HashMap<String,Integer> iten);
}
