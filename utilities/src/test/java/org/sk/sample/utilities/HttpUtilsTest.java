package org.sk.sample.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HttpUtilsTest {


    @Test
    public void testGetQueryParamMap() {

        String query = "p1=param1&p2=param2&p3";

        var params = HttpUtils.getQueryParamMap(query);
        assertNotNull(params, "null map returned");
        assertEquals(3, params.size(), "param size is wrong");
        assertTrue(params.containsKey("p1"), "params should contain p1");
        assertTrue(params.containsKey("p2"), "params should contain p2");
        assertTrue(params.containsKey("p3"), "params should contain p2");
        assertEquals("param1", params.get("p1"), "value does not match");
        assertEquals("param2", params.get("p2"), "value does not match");
        assertEquals("", params.get("p3"), "value does not match");

    }

}
