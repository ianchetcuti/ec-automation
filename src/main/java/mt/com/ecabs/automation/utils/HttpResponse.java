/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mt.com.ecabs.automation.utils;

import com.mashape.unirest.http.JsonNode;

/**
 *
 * @author ianche
 */
public class HttpResponse {
    private int httpCode;
    private JsonNode body;

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }
    
    public JsonNode getBody() {
        return body;
    }

    public void setBody(JsonNode body) {
        this.body = body;
    }
}
