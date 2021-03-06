package org.josejuansanchez.playground.views;

import android.util.DisplayMetrics;
import android.view.SurfaceView;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.devbrackets.android.exomedia.EMVideoView;
import com.github.mikephil.charting.charts.LineChart;
import com.google.android.exoplayer.VideoSurfaceView;

/**
 * Created by josejuansanchez on 23/06/15.
 */
public interface MainView {
    public VideoView getmVideoView();

    public MediaController getmMediaControls();

    public DisplayMetrics getmDisplayMetrics();

    public SurfaceView getmSurfaceView();

    public ImageView getmImageView();

    public LineChart getmChart();

    public WebView getmWebView();

    public VideoSurfaceView getmVideoSurfaceView();

    public EMVideoView getmEMVideoView();
}