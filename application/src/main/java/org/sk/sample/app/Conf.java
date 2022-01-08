package org.sk.sample.app;

public class Conf {

    private static final String ADDR = System.getProperty("org.sk.sample.app.host","localhost");
    private static final int PORT = Integer.parseInt(System.getProperty("org.sk.sample.app.port", "8001"));

    public static String getAddress(){
        return ADDR;
    }

    public static int getPort(){
        return PORT;
    }

}
