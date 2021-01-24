package mt.com.ecabs.automation.entities.pageobjects;

import mt.com.ecabs.automation.entities.interfaces.LoginPage;
import mt.com.ecabs.automation.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Login implements LoginPage {

    // Start elements.
    private By txtEmailUsername = By.id("email");
    private By txtPassword = By.id("passwd");
    private By btnSignIn = By.name("SubmitLogin");
    private By errorDiv = By.xpath("//div[contains(@class, 'alert-danger')]/ol/li");
    // End elements.
    private Driver driver = new Driver();

    private List<WebElement> elements = null;

    public Login() {}
    
    @Override
    public void get(){
        driver.getWebDriver().navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @Override
    public void inputUsername(String username){
        driver.getWebDriver().findElement(txtEmailUsername).sendKeys(username);
    }

    @Override
    public void inputPassword(String password){
        driver.getWebDriver().findElement(txtPassword).sendKeys(password);
    }

    @Override
    public void clickSignIn(){
        driver.getWebDriver().findElement(btnSignIn).click();
    }

    @Override
    public void inputCredentialsAndLogin(String username, String password) {
        inputUsername(username);
        inputPassword(password);
        clickSignIn();
    }

    @Override
    public String returnErrorContainerText(){
        return driver.getWebDriver().findElement(errorDiv).getText();
    }
}
