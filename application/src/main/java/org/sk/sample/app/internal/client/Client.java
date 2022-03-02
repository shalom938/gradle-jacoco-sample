package org.sk.sample.app.internal.client;

import org.sk.sample.app.Conf;
import org.sk.sample.utilities.HttpUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Client {

    private final HttpClient httpClient;
    private final String host;
    private final int port;

    //todo: use this constructor
    public Client() {
        this(Conf.getAddress(), Conf.getPort());
    }

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
        httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();
    }


    public Response sendGet(String path) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder(HttpUtils.buildUrl(InetAddress.getByName(host),port,path))
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
