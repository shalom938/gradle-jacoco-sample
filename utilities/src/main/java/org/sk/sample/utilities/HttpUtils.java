package org.sk.sample.utilities;

import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HttpUtils {

    private static final String HTTP = "http://";
    private static final char PS = '/';

    public static Map<String, String> getQueryParamMap(String query) {

        if (query == null || query.isEmpty()) return Collections.emptyMap();

        return Stream.of(query.split("&"))
                .filter(s -> !s.isEmpty())
                .map(kv -> kv.split("=", 2))
                .collect(Collectors.toMap(x -> x[0], x -> x.length == 2 ? x[1] : ""));

    }


    public static URI buildUrl(InetAddress host, int port) throws URISyntaxException {
        return new URI(HTTP + host.getHostAddress() + ":" + port + PS);
    }

    public static URI buildUrl(InetAddress host, int port, String path) throws URISyntaxException {
        return new URI(HTTP + host.getHostAddress() + ":" + port + PS + path);
    }
}
