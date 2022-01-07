package org.sk.sample.messenger.it;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.sk.sample.app.Conf;
import org.sk.sample.app.internal.client.Client;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class GetMessagesTest {

    @Test
    void testGetMessage() throws URISyntaxException, IOException, InterruptedException {

        Client client = new Client(Conf.getAddress(), Conf.getPort());

        var response = client.sendGet("msgs");

        assertEquals(200,response.getStatusCode(),"Status code is not OK");
        assertNotNull(response.getBody(),"Response Body is null");
        assertFalse(response.getBody().isBlank(),"body is blank");
        System.out.println("Status Code in GetMessagesTest : " + response.getStatusCode());
        System.out.println("Body in GetMessagesTest : " + response.getBody());


        //just a simple way to test that the server found providers and got two messages.
        //of course in real world the response should be more defined.
        int countHStart = StringUtils.countMatches(response.getBody(),"<h1>");
        int countHEnd = StringUtils.countMatches(response.getBody(),"</h1>");
        assertTrue(countHStart > 0,"No messages in body");
        assertEquals(countHStart ,countHEnd,"Wrong html body");
        assertEquals(countHStart,4,"wrong number of lines in body");

    }
}
