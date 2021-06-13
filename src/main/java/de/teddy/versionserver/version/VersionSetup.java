package de.teddy.versionserver.version;

import de.teddy.versionserver.VersionServer;

public class VersionSetup {

    public void setup(double version) {

        /*
         * TODO: Create File management and store version in properties.json
         */

        /* Store Version in version variable */
        VersionServer.getInstance().setVersion(version);
    }

}
