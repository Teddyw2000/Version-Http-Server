package de.teddy.versionserver.response.misc;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import de.teddy.versionserver.VersionServer;
import de.teddy.versionserver.response.AbstractResponse;

public class SuccessResponse extends AbstractResponse {

    Type type;

    public SuccessResponse(Type type) {
        this.type = type;
    }

    @Override
    public String getResponse() {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("info", type.getInfo());
        String jsonResponse = gson.toJson(jsonObject);

        return jsonResponse;
    }

    public enum Type {

        COMPLETED("Request completed successfully.");

        private final String info;

        Type(final String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }
    }
}
