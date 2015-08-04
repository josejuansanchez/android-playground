package org.josejuansanchez.playground.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

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
    private String uri;
    private int baudrate;
    private String topic;

    public Connectivity getConnection() {
        return connection;
    }

    public void setConnection(Connectivity connection) {
        this.connection = connection;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getBaudrate() {
        return baudrate;
    }

    public void setBaudrate(int baudrate) {
        this.baudrate = baudrate;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
