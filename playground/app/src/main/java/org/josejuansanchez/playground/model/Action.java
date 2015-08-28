package org.josejuansanchez.playground.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by josejuansanchez on 25/7/15.
 */

public class Action implements Serializable {

    public enum Connectivity {
        @SerializedName("http")
        HTTP,
        @SerializedName("serial")
        SERIAL,
        @SerializedName("mqtt")
        MQTT,
        @SerializedName("udp")
        UDP,
        @SerializedName("bluetooth")
        BLUETOOTH
    };

    private Connectivity connection;
    private String uris[];
    private int baudrate;
    private String topics[];
    private Map<String, Object> include_in_message;

    public Connectivity getConnection() {
        return connection;
    }

    public void setConnection(Connectivity connection) {
        this.connection = connection;
    }

    public int getBaudrate() {
        return baudrate;
    }

    public void setBaudrate(int baudrate) {
        this.baudrate = baudrate;
    }

    public String[] getTopics() {
        return topics;
    }

    public void setTopics(String[] topics) {
        this.topics = topics;
    }

    public String[] getUris() {
        return uris;
    }

    public void setUris(String[] uris) {
        this.uris = uris;
    }

    public Map<String, Object> getIncludeInMessage() {
        return include_in_message;
    }

    public void setIncludeInMessage(Map<String, Object> include_in_message) {
        this.include_in_message = include_in_message;
    }
}
