package de.teddy.versionserver.response.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import de.teddy.versionserver.VersionServer;
import de.teddy.versionserver.response.AbstractResponse;

public class VersionResponse extends AbstractResponse {

    @Override
    public String getResponse() {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("version", VersionServer.getInstance().getVersion());
        String jsonResponse = gson.toJson(jsonObject);

        return jsonResponse;
    }
}
