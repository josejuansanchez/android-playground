package org.josejuansanchez.playground.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by josejuansanchez on 25/7/15.
 */

public class Action implements Serializable {

    public enum Connectivity {
        @SerializedName("0")
        HTTP,
        @SerializedName("1")
        BLUETOOTH,
        @SerializedName("2")
        SERIAL
    };

    private Connectivity connection;
    private String uri;

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
}
