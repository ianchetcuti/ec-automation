/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecabs.automation.utils;

/**
 *
 * @author ianche
 */
public class HttpResponse {
    private int httpCode;
    private String body;

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }
    
        public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
