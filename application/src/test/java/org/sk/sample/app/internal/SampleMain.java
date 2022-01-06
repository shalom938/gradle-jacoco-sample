package org.sk.sample.app.internal;

import org.sk.sample.app.client.MessagesClientMain;
import org.sk.sample.app.server.Server;

import java.io.IOException;

public class SampleMain {


    public static void main(String[] args) throws IOException {

        Server server = new Server();
        server.start();

        MessagesClientMain.main(null);

        System.out.println("calling server stop");
        server.stop();
        System.out.println("Server stopped!");

    }
}
