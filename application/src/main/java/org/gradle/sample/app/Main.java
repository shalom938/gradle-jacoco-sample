package org.gradle.sample.app;

import org.gradle.sample.app.client.MessagesClientMain;
import org.gradle.sample.app.server.Server;

import java.io.IOException;

public class Main {

    public static final String ADDR = "localhost";
    public static final int PORT = Integer.parseInt(System.getProperty("org.gradle.sample.app.port","8001"));

    public static void main(String[] args) throws IOException {

        Server server = new Server();
        server.start();

        MessagesClientMain.main(null);

//        System.out.println("calling server stop");
//        server.stop();
//        System.out.println("Server stopped!");

    }

}
