package org.josejuansanchez.playground.controllers;

import org.josejuansanchez.playground.MainActivity;
import org.josejuansanchez.playground.Utils;
import org.josejuansanchez.playground.model.HtmlDisplayImage;
import org.josejuansanchez.playground.model.HtmlMonitor;
import org.josejuansanchez.playground.model.Message;

/**
 * Created by josejuansanchez on 25/06/15.
 */
public class WebViewController {
    private static final String TAG = "WebViewController";
    private MainActivity mContext;

    public WebViewController(MainActivity mContext) {
        this.mContext = mContext;
    }

    public void updateImageUrl(String url) {
        HtmlDisplayImage.getInstance().seturlImage(url);
        mContext.getmWebView().loadDataWithBaseURL(null, HtmlDisplayImage.getInstance().getSource(), "text/html", "utf-8", null);
    }

    public void updateImageXPosition(int x) {
        HtmlDisplayImage.getInstance().setX(x);
        mContext.getmWebView().loadDataWithBaseURL(null, HtmlDisplayImage.getInstance().getSource(), "text/html", "utf-8", null);
    }

    public void updateImageYPosition(int y) {
        HtmlDisplayImage.getInstance().setY(y);
        mContext.getmWebView().loadDataWithBaseURL(null, HtmlDisplayImage.getInstance().getSource(), "text/html", "utf-8", null);
    }

    public void updateWidthAndHeight(int width, int height) {
        HtmlDisplayImage.getInstance().setWidth(width);
        HtmlDisplayImage.getInstance().setHeight(height);
        mContext.getmWebView().loadDataWithBaseURL(null, HtmlDisplayImage.getInstance().getSource(), "text/html", "utf-8", null);
    }

    public void loadHtmlDisplayImage(Message message) {

        // TODO: Find a better and efficient solution.
        //       Is not a good idea to read the file from disk every time the method is called.
        //       The templates could be read from disk only once when the app is started.
        //
        // Load html source from assets
        Utils utils = new Utils(mContext);
        String source = utils.loadFileFromAssets("html-templates/display-image.html");

        // TODO: Implement error management
        if (source == null) {
            return;
        }

        // Update the html
        HtmlDisplayImage.getInstance().setSource(source);
        HtmlDisplayImage.getInstance().seturlImage(message.getUrl());
        HtmlDisplayImage.getInstance().setX(message.getX());
        HtmlDisplayImage.getInstance().setY(message.getY());
        HtmlDisplayImage.getInstance().setWidth(message.getWidth());
        HtmlDisplayImage.getInstance().setHeight(message.getHeight());
        mContext.getmWebView().loadDataWithBaseURL(null, HtmlDisplayImage.getInstance().getSource(), "text/html", "utf-8", null);
    }

    // TODO:
    public void update(Message message) {

        // TODO: Find a better and efficient solution.
        //       Is not a good idea to read the file from disk every time the method is called.
        //       The templates could be read from disk only once when the app is started.
        //
        // Load html source from assets
        Utils utils = new Utils(mContext);
        String source = utils.loadFileFromAssets("html-templates/display-image.html");

        // TODO: Implement error management
        if (source == null) {
            return;
        }

        HtmlDisplayImage.getInstance().setSource(source);

        if (message.getUrl() != null) {
            HtmlDisplayImage.getInstance().seturlImage(message.getUrl());
        }

        // TODO:
        // We need an efficient way that allows us to know which are the
        // attributes that should be updated.
        // Problematic cases: message.getX(), message.getY(), message.getWidth, message.getHeight()

        // Update the html
        mContext.getmWebView().loadDataWithBaseURL(null, HtmlDisplayImage.getInstance().getSource(), "text/html", "utf-8", null);
    }

    public void loadUrl(Message message) {
        mContext.getmWebView().loadUrl(message.getUrl());
    }

    public void setRotation(Message message) {
        mContext.getmWebView().setRotation(message.getRotation());
    }

    // Requires API level 21
    /*
    public void zoomBy(Message message) {
        mWebView.zoomBy(message.getZoomFactor());
    }
    */

    public void zoomIn() {
        mContext.getmWebView().zoomIn();
    }

    public void zoomOut() {
        mContext.getmWebView().zoomOut();
    }

    public void loadHtmlMonitor(Message message) {

        // TODO: Find a better and efficient solution.
        //       Is not a good idea to read the file from disk every time the method is called.
        //       The templates could be read from disk only once when the app is started.
        //
        // Load html source from assets
        Utils utils = new Utils(mContext);
        String source = utils.loadFileFromAssets("html-templates/monitor.html");

        // TODO: Implement error management
        if (source == null) {
            return;
        }

        // Update the html
        HtmlMonitor.getInstance().setSource(source);
        HtmlMonitor.getInstance().setLabel(message.getLabel());
        HtmlMonitor.getInstance().setValue(message.getValue());
        HtmlMonitor.getInstance().setTimestamp(message.getTimestamp());
        mContext.getmWebView().loadDataWithBaseURL(null, HtmlMonitor.getInstance().getSource(), "text/html", "utf-8", null);
    }
}
