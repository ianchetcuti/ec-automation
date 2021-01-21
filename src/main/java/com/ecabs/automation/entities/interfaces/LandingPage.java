package com.ecabs.automation.entities.interfaces;

public interface LandingPage {
    void get();

    void enterSearch(String searchTerm) throws InterruptedException;

    void clickSearch();

    void clickComplaints();
}
