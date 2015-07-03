package org.josejuansanchez.playground.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.gson.Gson;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.body.JSONObjectBody;
import com.koushikdutta.async.http.server.AsyncHttpServer;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;
import com.koushikdutta.async.http.server.HttpServerRequestCallback;

import org.josejuansanchez.playground.Constants;
import org.josejuansanchez.playground.model.Message;
import org.json.JSONObject;

import de.greenrobot.event.EventBus;

/**
 * Created by josejuansanchez on 13/06/15.
 */
public class ServiceHttpServer extends Service {

    public final static String TAG = "ServiceHttpServer";
    private AsyncHttpServer mHttpServer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");

        // Start the http server
        initHttpServer();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");

        // Stop the http server
        if (mHttpServer != null) {
            mHttpServer.stop();
            AsyncServer.getDefault().stop();
        }
    }

    public void initHttpServer() {

        mHttpServer = new AsyncHttpServer();

        mHttpServer.setErrorCallback(new CompletedCallback() {
            @Override
            public void onCompleted(Exception ex) {
                Log.d(TAG, ex.toString());
            }
        });

        mHttpServer.listen(AsyncServer.getDefault(), Constants.DEFAULT_HTTP_PORT);

        mHttpServer.get("/info", new HttpServerRequestCallback() {
            @Override
            public void onRequest(AsyncHttpServerRequest request, AsyncHttpServerResponse response) {
                // TODO: This method could return DisplayMetrics values
                // NOTE: int densityDpi = (int)(mDisplayMetrics.density * 160f);
                response.send(request.getBody().get().toString());
            }
        });

        mHttpServer.post("/set", new HttpServerRequestCallback() {
            @Override
            public void onRequest(AsyncHttpServerRequest request, AsyncHttpServerResponse response) {
                try {

                    if (request.getBody() instanceof JSONObjectBody) {

                        JSONObject json = ((JSONObjectBody) request.getBody()).get();
                        Gson gson = new Gson();
                        final Message message = gson.fromJson(json.toString(), Message.class);

                        EventBus.getDefault().post(message);
                        response.send(request.getBody().get().toString());

                    } else {
                        // TODO: Improve the response
                        EventBus.getDefault().post(new Message(Constants.ERROR));
                        response.send("Error");
                    }
                } catch (Exception e) {
                    EventBus.getDefault().post(new Message(Constants.ERROR));
                    response.send(e.toString());
                }
            }
        });

    }

}
