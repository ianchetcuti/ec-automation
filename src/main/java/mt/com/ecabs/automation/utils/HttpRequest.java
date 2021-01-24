package mt.com.ecabs.automation.utils;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

/**
 *
 * @author ianche
 */
public class HttpRequest {

    public HttpRequest(){
    }

    public HttpResponse sendHttpRequest(String URI, String verb, JSONObject sbody){
        HttpResponse resp = new HttpResponse();
        com.mashape.unirest.http.HttpResponse<JsonNode> jsonResponse = null;
        try{
            if(verb.equalsIgnoreCase("POST"))
            {
                jsonResponse = Unirest.post(URI)
                        .header("Content-Type", "application/json")
                        .body(sbody)
                        .asJson();
            } else if (verb.equalsIgnoreCase("GET")){
                jsonResponse = Unirest.get(URI)
                        .header("Content-Type", "application/json")
                        .asJson();
            } else
                throw new UnsupportedOperationException(verb+" verb not supported in this version");

        }catch (UnirestException e){
            System.out.println("HTTP malformed JSON response");
            System.exit(-1);
        }
        resp.setHttpCode(jsonResponse.getStatus());
        //response.setBody(jsonResponse.getObject().getString("token"));
        resp.setBody(jsonResponse.getBody());

        return resp;
    }
}
