/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.com.ecabs.automation.entities.pageobjects;

import mt.com.ecabs.automation.entities.interfaces.LandingPage;
import mt.com.ecabs.automation.entities.interfaces.LoginPage;
import mt.com.ecabs.automation.utils.Driver;
import org.openqa.selenium.By;

/**
 *
 * @author ianche
 */
public class Landing implements LandingPage {
    // Start elements.
    private By loginLink = By.className("header_user_info");

    // End elements.
    private Driver driver = new Driver();

    public Landing() {}

    @Override
    public void get(){
        driver.getWebDriver().navigate().to("http://automationpractice.com/index.php");
    }

    @Override
    public void clickLoginLink() {
        driver.getWebDriver().findElement(loginLink).click();
    }

}
