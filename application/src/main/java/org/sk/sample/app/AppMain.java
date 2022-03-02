package org.sk.sample.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sk.sample.app.server.Server;

public class AppMain {


    private static final Logger LOGGER = LogManager.getLogger();


    public static void main(String[] args){

        LOGGER.info("Started application with command line: {}",ProcessHandle.current().info().commandLine());
        LOGGER.info("Starting HTTP server ");
        try {
            Server server = new Server(Conf.getAddress(), Conf.getPort());
            server.start();
        }catch (Exception e){
            LOGGER.error("Could not start server", e);
            System.exit(1);
        }
    }

}
