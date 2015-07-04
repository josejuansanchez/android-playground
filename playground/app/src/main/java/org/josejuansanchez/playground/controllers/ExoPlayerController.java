package org.josejuansanchez.playground.controllers;

import android.media.MediaCodec;
import android.media.MediaPlayer;
import android.net.Uri;

import com.google.android.exoplayer.ExoPlayer;
import com.google.android.exoplayer.FrameworkSampleSource;
import com.google.android.exoplayer.MediaCodecAudioTrackRenderer;
import com.google.android.exoplayer.MediaCodecVideoTrackRenderer;
import com.google.android.exoplayer.SampleSource;
import com.google.android.exoplayer.TrackRenderer;

import org.josejuansanchez.playground.MainActivity;
import org.josejuansanchez.playground.model.Message;

/**
 * Created by josejuansanchez on 04/07/15.
 */
public class ExoPlayerController {
    public final static String TAG = "ExoPlayerController";
    private MainActivity mContext;
    private ExoPlayer mExoPlayer;

    public ExoPlayerController(MainActivity mContext) {
        this.mContext = mContext;
    }

    public void playVideo(Message message) {

        // NOTE: This code does not work
        // TODO: Study the code of ExoPlayer

        int numRenderers = 2;

        // Build de sample source
        SampleSource sampleSource = new FrameworkSampleSource(mContext,
                Uri.parse(message.getUrl()),
                null,
                numRenderers);

        // Build the track renderers
        TrackRenderer videoRenderer = new MediaCodecVideoTrackRenderer(sampleSource,
                MediaCodec.VIDEO_SCALING_MODE_SCALE_TO_FIT);
        TrackRenderer audioRenderer = new MediaCodecAudioTrackRenderer(sampleSource);

        // Build the ExoPlayer and start playback
        mExoPlayer = ExoPlayer.Factory.newInstance(numRenderers);
        mExoPlayer.prepare(videoRenderer, audioRenderer);

        mExoPlayer.setPlayWhenReady(true);
    }

    public void playEMVideo(Message message) {
        mContext.getmEMVideoView().setDefaultControlsEnabled(true);
        mContext.getmEMVideoView().setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mContext.getmEMVideoView().start();
            }
        });

        mContext.getmEMVideoView().setVideoURI(Uri.parse(message.getUrl()));
    }
}