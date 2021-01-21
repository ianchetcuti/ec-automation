/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecabs.automation.entities.pageobjects;

import com.ecabs.automation.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 *
 * @author ianche
 */
public class Landing implements com.ecabs.automation.entities.interfaces.LandingPage {
    // Start elements.
    private By searchTextBox = By.id("ag-header-search--body");

    private By searchButton = By.className("ag-header-search-icon");

    private By complaintsButton = By.cssSelector("[title^='Complaints']");

    // End elements.
    private Driver driver = new Driver();

    public Landing() {}

    @Override
    public void get(){
        driver.getWebDriver().navigate().to("https://www.askgamblers.com");
    }

    @Override
    public void enterSearch(String searchTerm) throws InterruptedException {
        //sendKeys(driver, usernameTextBox, 10, username);
        //sendKeys(webDriver, passwordTextBox, 10, password);
        driver.getWebDriver().findElement(searchTextBox).sendKeys(searchTerm);
        driver.getWebDriver().wait(3000);
    }

    @Override
    public void clickSearch() {
        driver.getWebDriver().findElement(searchButton).click();
    }

    @Override
    public void clickComplaints() {
        driver.getWebDriver().findElement(complaintsButton).click();
    }
}
