package de.teddy.versionserver.handler.impl;

import com.sun.net.httpserver.HttpExchange;
import de.teddy.versionserver.handler.AbstractRequestHandler;
import de.teddy.versionserver.response.impl.VersionResponse;

import java.util.Map;

public class VersionHandler extends AbstractRequestHandler {

    public VersionHandler() {
        super("version");
    }

    @Override
    public void process(HttpExchange httpExchange, Map<String, String> specification) {

        this.printResponse(new VersionResponse(), httpExchange);
    }
}
