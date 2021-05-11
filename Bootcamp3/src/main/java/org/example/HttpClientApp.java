package org.example;


import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import static java.net.http.HttpRequest.BodyPublishers.noBody;


/**
 * Starter code which uses Java 11 java.net.http.HttpClient
 * to send HTTP Requests and receive HTTP Responses.
 * Note that you can also use Spring code to send HTTP Requests but
 * we have chosen to use java.net.http.HttpClient as it is nice and easy!
 */
public class HttpClientApp {
    public static void main( String[] args ) {

        String url = "https://http-challenge.multiverse-coaches.io";

        try {
            java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();

            // first request (GET)
            HttpRequest request = HttpRequest.newBuilder(
                    URI.create(url))
                    .header("accept", "application/json")
                    .method("GET", noBody())
                    .build();

            System.out.println(request);

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());




            // TODO - add code for second request (POST) here
            //  .method("POST", HttpRequest.BodyPublishers.ofString(jsonName))

            String url2 = "https://http-challenge.multiverse-coaches.io/apprentices";

            String jsonName = "{" +
                    "\"name\":\"Mustafa\"" +
                    "}";

            java.net.http.HttpClient client2 = java.net.http.HttpClient.newHttpClient();

            // Request 2 -POST

            HttpRequest request1 = HttpRequest.newBuilder(
                    URI.create(url2))
                    .header("content-type", "application/json")
                    .method("POST", HttpRequest.BodyPublishers.ofString(jsonName))
                    .build();

            System.out.println(request1);

            HttpResponse<String> response2 = client.send(request1, HttpResponse.BodyHandlers.ofString());
            System.out.println(response2.body());


            // TODO - add code for third request (header) here

            String url3 = String.format("https://http-challenge.multiverse-coaches.io/apprentices/%s", headerValue);
            HttpRequest request3 = HttpRequest.newBuilder(
                    URI.create(url3))
                    .header("accept", "application/json")
                    .method("GET", noBody())
                    .build();

            System.out.println(request3);

            HttpResponse<String> response3 = client.send(request3, HttpResponse.BodyHandlers.ofString());
            System.out.println(response3.body());

            // The code below will help you retrieve the "your-id" header from the HTTP Response

            System.out.println(headerValue);




            //   String headerValue = null;
          //  Map<String, List<String>> map = response2.headers().map();
           // for (Map.Entry<String, List<String>> entry:map.entrySet()) {
         //       if ("your-id".equalsIgnoreCase(entry.getKey())) {
         //           headerValue = entry.getValue().get(0);
        //            break;
       //         }
       //     }


           String url4 = String.format("https://http-challenge.multiverse-coaches.io/apprentices/450ce6cf/menus?starter=garlic%20bread&main=seasoned%20samon&dessert=chocalate%20cake");

            // TODO - add code for forth request (PATCH) here

            //Request 4 -Patch

            // TODO - add code for fifth request (GET with Query Parameters) here

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}