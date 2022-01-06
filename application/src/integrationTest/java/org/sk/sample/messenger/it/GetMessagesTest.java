package org.sk.sample.messenger.it;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sk.sample.app.Main;
import org.sk.sample.app.client.Client;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class GetMessagesTest {

    //currently, can't run tests in parallel because they will try the same port.
    //TODO: how to run tests in parallel? maybe a server on different port for every test
    //instance. or only one server that will start before the test suite

    @BeforeAll
    public static void startServer() throws IOException {
        Main.main(null);
    }


    @AfterAll
    public static void stopServer() throws URISyntaxException, IOException, InterruptedException {
        Client client = new Client(Main.ADDR, Main.PORT);
        //hopefully will shut down the server
        client.sendGet("shutdown");
    }



    @Test
    void testGetMessage() throws URISyntaxException, IOException, InterruptedException {

        Client client = new Client(Main.ADDR, Main.PORT);

        var response = client.sendGet("msgs");

        assertEquals(200,response.getStatusCode(),"Status code is not OK");
        assertNotNull(response.getBody(),"Response Body is null");
        assertFalse(response.getBody().isBlank(),"body is blank");
        System.out.println("Status Code in GetMessagesTest : " + response.getStatusCode());
        System.out.println("Body in GetMessagesTest : " + response.getBody());

    }
}
