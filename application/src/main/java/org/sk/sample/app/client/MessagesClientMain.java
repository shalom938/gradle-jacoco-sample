package org.sk.sample.app.client;

import org.sk.sample.app.Main;

import java.io.IOException;
import java.net.URISyntaxException;

public class MessagesClientMain {

    public static void main(String[] args) {
        try {
            System.out.println("building http client");

            Client client = new Client(Main.ADDR, Main.PORT);

            var response = client.sendGet("msgs");

            System.out.println("status : " + response.getStatusCode());
            System.out.println("body : " + response.getBody());

        } catch (InterruptedException | URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
