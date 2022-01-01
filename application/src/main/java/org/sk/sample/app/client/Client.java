package org.sk.sample.app.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.sk.sample.app.Main.ADDR;
import static org.sk.sample.app.Main.PORT;

public class Client {

    private final HttpClient httpClient;
    private final String host;
    private final int port;

    public Client() {
        this(ADDR, PORT);
    }

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
        httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();
    }


    public Response sendGet(String path) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI("http://" + host + ":" + port + "/" + path))
                .GET()
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .build();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        int statusCode = response.statusCode();
        String body = response.body();
        return new Response() {
            @Override
            public int getStatusCode() {
                return statusCode;
            }

            @Override
            public String getBody() {
                return body;
            }
        };
    }


    public abstract static class Response {
        public abstract int getStatusCode();

        public abstract String getBody();
    }


}
