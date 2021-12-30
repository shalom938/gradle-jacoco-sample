package org.gradle.sample.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MessageFormatterTest {


    @Test
    public void testMessagePreview(){
        String message = "This is a message";
        String preview = MessageFormatter.messagePreview(message);
        assertNotNull(preview,"preview is null");
        assertEquals(message,preview,"preview should be the same");

        message = "1234567890-1234567890-1234567890-1234567890-1234567890";
        preview = MessageFormatter.messagePreview(message);
        assertNotNull(preview,"preview is null");
        assertEquals(53,preview.length(),"preview length is wrong");
        assertEquals("1234567890-1234567890-1234567890-1234567890-123456...",preview,"preview string is wrong");

    }
}
