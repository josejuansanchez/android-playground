package org.josejuansanchez.playground.controllers;

import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;

import org.josejuansanchez.playground.MainActivity;
import org.josejuansanchez.playground.model.Message;

/**
 * Created by josejuansanchez on 23/06/15.
 */
public class VideoController {
    public final static String TAG = "VideoController";
    private MainActivity mContext;

    public VideoController(MainActivity mContext) {
        this.mContext = mContext;
    }

    // Reference: http://examples.javacodegeeks.com/android/android-videoview-example/
    public void playVideo(Message message) {

        try {
            mContext.getmVideoView().setMinimumWidth(mContext.getmDisplayMetrics().widthPixels);
            mContext.getmVideoView().setMinimumHeight(mContext.getmDisplayMetrics().heightPixels);

            mContext.getmVideoView().setMediaController(mContext.getmMediaControls());
            mContext.getmVideoView().setVideoURI(Uri.parse(message.getUrl()));

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            e.printStackTrace();
        }

        mContext.getmVideoView().requestFocus();

        mContext.getmVideoView().setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mContext.getmVideoView().start();
            }
        });
    }
}