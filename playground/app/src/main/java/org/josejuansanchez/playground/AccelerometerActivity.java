package org.josejuansanchez.playground;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.josejuansanchez.playground.model.Message;

import java.util.Iterator;
import java.util.Map;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {

    public final static String TAG = "AccelerometerActivity";
    private SensorManager mSensorManager;
    private Sensor mSensor;
    private TextView mX;
    private TextView mY;
    private TextView mZ;
    private Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        // Get the message from the intent
        Intent intent = getIntent();
        message = (Message) intent.getSerializableExtra(Constants.EXTRA_MESSAGE);

        // Initialize the views
        mX = (TextView) findViewById(R.id.activity_accelerometer_textview_x);
        mY = (TextView) findViewById(R.id.activity_accelerometer_textview_y);
        mZ = (TextView) findViewById(R.id.activity_accelerometer_textview_z);

        // Initialize sensor manager
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        updateTextViews(x, y, z);

        doAction(event.values);
    }

    private void updateTextViews(float x, float y, float z) {
        mX.setText("x: " + x);
        mY.setText("y: " + y);
        mZ.setText("z: " + z);
    }

    private void doAction(float values[]) {
        JsonObject json = new JsonObject();

        // Build the response message:
        // 1) Adding the current values of the SeekBar
        int total = message.getIds().length;
        for(int i=0; i < total; i++) {

            // TODO:
            // Iprove this temporary solution
            json.addProperty(message.getIds()[i], (int) values[i]);
            //json.addProperty(message.getIds()[i], values[i]);
        }

        // 2) Adding the fields that have been specified in the request to be included in the msg
        if (message.getAction().getIncludeInMessage() != null) {
            Map map = message.getAction().getIncludeInMessage();
            Iterator it = map.keySet().iterator();
            while(it.hasNext()){
                String key = (String) it.next();

                if (map.get(key) instanceof String) {
                    json.addProperty(key, (String) map.get(key));
                } else if (map.get(key) instanceof Number) {
                    json.addProperty(key, (Number) map.get(key));
                }
            }
        }

        // Do the action
        switch (message.getAction().getConnection()) {
            case HTTP:
                doHttpAction(json);
                break;

            // TODO
            case SERIAL:
                break;

            // TODO
            case MQTT:
                break;

            // TODO
            case UDP:
                break;

            // TODO
            case BLUETOOTH:
                break;
        }
    }

    private void doHttpAction(JsonObject json) {
        int totalUris = message.getAction().getUris().length;
        for(int i=0; i < totalUris; i++) {
            doHttpActionOneUri(message.getAction().getUris()[i], json);
        }
    }

    private void doHttpActionOneUri(String uri, JsonObject json) {
        Ion.with(this)
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

                        // TODO
                        //showSnackbar(text);
                        Log.d(TAG, text);
                    }
                });
    }

    // Show a snackbar with information text or feedback for the user
    private void showSnackbar(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.activity_accelerometer_linearlayout);
        Snackbar.make(ll, text, Snackbar.LENGTH_LONG)
                .show();

    }

}
