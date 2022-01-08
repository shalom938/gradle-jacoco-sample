package org.sk.sample.app.server;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sk.sample.app.Conf;
import org.sk.sample.app.internal.client.Client;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ServerTest {


    @BeforeAll
    public static void startServer() throws IOException {
        Server server = new Server(Conf.getAddress(), Conf.getPort());
        server.start();
    }

    @AfterAll
    public static void stopServer() throws URISyntaxException, IOException, InterruptedException {
        Client client = new Client(Conf.getAddress(), Conf.getPort());
        client.sendGet("shutdown");
    }


    @Test
    void testMessages() throws URISyntaxException, IOException, InterruptedException {
        Client client = new Client(Conf.getAddress(), Conf.getPort());
        Client.Response response = client.sendGet("msgs");
        assertNotNull(response, "client returned null response");
        assertEquals(200, response.getStatusCode(), "status code is not OK");
        assertNotNull(response.getBody(), "body is null");
        System.out.println("Response Body in ServerTest: " + response.getBody());

    }


}
