package de.teddy.versionserver.handler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import de.teddy.versionserver.response.AbstractResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class AbstractRequestHandler implements HttpHandler {

    private String context;

    public AbstractRequestHandler(String context) {
        this.context = context;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String query = httpExchange.getRequestURI().getQuery();
        Map<String, String> specification = null;
        if(query != null && !query.isEmpty()) {
            specification = Stream.of(query.split("&"))
                    .filter(s -> !s.isEmpty())
                    .map(kv -> kv.split("=", 2))
                    .collect(Collectors.toMap(k -> k[0], k -> k[1]));
        }

        process(httpExchange, specification);
    }

    /* The method to print the response */
    protected void printResponse(AbstractResponse abstractResponse, HttpExchange httpExchange) {

        try {
            String response = abstractResponse.getResponse();

            httpExchange.sendResponseHeaders(200, response.getBytes().length);
            OutputStream outputStream = httpExchange.getResponseBody();
            outputStream.write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* The abstract method to handle the exchange */
    public abstract void process(HttpExchange httpExchange, Map<String, String> specification);

    public String getContext() {
        return context;
    }
}
