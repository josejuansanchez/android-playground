package org.josejuansanchez.playground.controllers;

import android.graphics.Color;

import org.josejuansanchez.playground.MainActivity;
import org.josejuansanchez.playground.model.Message;

import java.util.Random;

/**
 * Created by josejuansanchez on 12/06/15.
 */
public class SurfaceViewController {

    private MainActivity mContext;

    public SurfaceViewController(MainActivity mContext) {
        this.mContext = mContext;
    }

    public void updateSurfaceView(Message message) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                final Random randomGenerator = new Random();
                for (int i = 0; i < 20; i++) {
                    final int r = randomGenerator.nextInt(256);
                    final int g = randomGenerator.nextInt(256);
                    final int b = randomGenerator.nextInt(256);

                    mContext.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mContext.getmSurfaceView().setBackgroundColor(Color.rgb(r, g, b));
                            mContext.getmSurfaceView().invalidate();
                        }
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void setBackgroundColor(final Message message) {
        mContext.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mContext.getmSurfaceView().setBackgroundColor(
                        Color.rgb(message.getR(), message.getG(), message.getB()));
                mContext.getmSurfaceView().invalidate();
            }
        });

    }

}