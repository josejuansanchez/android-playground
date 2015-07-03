package org.josejuansanchez.playground.controllers;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.util.Log;

import org.josejuansanchez.playground.MainActivity;
import org.josejuansanchez.playground.model.Message;

/**
 * Created by josejuansanchez on 23/06/15.
 */
public class AudioController {

    public final static String TAG = "AudioController";
    private MainActivity mContext;

    public AudioController(MainActivity mContext) {
        this.mContext = mContext;
    }

    // TODO:
    // Review the official documentation about how to manage the Wake Lock Permission
    // http://developer.android.com/guide/topics/media/mediaplayer.html
    public void playAudio(Message message) {
        try {
            final MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDataSource(message.getUrl());

            // This step might take long! (for buffering, etc)
            mediaPlayer.prepareAsync();

            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();
                }
            });

            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    // I'm not sure if I should release the mediaPlayer here
                    mediaPlayer.release();
                    return false;
                }
            });

        } catch(Exception e) {
            Log.d(TAG, e.getMessage());
            e.printStackTrace();
        }
    }

}
