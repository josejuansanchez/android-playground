package org.josejuansanchez.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AbsoluteLayout;
import android.widget.Button;

import org.josejuansanchez.playground.model.Message;

public class AbsoluteLayoutActivity extends AppCompatActivity {

    public final static String TAG = "AbsoluteLayoutActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the message from the intent
        Intent intent = getIntent();
        Message message = (Message) intent.getSerializableExtra(Constants.EXTRA_MESSAGE);

        setContentView(R.layout.activity_absolute_layout);

        processUICode(message);
    }

    private void processUICode(Message message) {
        Button button = new Button(this);
        button.setText(message.getText());
        AbsoluteLayout al = (AbsoluteLayout) findViewById(R.id.absolute_layout);

        AbsoluteLayout.LayoutParams lp = new AbsoluteLayout.LayoutParams(
                AbsoluteLayout.LayoutParams.MATCH_PARENT,
                AbsoluteLayout.LayoutParams.WRAP_CONTENT,
                message.getX(), message.getY());

        al.addView(button, lp);
    }
}
