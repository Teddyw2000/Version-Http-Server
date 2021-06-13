package de.teddy.versionserver.handler.impl;

import com.sun.net.httpserver.HttpExchange;
import de.teddy.versionserver.VersionServer;
import de.teddy.versionserver.handler.AbstractRequestHandler;
import de.teddy.versionserver.handler.MethodType;
import de.teddy.versionserver.response.impl.VersionResponse;
import de.teddy.versionserver.response.misc.SuccessResponse;

import java.util.Map;

public class VersionHandler extends AbstractRequestHandler {

    public VersionHandler() {
        super("version");
    }

    @Override
    public void process(HttpExchange httpExchange, Map<String, String> specification) {

        MethodType methodType = null;
        if(specification.containsKey("method")) {
            methodType = MethodType.valueOf(specification.get("method"));
        }

        switch(methodType) {
            case GET:
                this.printResponse(new VersionResponse(), httpExchange);

            case SET:
                if(specification.containsKey("version")) {
                    VersionServer.getInstance().setVersion(Double.parseDouble(specification.get("version")));
                    this.printResponse(new SuccessResponse(SuccessResponse.Type.COMPLETED), httpExchange);
                } else {
                    /* Print error response */
                }
        }
    }
}
