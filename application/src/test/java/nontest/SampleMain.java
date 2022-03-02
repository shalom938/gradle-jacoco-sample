package nontest;

import org.sk.sample.app.Conf;
import org.sk.sample.app.server.Server;

import java.io.IOException;

class SampleMain {


    //just a testing facility.
    //needs to run with module-path for the providers to be found,
    // it will run with classpath too but the providers will not be found
    // and the response will just be an empty html body.
    public static void main(String[] args) throws IOException {

        Server server = new Server(Conf.getAddress(),Conf.getPort());
        server.start();

        MessagesClientMain.main(null);

        System.out.println("calling server stop");
        server.stop();
        System.out.println("Server stopped!");

    }
}
