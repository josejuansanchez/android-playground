package org.josejuansanchez.playground.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by josejuansanchez on 31/7/15.
 */
public class ErrorMessage {
    private String text;

    public ErrorMessage() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public JSONObject toJSON() {
        JSONObject json = null;
        try {
            json = new JSONObject("{\"error\":\"" + text + "\"}");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
}
