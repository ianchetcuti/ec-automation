package com.ecabs.automation.utils;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 *
 * @author ianche
 */
public class HttpRequest {
    public JsonNode jsonResponse = null;

    public HttpRequest(){
    }

    public HttpResponse sendHttpRequest(String verb, String body){
        HttpResponse response = new HttpResponse();
        try{
            jsonResponse = Unirest.post("https://auth.vodafone.com.mt/oauth/token")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .field("scope", "dxluser:getOwnData")
                    .field("client_id", "MVA10_PRIV")
                    .field("client_secret","9qm4BMKLhVVBPXkOo4x07ThYfn1WMM")
                    .field("grant_type", "password")
                    .field("username", "ianchetcuti")
                    .field("password", "Voda1234!")
                    .asJson()
                    .getBody();
            response.setHttpCode(200);
            response.setBody("test");
        }catch (UnirestException e){
            System.out.println("HTTP malformed JSON response");
            System.exit(-1);
        }
        return response;
    }
}
