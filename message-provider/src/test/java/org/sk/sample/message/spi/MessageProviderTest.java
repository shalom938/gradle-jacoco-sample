package org.sk.sample.message.spi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Optional;

class MessageProviderTest {

    @Test
    void testCapitalize(){
        String hello = "hello";
        String capitalized = ((MessageProvider) () -> Optional.empty()).capitalize(hello);
        Assertions.assertEquals("Hello", capitalized,"first letter should be capitalized");
    }
}
