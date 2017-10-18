package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 * A class representing a user.
 * See https://api.slack.com/types/user
 *
 */

public class User {

    // TODO: implement private fields for each of the following user JSON keys:
    private String id;
    private String name;
    private boolean deleted;
    private String color;
    private Map profile;
    private boolean is_admin;
    private boolean is_owner;
    private boolean is_primary_owner;
    private boolean is_restricted;
    private boolean is_ultra_restricted;
    private boolean has_2fa;
    private boolean two_factor_type;
    private boolean has_files;

    public User(JSONObject json) {

        // TODO: parse a user from the incoming json
        if (json.get("id") != null) {
            this.id = (String) json.get("id");
        }
        if (json.get("name") != null) {
            this.name = (String) json.get("name");
        }
        if (json.get("deleted") != null) {
            this.deleted = (Boolean) json.get("deleted");
        }
        if (json.get("color") != null) {
            this.color = (String) json.get("color");
        }
        if (json.get("profile") != null) {
            this.profile = (Map) json.get("profile");
        }
        if (json.get("is_admin") != null) {
            this.is_admin = (Boolean) json.get("is_admin");
        }
        if (json.get("is_owner") != null) {
            this.is_owner = (Boolean) json.get("is_owner");
        }
        if (json.get("is_primary_owner") != null) {
            this.is_primary_owner = (Boolean) json.get("is_primary_owner");
        }
        if (json.get("is_restricted") != null) {
            this.is_restricted = (Boolean) json.get("is_restricted");
        }
        if (json.get("is_ultra_restricted") != null) {
            this.is_ultra_restricted = (Boolean) json.get("is_ultra_restricted");
        }
        if (json.get("has_2fa") != null) {
            this.has_2fa = (Boolean) json.get("has_2fa");
        }
        if (json.get("two_factor_type") != null) {
            this.two_factor_type = (Boolean) json.get("two_factor_type");
        }
        if (json.get("has_files") != null) {
            this.has_files = (Boolean) json.get("has_files");
        }

    }


    // TODO add getters to access private fields
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public String getColor() {
        return color;
    }

    public Map<String, String> getProfile() {
        return profile;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public boolean isIs_owner() {
        return is_owner;
    }

    public boolean isIs_primary_owner() {
        return is_primary_owner;
    }

    public boolean isIs_restricted() {
        return is_restricted;
    }

    public boolean isIs_ultra_restricted() {
        return is_ultra_restricted;
    }

    public boolean isHas_2fa() {
        return has_2fa;
    }

    public boolean isTwo_factor_type() {
        return two_factor_type;
    }

    public boolean isHas_files() {
        return has_files;
    }
}
