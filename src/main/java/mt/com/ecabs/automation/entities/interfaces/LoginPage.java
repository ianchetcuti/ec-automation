package mt.com.ecabs.automation.entities.interfaces;

public interface LoginPage {

    void get();

    void inputUsername(String username);

    void inputPassword(String password);

    void clickSignIn();

    void inputCredentialsAndLogin(String username, String password);

    String returnErrorContainerText();
}
