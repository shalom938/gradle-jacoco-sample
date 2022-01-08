package org.sk.sample.app.internal.client;

import org.sk.sample.app.Conf;

import java.io.IOException;
import java.net.URISyntaxException;

public class MessagesClientMain {

    public static void main(String[] args) {
        try {
            System.out.println("building http client");

            Client client = new Client(Conf.getAddress(), Conf.getPort());

            var response = client.sendGet("msgs");

            System.out.println("Status Code : " + response.getStatusCode());
            System.out.println("Body : " + response.getBody());

        } catch (InterruptedException | URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
