package org.josejuansanchez.playground.actions;

import android.content.Context;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.josejuansanchez.playground.model.Message;

/**
 * Created by josejuansanchez on 18/12/15.
 */
public class HttpAction {
    Context mContext;
    Message mMessage;
    JsonObject mJson;
    static HttpAction instance;

    public HttpAction(Context context, Message message, JsonObject json) {
        mContext = context;
        mMessage = message;
        mJson = json;
    }

    public static HttpAction getInstance(Context context, Message message, JsonObject json) {
        if (context == null)
            throw new NullPointerException("Can not pass null context in to retrieve HttpAction instance");

        if (instance == null) {
            instance = new HttpAction(context, message, json);
        }

        return instance;
    }

    public void doHttpAction() {
        int totalUris = mMessage.getAction().getUris().length;
        for(int i=0; i < totalUris; i++) {
            doHttpActionOneUri(mMessage.getAction().getUris()[i], mJson);
        }
    }

    private void doHttpActionOneUri(String uri, JsonObject json) {
        Ion.with(mContext)
                .load(uri)
                .setJsonObjectBody(json)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        // do stuff with the result or error
                        String text;

                        if (e != null) {
                            text = e.toString();
                        } else {
                            text = "Completed!";
                        }

                        //showSnackbar(text);
                        //Log.d(TAG, text);
                    }
                });
    }

}