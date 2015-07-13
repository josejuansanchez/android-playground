package org.josejuansanchez.playground;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsoluteLayout;
import android.widget.Button;

import org.josejuansanchez.playground.model.Message;

public class AbsoluteLayoutActivity extends AppCompatActivity {

    public final static String TAG = "AbsoluteLayoutActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absolute_layout);

        // Get the message from the intent
        Intent intent = getIntent();
        Message message = (Message) intent.getSerializableExtra(Constants.EXTRA_MESSAGE);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_absolute_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
