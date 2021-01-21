package com.askgamblers.cm.automation.entities.interfaces;

public interface LoginPage {

    void get();
    
    void enterCredentials(String username, String password);

    void signIn();

    void signOut();

}
