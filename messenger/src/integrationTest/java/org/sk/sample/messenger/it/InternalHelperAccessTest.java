package org.sk.sample.messenger.it;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InternalHelperAccessTest {

    @Test
    void testInternalHelperAccess() {
        //the integrationTest test suite is a blackbox test suite so InternalHelper should not be accessible
        // from here because it's not exported by the main sample.messenger module.
        // Class.forName does not fail but trying to create an instance fails.
        Assertions.assertThrows(IllegalAccessException.class, () -> {
            Class.forName("org.sk.sample.messenger.internal.InternalHelper").getConstructor().newInstance();
        }, "class InternalHelper should not be accessible from this module");

    }

}
