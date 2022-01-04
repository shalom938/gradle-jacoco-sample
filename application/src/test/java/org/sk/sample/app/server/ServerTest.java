package org.sk.sample.app.server;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sk.sample.app.client.Client;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.sk.sample.app.Main.ADDR;
import static org.sk.sample.app.Main.PORT;

public class ServerTest {


    @BeforeAll
    public static void startServer() throws IOException {
        Server server = new Server(ADDR, PORT);
        server.start();
    }

    @AfterAll
    public static void stopServer() throws URISyntaxException, IOException, InterruptedException {
        Client client = new Client(ADDR, PORT);
        client.sendGet("shutdown");
    }


    @Test
    public void testMessages() throws URISyntaxException, IOException, InterruptedException {
        Client client = new Client(ADDR, PORT);
        Client.Response response = client.sendGet("msgs");
        assertNotNull(response, "client returned null response");
        assertEquals(200, response.getStatusCode(), "status code is not OK");
        assertNotNull(response.getBody(), "body is null");
        System.out.println("Response Body: " + response.getBody());

    }


}
