package org.josejuansanchez.playground.controllers;

import android.content.Context;
import android.os.Vibrator;

import org.josejuansanchez.playground.MainActivity;
import org.josejuansanchez.playground.model.Message;

/**
 * Created by josejuansanchez on 30/06/15.
 */
public class VibrateController {
    public final static String TAG = "VibrateController";
    private MainActivity mContext;

    public VibrateController(MainActivity mContext) {
        this.mContext = mContext;
    }

    public void vibrate(Message message) {
        Vibrator v = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(message.getMilliseconds());
    }
}
