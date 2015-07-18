package org.josejuansanchez.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import org.josejuansanchez.playground.model.Message;

import java.util.ArrayList;
import java.util.List;

public class SeekBarActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

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

        processUICode(message);
    }

    private void processUICode(Message message) {

        LinearLayout ll = (LinearLayout) findViewById(R.id.activity_seekbar_linearlayout);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.weight = 1;

        mProgressChanged = new int[message.getTotal()];

        for (int i=0; i< message.getTotal(); i++) {
            mSeekBar.add(new SeekBar(this));
            mSeekBar.get(i).setOnSeekBarChangeListener(this);
            mSeekBar.get(i).setTag(i);
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

        String textTodisplay = "";
        for(int i=0; i<message.getTotal(); i++) {
            textTodisplay += i + ":" + mProgressChanged[i] + " ";
        }

        Toast.makeText(SeekBarActivity.this, textTodisplay, Toast.LENGTH_SHORT).show();
    }
}
