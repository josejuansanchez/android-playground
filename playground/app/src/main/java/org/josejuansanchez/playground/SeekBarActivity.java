package org.josejuansanchez.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

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
        initializeProcessChanged();

        // Build the UI
        buildUIfromMessage();
    }

    private void initializeProcessChanged() {
        mProgressChanged = new int[message.getTotal()];
        for (int i=0; i< message.getTotal(); i++) {
            mProgressChanged[i] = 0;
        }
    }

    private void buildUIfromMessage() {

        LinearLayout ll = (LinearLayout) findViewById(R.id.activity_seekbar_linearlayout);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        //lp.weight = 1;

        for (int i=0; i< message.getTotal(); i++) {

            // Configure and add Textview
            mTextView.add(new TextView(this));
            mTextView.get(i).setText(message.getLabels()[i]);
            mTextView.get(i).setTag(i); // Should I use setId?
            mTextView.get(i).setPadding(50, 50, 50, 50);
            mTextView.get(i).setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            ll.addView(mTextView.get(i), lp);

            // Configure and add SeekBar
            mSeekBar.add(new SeekBar(this));
            mSeekBar.get(i).setOnSeekBarChangeListener(this);
            mSeekBar.get(i).setTag(i); // Should I use setId?

            if (message.getMaxValues() != null) {
                mSeekBar.get(i).setMax(message.getMaxValues()[i]);
            }

            if (message.getInitialValues() != null) {
                mSeekBar.get(i).setProgress(message.getInitialValues()[i]);
            }

            ll.addView(mSeekBar.get(i), lp);

        }

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int index = (int)seekBar.getTag();
        mProgressChanged[index] = progress;
        mTextView.get(index).setText(message.getLabels()[index] + " : " + progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        JsonObject json = new JsonObject();

        for(int i=0; i<message.getTotal(); i++) {
            // Build the response message
            json.addProperty(message.getLabels()[i], mProgressChanged[i]);

            // Update the UI
            mTextView.get(i).setText(message.getLabels()[i] + " : " + mProgressChanged[i]);
        }

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
