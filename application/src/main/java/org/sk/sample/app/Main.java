package org.sk.sample.app;

import org.sk.sample.app.client.MessagesClientMain;
import org.sk.sample.app.server.Server;

import java.io.IOException;

public class Main {

    public static final String ADDR = "localhost";
    public static final int PORT = Integer.parseInt(System.getProperty("org.sk.sample.app.port", "8001"));

    public static void main(String[] args) throws IOException {

        Server server = new Server();
        server.start();

        MessagesClientMain.main(null);

//        System.out.println("calling server stop");
//        server.stop();
//        System.out.println("Server stopped!");

    }

}
