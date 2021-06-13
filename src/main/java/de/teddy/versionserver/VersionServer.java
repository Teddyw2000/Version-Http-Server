package de.teddy.versionserver;

import com.sun.net.httpserver.HttpServer;
import de.teddy.versionserver.handler.AbstractRequestHandler;
import de.teddy.versionserver.handler.impl.VersionHandler;
import de.teddy.versionserver.version.VersionSetup;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;

public class VersionServer implements Runnable {


    /* The prefix for the console output */
    public static final String prefix = "VersionServer | ";

    /* The version which is important for the whole system */
    public static double version = 1.0;

    /* The instance of the Main Runnable VersionServer */
    private static VersionServer instance;

    /* The Log4j instance */
    private final Logger logger = LogManager.getLogger(VersionServer.class);

    /* The port of the HttpServer which is about to be initialized in the constructor */
    private final int port;

    /* The VersionSetup class to store the version in files and update variable in VersionServer*/
    private VersionSetup versionSetup = new VersionSetup();

    /* The instance of the HttpServer */
    private HttpServer httpServer;

    public VersionServer(int port) {
        this.port = port;
    }

    public void run() {
        instance = this;

        try {

            /*
             *  First Log
             */
            logger.info(this.prefix + "Create HttpServer ...");

            /*
             *  Create the HttpServer with the initialized port
             */
            System.out.println(this.prefix + "Create HttpServer ...");
            httpServer = HttpServer.create(new InetSocketAddress(this.port), 0);
            System.out.println(this.prefix + "HttpServer is listening on port " + this.port);

            /*
             *  Register all request handlers
             */
            System.out.println(this.prefix + "Register Request handlers ...");
            List<AbstractRequestHandler> handlers = Arrays.asList(
                    new VersionHandler()
            );
            System.out.println(this.prefix + "Handlers successfully registered.");

            /*
             *  Create a context for each handler
             */
            System.out.println(this.prefix + "Create Context for each handler ...");
            handlers.stream().forEach(handler -> {
                httpServer.createContext("/" + handler.getContext(), handler);
                System.out.println("    New Context: /" + handler.getContext());
            });
            System.out.println(this.prefix + "Each handler now has a context.");

            /*
             *  Start the HttpServer
             */
            logger.info(this.prefix + "Start HttpServer ...");
            System.out.println(this.prefix + "Start HttpServer ...");
            httpServer.start();
            System.out.println(this.prefix + "HttpServer is now online.");
            logger.info(this.prefix + "HttpServer is now online.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static VersionServer getInstance() { return instance; }

    public double getVersion() { return version; }

    public void setVersion(double version) { this.version = version; }
}
