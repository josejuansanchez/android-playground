package org.josejuansanchez.playground;

import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.hoho.android.usbserial.driver.UsbSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialPort;
import com.hoho.android.usbserial.driver.UsbSerialProber;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.josejuansanchez.playground.model.Message;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SeekBarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    public final static String TAG = "SeekBarActivity";
    private List<TextView> mTextView = new ArrayList<TextView>();
    private List<SeekBar> mSeekBar = new ArrayList<SeekBar>();
    private int mProgressChanged[];
    private Message message;
    private UsbSerialPort mPort;

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

    @Override
    protected void onResume() {
        super.onResume();

        // Open usb serial port
        openUsbSerialPort();
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Close usb serial port
        closeUsbSerialPort();
    }

    // Initialize the array with the progress values
    private void initializeProgressChanged() {
        int total = message.getIds().length;
        mProgressChanged = new int[total];
        for (int i=0; i< total; i++) {
            mProgressChanged[i] = 0;
        }
    }

    // Build the UI form the message
    private void buildUIfromMessage() {

        LinearLayout ll = (LinearLayout) findViewById(R.id.activity_seekbar_linearlayout);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        //lp.weight = 1;

        int total = message.getIds().length;
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
            mTextView.get(i).setText(getLabel(i) + " : " + initialValueForTxtV);

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
                if (message.getMinValues() != null) {
                    maxValue = 100 + Math.abs(message.getMinValues()[i]);
                } else {
                    maxValue = 100;
                }
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

    // If the labels tag is not present we use the id as label
    public String getLabel(int index) {
        String label = message.getIds()[index];
        if (message.getLabels() != null) {
            label = message.getLabels()[index];
        }
        return label;
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
        mTextView.get(index).setText(getLabel(index) + " : " + mProgressChanged[index]);

        // TEST
        // Send the values with each progress change
        //doAction();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TEST
        // Send the values with each progress change
        doAction();

    }

    private void doAction() {
        JsonObject json = new JsonObject();

        // Build the response message:
        // 1) Adding the current values of the SeekBar
        int total = message.getIds().length;
        for(int i=0; i < total; i++) {
            json.addProperty(message.getIds()[i], mProgressChanged[i]);
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
                //HttpAction.getInstance(this, message, json).doHttpAction();
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

                        showSnackbar(text);
                        Log.d(TAG, text);
                    }
                });
    }

    private void doMQTTAction(JsonObject json) {
        int totalUris = message.getAction().getUris().length;
        for(int i=0; i < totalUris; i++) {
            doMQTTActionOneUri(message.getAction().getUris()[i], message.getAction().getTopics()[i], json);
        }
    }

    // TODO: Temporary solution
    // TODO: Review 'MqttAsyncClient' class
    private void doMQTTActionOneUri(final String uri, final String topic,  final JsonObject json) {
        new Thread(new Runnable() {
            public void run() {

                // ***
                MqttConnectOptions options = new MqttConnectOptions();

                String username = "use-token-auth";
                String password = "jmyHZcEyUDuKMC1!*r";
                options.setUserName(username);
                options.setPassword(password.toCharArray());
                // ***

                MqttClient client = null;
                try {
                    // Note: MqttClient only accept tcp, ssl or local
                    client = new MqttClient(uri, MqttClient.generateClientId(), null);
                    client.setCallback(new ExampleCallBack());
                } catch (MqttException e1) {
                    e1.printStackTrace();
                }

                try {
                    client.connect(options);
                } catch (MqttException e) {
                    Log.d(getClass().getCanonicalName(), "Connection attempt failed with reason code = " + e.getReasonCode() + ":" + e.getCause());
                }

                try {
                    MqttMessage mqttMessage = new MqttMessage();
                    mqttMessage.setPayload(json.toString().getBytes());
                    client.publish(topic, mqttMessage);
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




    // TODO: Should I do this in another different thread?
    private void openUsbSerialPort() {
        // Find all available drivers from attached devices.
        UsbManager manager = (UsbManager) getSystemService(Context.USB_SERVICE);
        List<UsbSerialDriver> availableDrivers = UsbSerialProber.getDefaultProber().findAllDrivers(manager);
        if (availableDrivers.isEmpty()) {
            return;
        }

        // Open a connection to the first available driver.
        UsbSerialDriver driver = availableDrivers.get(0);
        UsbDeviceConnection connection = manager.openDevice(driver.getDevice());
        if (connection == null) {
            // TODO:
            // You probably need to call UsbManager.requestPermission(driver.getDevice(), ..)
            Log.d(TAG, "Opening device failed");
            return;
        }

        mPort = driver.getPorts().get(0);
        try {
            mPort.open(connection);
            mPort.setParameters(message.getAction().getBaudrate(), 8, UsbSerialPort.STOPBITS_1, UsbSerialPort.PARITY_NONE);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "Error setting up device: " + e.getMessage(), e);
            return;
        }

    }

    // TODO: Should I do this in another different thread?
    private void doSerialAction(JsonObject json) {
        try {
            byte[] buf = json.toString().getBytes();
            mPort.write(buf, buf.length);

            showSnackbar("Write " + buf.length + " bytes.");
            Log.d(TAG, "Write " + buf.length + " bytes");

        } catch (IOException e) {
            e.printStackTrace();

            showSnackbar("Error writing bytes into the device");
            Log.d(TAG, "Error writing bytes into the device");
        }
    }

    // TODO: Should I do this in another different thread?
    private void closeUsbSerialPort() {
        try {
            mPort.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "Error closing the port");
        }
    }

    // Show a snackbar with information text or feedback for the user
    private void showSnackbar(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.activity_seekbar_linearlayout);
        Snackbar.make(ll, text, Snackbar.LENGTH_LONG)
                .show();

    }
}
