package org.sk.sample.app;

import org.sk.sample.app.server.Server;

public class AppMain {


    public static void main(String[] args){

        System.out.println("Started application with command line: "+ProcessHandle.current().info().commandLine());

        System.out.println("Starting HTTP server ");
        try {
            Server server = new Server(Conf.getAddress(), Conf.getPort());
            server.start();
            System.out.println("Server started " + server);
        }catch (Exception e){
            System.out.println("Could not start server " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

}
