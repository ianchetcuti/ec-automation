package com.ecabs.automation.entities.pageobjects;

import com.ecabs.automation.entities.interfaces.LoginPage;
import com.ecabs.automation.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Login implements LoginPage {

    // Start elements.
    private By usernameTextBox = By.name("_username");

    private By passwordTextBox = By.name("_password");

    private By loginButton = By.name("login");

    private By logoutButton = By.className("i-logout-sml");

    // End elements.
    private Driver driver = new Driver();

    private List<WebElement> elements = null;

    public Login() {}
    
    @Override
    public void get(){
        driver.getWebDriver().navigate().to("https://www.askgamblers.com/login-p46");
    }

    @Override
    public void enterCredentials(String username, String password) {
        //sendKeys(driver, usernameTextBox, 10, username);
        //sendKeys(webDriver, passwordTextBox, 10, password);
        driver.getWebDriver().findElement(usernameTextBox).sendKeys("test");
        driver.getWebDriver().findElement(passwordTextBox).sendKeys("test");
    }

    @Override
    public void signIn() {
        driver.getWebDriver().findElement(loginButton).click();
    }

    @Override
    public void signOut() {
        //click(webDriver, logoutButton, DEFAULT_TIMEOUT);
    }

}
