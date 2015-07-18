package org.josejuansanchez.playground;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.devbrackets.android.exomedia.EMVideoView;
import com.github.mikephil.charting.charts.LineChart;
import com.google.android.exoplayer.VideoSurfaceView;

import org.josejuansanchez.playground.controllers.ADBController;
import org.josejuansanchez.playground.controllers.AudioController;
import org.josejuansanchez.playground.controllers.ExoPlayerController;
import org.josejuansanchez.playground.controllers.ImageViewController;
import org.josejuansanchez.playground.controllers.LineChartController;
import org.josejuansanchez.playground.controllers.SurfaceViewController;
import org.josejuansanchez.playground.controllers.TextToSpeechController;
import org.josejuansanchez.playground.controllers.VibrateController;
import org.josejuansanchez.playground.controllers.VideoController;
import org.josejuansanchez.playground.controllers.WebViewController;
import org.josejuansanchez.playground.model.Message;
import org.josejuansanchez.playground.services.ServiceHttpServer;
import org.josejuansanchez.playground.views.MainView;

import de.greenrobot.event.EventBus;


public class MainActivity extends AppCompatActivity implements MainView {

    public final static String TAG = "MainActivity";
    private WebView mWebView;
    private VideoView mVideoView;
    private MediaController mMediaControls;
    private ImageView mImageView;
    private LineChart mChart;
    private SurfaceView mSurfaceView;
    private DisplayMetrics mDisplayMetrics;
    private VideoSurfaceView mVideoSurfaceView;
    private EMVideoView mEMVideoView;
    private static final int REQUEST_IMAGE_CAPTURE = 1;

