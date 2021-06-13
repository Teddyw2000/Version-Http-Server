package de.teddy.versionserver;

public class Launcher {

    /* Start a new VersionServer with the port parameter */
    public static void main(String[] args) {

        new VersionServer(3030).run();

    }

}
