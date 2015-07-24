package org.josejuansanchez.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.josejuansanchez.playground.model.Message;

import java.util.ArrayList;
import java.util.List;

public class SeekBarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    public final static String TAG = "SeekBarActivity";
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

        // Build the UI
        processUICode();
    }

    private void processUICode() {

        LinearLayout ll = (LinearLayout) findViewById(R.id.activity_seekbar_linearlayout);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        //lp.weight = 1;

        mProgressChanged = new int[message.getTotal()];

        for (int i=0; i< message.getTotal(); i++) {

            // Configure and add Textview
            TextView tv = new TextView(this);
            tv.setText(message.getLabels()[i]);
            ll.addView(tv, lp);

            // Configure and add SeekBar
            mSeekBar.add(new SeekBar(this));
            mSeekBar.get(i).setOnSeekBarChangeListener(this);
            mSeekBar.get(i).setTag(i); // Should I use setId?
            //mSeekBar.get(i).setMax(200);
            ll.addView(mSeekBar.get(i), lp);

            mProgressChanged[i] = 0;
        }

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        mProgressChanged[(int)seekBar.getTag()] = progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        JsonObject json = new JsonObject();
        String textTodisplay = "";

        for(int i=0; i<message.getTotal(); i++) {
            json.addProperty(message.getLabels()[i], mProgressChanged[i]);
            textTodisplay += i + ":" + mProgressChanged[i] + " ";
        }

        Toast.makeText(SeekBarActivity.this, textTodisplay, Toast.LENGTH_SHORT).show();

        switch (message.getAction().getConnection()) {
            case HTTP:
                doHttpAction(json);
                break;

            // TODO
            case BLUETOOTH:
                break;

            // TODO
            case SERIAL:
                break;
        }

    }

    private void doHttpAction(JsonObject json) {
        Ion.with(this)
                .load(message.getAction().getUri())
                .setJsonObjectBody(json)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        // do stuff with the result or error

                        if (result != null) {
                            Log.d(TAG, "onCompleted: " + result.toString());
                        } else {
                            Log.d(TAG, "onCompleted");
                        }

                    }
                });

    }
}