    // Controllers
    private SurfaceViewController mSurfaceViewController;
    private AudioController mAudioController;
    private VideoController mVideoController;
    private ImageViewController mImageViewController;
    private LineChartController mLineChartController;
    private WebViewController mWebViewController;
    private ADBController mADBController;
    private VibrateController mVibrateController;
    private ExoPlayerController mExoPlayerController;
    private TextToSpeechController mTTSController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);

        mVideoView = (VideoView) findViewById(R.id.videoview);
        mVideoView.setVisibility(View.GONE);

        mMediaControls = new MediaController(this);

        mWebView = (WebView) findViewById(R.id.webview);
        mVideoView.setVisibility(View.GONE);

        // TEST
        //mWebView.setBackgroundColor(Color.parseColor("#000000"));

        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);

        // To allow the autoplay tag in HTML5 video (minSdkVersion 17 (4.4) is required)
        mWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });

        mImageView = (ImageView) findViewById(R.id.imageview);
        mImageView.setVisibility(View.GONE);

        mChart = (LineChart) findViewById(R.id.chart);
        mChart.setVisibility(View.GONE);

        mSurfaceView = (SurfaceView) findViewById(R.id.surfaceview);
        mSurfaceView.setVisibility(View.GONE);

        mVideoSurfaceView = (VideoSurfaceView) findViewById(R.id.video_surfaceview);
        mVideoSurfaceView.setVisibility(View.GONE);

        mEMVideoView = (EMVideoView) findViewById(R.id.video_emvideoview);
        mEMVideoView.setVisibility(View.GONE);

        // Register as a subscriber
        EventBus.getDefault().register(this);

        // Controllers
        mSurfaceViewController = new SurfaceViewController(this);
        mAudioController = new AudioController(this);
        mVideoController = new VideoController(this);
        mImageViewController = new ImageViewController(this);
        mLineChartController = new LineChartController(this);
        mWebViewController = new WebViewController(this);
        mADBController = new ADBController(this);
        mVibrateController = new VibrateController(this);
        mExoPlayerController = new ExoPlayerController(this);
        mTTSController = new TextToSpeechController(this);

        // Helper
        Utils utils = new Utils(this);

        // Start the HTTP server
        //initHttpServer();
        Intent intent = new Intent(this, ServiceHttpServer.class);
        startService(intent);

        // Show the IP address in the title
        setTitle(utils.getIPAddress() + ":" + Constants.DEFAULT_HTTP_PORT);

    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Stop the http service
        //Intent intent = new Intent(this, ServiceHttpServer.class);
        //stopService(intent);

        // Unregister the Bus
        EventBus.getDefault().unregister(this);
    }

    public void setWebViewVisible() {
        mWebView.setVisibility(View.VISIBLE);
        mVideoView.setVisibility(View.GONE);
        mImageView.setVisibility(View.GONE);
        mChart.setVisibility(View.GONE);
        mSurfaceView.setVisibility(View.GONE);
        mVideoSurfaceView.setVisibility(View.GONE);
        mEMVideoView.setVisibility(View.GONE);
    }

    public void setVideoViewVisible() {
        mWebView.setVisibility(View.GONE);
        mVideoView.setVisibility(View.VISIBLE);
        mImageView.setVisibility(View.GONE);
        mChart.setVisibility(View.GONE);
        mSurfaceView.setVisibility(View.GONE);
        mVideoSurfaceView.setVisibility(View.GONE);
        mEMVideoView.setVisibility(View.GONE);
    }

    public void setImageViewVisible() {
        mWebView.setVisibility(View.GONE);
        mVideoView.setVisibility(View.GONE);
        mImageView.setVisibility(View.VISIBLE);
        mChart.setVisibility(View.GONE);
        mSurfaceView.setVisibility(View.GONE);
        mVideoSurfaceView.setVisibility(View.GONE);
        mEMVideoView.setVisibility(View.GONE);
    }

    public void setChartVisible() {
        mWebView.setVisibility(View.GONE);
        mVideoView.setVisibility(View.GONE);
        mImageView.setVisibility(View.GONE);
        mChart.setVisibility(View.VISIBLE);
        mSurfaceView.setVisibility(View.GONE);
        mVideoSurfaceView.setVisibility(View.GONE);
        mEMVideoView.setVisibility(View.GONE);
    }

    public void setSurfaceViewVisible() {
        mWebView.setVisibility(View.GONE);
        mVideoView.setVisibility(View.GONE);
        mImageView.setVisibility(View.GONE);
        mChart.setVisibility(View.GONE);
        mSurfaceView.setVisibility(View.VISIBLE);
        mVideoSurfaceView.setVisibility(View.GONE);
        mEMVideoView.setVisibility(View.GONE);
    }

    public void setVideoSurfaceViewVisible() {
        mWebView.setVisibility(View.GONE);
        mVideoView.setVisibility(View.GONE);
        mImageView.setVisibility(View.GONE);
        mChart.setVisibility(View.GONE);
        mSurfaceView.setVisibility(View.GONE);
        mVideoSurfaceView.setVisibility(View.VISIBLE);
        mEMVideoView.setVisibility(View.GONE);
    }

    public void setEMVideoViewVisible() {
        mWebView.setVisibility(View.GONE);
        mVideoView.setVisibility(View.GONE);
        mImageView.setVisibility(View.GONE);
        mChart.setVisibility(View.GONE);
        mSurfaceView.setVisibility(View.GONE);
        mVideoSurfaceView.setVisibility(View.GONE);
        mEMVideoView.setVisibility(View.VISIBLE);
    }


    public String doAction(Message message) {

        String responseString = null;

        switch (message.getType()) {
            case Constants.IMAGE_PARAMS:
                setWebViewVisible();
                mWebViewController.updateHtml(message);
                break;

            case Constants.EXTERNAL_URL:
                setWebViewVisible();
                mWebViewController.updateUrl(message);
                break;

            case Constants.ROTATION:
                setWebViewVisible();
                mWebViewController.setRotation(message);
                break;

            //case Constants.ZOOMBY:
            //setWebViewVisible();
            //zoomBy(message);
            //break;

            case Constants.ZOOMIN:
                setWebViewVisible();
                mWebViewController.zoomIn();
                break;

            case Constants.ZOOMOUT:
                setWebViewVisible();
                mWebViewController.zoomOut();
                break;

            case Constants.PLAY_AUDIO:
                setWebViewVisible();
                mAudioController.playAudio(message);
                break;

            case Constants.PLAY_VIDEO:
                setVideoViewVisible();
                mVideoController.playVideo(message);
                break;

            case Constants.PLAY_VIDEO_WITH_EXOPLAYER:
                setVideoSurfaceViewVisible();
                mExoPlayerController.playVideo(message);
                break;

            case Constants.PLAY_VIDEO_WITH_EXOMEDIA:
                setEMVideoViewVisible();
                mExoPlayerController.playEMVideo(message);
                break;

            case Constants.ADB_COMMAND:
                // TEST
                setWebViewVisible();
                String out = mADBController.executeADBcommand(message);
                mWebView.loadDataWithBaseURL(null, out.replace("\n", "<br>"), "text/html", "utf-8", null);
                break;

            case Constants.LOAD_IMAGE:
                setImageViewVisible();
                mImageViewController.loadImage(message);
                break;

            case Constants.TAKE_PICTURE:
                dispatchTakePictureIntent();
                break;

            case Constants.CHART:
                setChartVisible();
                mLineChartController.displayChart(message);
                break;

            case Constants.SURFACEVIEW:
                setSurfaceViewVisible();
                mSurfaceViewController.updateSurfaceView(message);
                break;

            case Constants.MONITOR:
                setWebViewVisible();
                mWebViewController.updateHtmlMonitor(message);
                break;

            case Constants.VIBRATE:
                mVibrateController.vibrate(message);
                break;

            case Constants.TEXT_TO_SPEECH:
                mTTSController.speak(message);
                break;

            case Constants.UI:
                // Parcelable vs Serializable
                // Reference: http://www.developerphil.com/parcelable-vs-serializable/
                Intent intent = new Intent(this, AbsoluteLayoutActivity.class);
                intent.putExtra(Constants.EXTRA_MESSAGE, message);
                startActivity(intent);
                break;


            case Constants.SEEKBAR:
                // Parcelable vs Serializable
                // Reference: http://www.developerphil.com/parcelable-vs-serializable/
                intent = new Intent(this, SeekBarActivity.class);
                intent.putExtra(Constants.EXTRA_MESSAGE, message);
                startActivity(intent);
                break;

        }

        return responseString;
    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    // EventBus
    // Reference: Delivery threads and ThreadModes
    // https://github.com/greenrobot/EventBus/blob/master/HOWTO.md
    public void onEventMainThread(Message message) {
        Log.d(TAG, "onEvent: " + message.getType());
        doAction(message);
    }


    // MainView public methods
    //
    // TODO: This code is temporary
    @Override
    public SurfaceView getmSurfaceView() {
        return mSurfaceView;
    }

    @Override
    public VideoView getmVideoView() {
        return mVideoView;
    }

    @Override
    public MediaController getmMediaControls() {
        return mMediaControls;
    }

    @Override
    public DisplayMetrics getmDisplayMetrics() {
        return mDisplayMetrics;
    }

    @Override
    public ImageView getmImageView() {
        return mImageView;
    }

    @Override
    public LineChart getmChart() {
        return mChart;
    }

    @Override
    public WebView getmWebView() {
        return mWebView;
    }

    @Override
    public VideoSurfaceView getmVideoSurfaceView() {
        return mVideoSurfaceView;
    }

    @Override
    public EMVideoView getmEMVideoView() {
        return mEMVideoView;
    }

    // Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
