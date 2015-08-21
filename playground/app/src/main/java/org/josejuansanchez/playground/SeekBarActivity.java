package org.josejuansanchez.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.physicaloid.lib.Physicaloid;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.josejuansanchez.playground.model.Message;

import java.util.ArrayList;
import java.util.List;

public class SeekBarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    public final static String TAG = "SeekBarActivity";
    private List<TextView> mTextView = new ArrayList<TextView>();
    private List<SeekBar> mSeekBar = new ArrayList<SeekBar>();
    private int mProgressChanged[];
    private Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        // Get the message from the intent
        Intent intent = getIntent();
        message = (Message) intent.getSerializableExtra(Constants.EXTRA_MESSAGE);

        // Initialize the array with the seekbars values
        initializeProgressChanged();

        // Build the UI
        buildUIfromMessage();
    }

    private void initializeProgressChanged() {
        int total = message.getLabels().length;
        mProgressChanged = new int[total];
        for (int i=0; i< total; i++) {
            mProgressChanged[i] = 0;
        }
    }

    private void buildUIfromMessage() {

        LinearLayout ll = (LinearLayout) findViewById(R.id.activity_seekbar_linearlayout);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        //lp.weight = 1;

        int total = message.getLabels().length;
        for (int i=0; i< total; i++) {

            // Configure and add Textview
            mTextView.add(new TextView(this));
            mTextView.get(i).setTag(i); // Should I use setId or View.generateViewId()?
            mTextView.get(i).setPadding(50, 50, 50, 50);
            mTextView.get(i).setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);

            // Update the textview with the initial value
            int initialValueForTxtV = 0;
            if (message.getInitialValues() != null) {
                initialValueForTxtV = message.getInitialValues()[i];
            } else if (message.getMinValues() != null) {
                    initialValueForTxtV = message.getMinValues()[i];
            }
            mTextView.get(i).setText(message.getLabels()[i] + " : " + initialValueForTxtV);

            // Add the textview to the layout
            ll.addView(mTextView.get(i), lp);

            // Configure and add SeekBar
            mSeekBar.add(new SeekBar(this));
            //mSeekBar.get(i).setOnSeekBarChangeListener(this);
            mSeekBar.get(i).setTag(i); // Should I use setId or View.generateViewId()?

            // Set the max value taking into account if the message contains a min value
            int maxValue = 0;
            if (message.getMaxValues() != null) {
                maxValue = message.getMaxValues()[i];
                if (message.getMinValues() != null) {
                    maxValue = message.getMaxValues()[i] + Math.abs(message.getMinValues()[i]);
                } else {
                    maxValue = message.getMaxValues()[i];
                }
            } else {
                maxValue = 100 + Math.abs(message.getMinValues()[i]);
            }
            mSeekBar.get(i).setMax(maxValue);

            // Set the initial value taking into account if the message contains an initial value
            int initialValue = 0;
            if (message.getInitialValues() != null) {
                if (message.getMinValues() != null) {
                    initialValue = message.getInitialValues()[i] + Math.abs(message.getMinValues()[i]);
                } else {
                    initialValue = message.getInitialValues()[i];
                }
            } else {
                if (message.getMinValues() != null) {
                    initialValue = message.getMinValues()[i];
                }
            }
            mSeekBar.get(i).setProgress(initialValue);

            // Add the seekbar to the layout
            ll.addView(mSeekBar.get(i), lp);

        }

        // We have to set the listener in a separate loop
        // because when the listener was added in the previous loop
        // the method "onProgressChanged" was called and the method "doAction"
        // was trying to access to "mTextView" views that have not been created yet.
        for (int i=0; i< total; i++) {
            mSeekBar.get(i).setOnSeekBarChangeListener(this);
        }
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int index = (int)seekBar.getTag();

        // Check if the seekbar has a min value
        if (message.getMinValues() != null) {
            mProgressChanged[index] = progress + message.getMinValues()[index];
        } else {
            mProgressChanged[index] = progress;
        }

        // Update the UI
        mTextView.get(index).setText(message.getLabels()[index] + " : " + mProgressChanged[index]);

        // Send the values with each progress change
        doAction();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {


    }

    private void doAction() {
        JsonObject json = new JsonObject();

        // Build the response message
        int total = message.getLabels().length;
        for(int i=0; i < total; i++) {
            json.addProperty(message.getLabels()[i], mProgressChanged[i]);
        }

        switch (message.getAction().getConnection()) {
            case HTTP:
                doHttpAction(json);
                break;

            case SERIAL:
                doSerialAction(json);
                break;

            case MQTT:
                doMQTTAction(json);
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
        // TODO: Improve
        if (message.getAction().getUris() != null) {
            int totalUris = message.getAction().getUris().length;
            for(int i=0; i < totalUris; i++) {
                doHttpNetworkRequest(message.getAction().getUris()[i], json);
            }
        } else {
            doHttpNetworkRequest(message.getAction().getUri(), json);
        }
    }

    private void doHttpNetworkRequest(String uri, JsonObject json) {
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

                        LinearLayout ll = (LinearLayout) findViewById(R.id.activity_seekbar_linearlayout);
                        Snackbar.make(ll, text, Snackbar.LENGTH_LONG)
                                .show();

                        Log.d(TAG, text);
                    }
                });
    }

    // TODO: Should I use Physicaloid in another different thread?
    private void doSerialAction(JsonObject json) {

        String text;
        Physicaloid physicaloid;

        // Create a new instance
        physicaloid = new Physicaloid(this);

        // Open the device
        if(physicaloid.open()) { // default 9600bps

            // Update the baud rate if the value is present in the message
            if (message.getAction().getBaudrate() != 0) {
                physicaloid.setBaudrate(message.getAction().getBaudrate());
            }

            byte[] buf = json.toString().getBytes();
            // write a buffer to the device
            physicaloid.write(buf, buf.length);

            // Close the device
            physicaloid.close();

            text = "Completed!";
        } else {
            text = "Error using serial port";
        }

        LinearLayout ll = (LinearLayout) findViewById(R.id.activity_seekbar_linearlayout);
        Snackbar.make(ll, text, Snackbar.LENGTH_LONG)
                .show();

        Log.d(TAG, text);
    }

    // TODO: Temporary solution
    // TODO: Review 'MqttAsyncClient' class
    private void doMQTTAction(final JsonObject json) {
        new Thread(new Runnable() {
            public void run() {
                MqttClient client = null;
                try {
                    // Note: MqttClient only accept tcp, ssl or local
                    client = new MqttClient(message.getAction().getUri(), MqttClient.generateClientId(), null);
                    client.setCallback(new ExampleCallBack());
                } catch (MqttException e1) {
                    e1.printStackTrace();
                }

                MqttConnectOptions options = new MqttConnectOptions();
                try {
                    client.connect(options);
                } catch (MqttException e) {
                    Log.d(getClass().getCanonicalName(), "Connection attempt failed with reason code = " + e.getReasonCode() + ":" + e.getCause());
                }

                try {
                    MqttMessage mqttMessage = new MqttMessage();
                    mqttMessage.setPayload(json.toString().getBytes());
                    client.publish(message.getAction().getTopic(), mqttMessage);
                    client.disconnect();
                }
                catch (MqttException e) {
                    Log.d(getClass().getCanonicalName(), "Publish failed with reason code = " + e.getReasonCode());
                }
            }
        }).start();
    }

    public class ExampleCallBack implements MqttCallback
    {
        public void connectionLost(Throwable cause)
        {
            Log.d(getClass().getCanonicalName(), "MQTT Server connection lost" + cause.toString());
        }
        public void messageArrived(String topic, MqttMessage message)
        {
            Log.d(getClass().getCanonicalName(), "Message arrived:" + topic + ":" + message.toString());
        }
        public void deliveryComplete(IMqttDeliveryToken token)
        {
            Log.d(getClass().getCanonicalName(), "Delivery complete");
        }
    }
}
