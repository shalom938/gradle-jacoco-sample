package org.gradle.sample.app.client;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.gradle.sample.app.Main.ADDR;
import static org.gradle.sample.app.Main.PORT;

public class MessagesClientMain {

    public static void main(String[] args) {
        try {
            System.out.println("building http client");

            Client client = new Client(ADDR, PORT);

            var response = client.sendGet("msgs");

            System.out.println("status : " + response.getStatusCode());
            System.out.println("body : " + response.getBody());

        } catch (InterruptedException | URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}
