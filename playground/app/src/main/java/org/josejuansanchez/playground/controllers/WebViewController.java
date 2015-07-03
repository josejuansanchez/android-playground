package org.josejuansanchez.playground.controllers;

import org.josejuansanchez.playground.MainActivity;
import org.josejuansanchez.playground.Utils;
import org.josejuansanchez.playground.model.Html;
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
        Html.getInstance().seturlImage(url);
        mContext.getmWebView().loadDataWithBaseURL(null, Html.getInstance().getSource(), "text/html", "utf-8", null);
    }

    public void updateImageXPosition(int x) {
        Html.getInstance().setX(x);
        mContext.getmWebView().loadDataWithBaseURL(null, Html.getInstance().getSource(), "text/html", "utf-8", null);
    }

    public void updateImageYPosition(int y) {
        Html.getInstance().setY(y);
        mContext.getmWebView().loadDataWithBaseURL(null, Html.getInstance().getSource(), "text/html", "utf-8", null);
    }

    public void updateWidthAndHeight(int width, int height) {
        Html.getInstance().setWidth(width);
        Html.getInstance().setHeight(height);
        mContext.getmWebView().loadDataWithBaseURL(null, Html.getInstance().getSource(), "text/html", "utf-8", null);
    }

    public void updateHtml(Message message) {
        Html.getInstance().seturlImage(message.getUrl());
        Html.getInstance().setX(message.getX());
        Html.getInstance().setY(message.getY());
        Html.getInstance().setWidth(message.getWidth());
        Html.getInstance().setHeight(message.getHeight());
        mContext.getmWebView().loadDataWithBaseURL(null, Html.getInstance().getSource(), "text/html", "utf-8", null);
    }

    public void updateUrl(Message message) {
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

    public void updateHtmlMonitor(Message message) {

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
