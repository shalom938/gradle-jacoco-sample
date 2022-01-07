package org.sk.sample.app;

import org.sk.sample.app.server.Server;

import java.io.IOException;

public class AppMain {


    public static void main(String[] args) throws IOException {
        System.out.println("Starting HTTP server ");
        Server server = new Server(Conf.getAddress(),Conf.getPort());
        server.start();
        System.out.println("Server started "+server.toString());
    }

}
