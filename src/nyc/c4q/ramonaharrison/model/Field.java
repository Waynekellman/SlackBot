package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

public class Field {

    private String title;
    private String value;
    private boolean shorts;

    public Field(JSONObject json) {
        if (json.get("title") != null) {
            this.title = (String) json.get("title");
        }

        if (json.get("value") != null) {
            this.value = (String) json.get("value");
        }

        if (json.get("short") != null) {
            this.shorts = (Boolean) json.get("short");
        }
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }

    public boolean isShorts() {
        return shorts;
    }
}

