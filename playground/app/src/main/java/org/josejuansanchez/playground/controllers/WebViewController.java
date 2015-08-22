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

    public void loadHtmlDisplayImage(Message message) {

        // TODO: Find a better and efficient solution.
        //       Is not a good idea to read the file from disk every time the method is called.
        //       The templates could be read from disk only once when the app is started.
        //
        // Load html template from assets
        Utils utils = new Utils(mContext);
        String template = utils.loadFileFromAssets("html-templates/display-image.html");

        // TODO: Implement error management
        if (template == null) {
            return;
        }

        // Update the html
        HtmlDisplayImage.getInstance().setTemplate(template);
        HtmlDisplayImage.getInstance().seturlImage(message.getUrl());
        HtmlDisplayImage.getInstance().setX(message.getX());
        HtmlDisplayImage.getInstance().setY(message.getY());
        HtmlDisplayImage.getInstance().setWidth(message.getWidth());
        HtmlDisplayImage.getInstance().setHeight(message.getHeight());
        HtmlDisplayImage.getInstance().setX(message.getOffsetX());
        HtmlDisplayImage.getInstance().setY(message.getOffsetY());
        mContext.getmWebView().loadDataWithBaseURL(null, HtmlDisplayImage.getInstance().getHtml(), "text/html", "utf-8", null);
    }

    public void updateXYDisplayImage(Message message) {
        HtmlDisplayImage.getInstance().setX(message.getX());
        HtmlDisplayImage.getInstance().setY(message.getY());
        mContext.getmWebView().loadDataWithBaseURL(null, HtmlDisplayImage.getInstance().getHtml(), "text/html", "utf-8", null);
    }

    public void updateWidthHeightDisplayImage(Message message) {
        HtmlDisplayImage.getInstance().setWidth(message.getWidth());
        HtmlDisplayImage.getInstance().setHeight(message.getHeight());
        mContext.getmWebView().loadDataWithBaseURL(null, HtmlDisplayImage.getInstance().getHtml(), "text/html", "utf-8", null);
    }

    public void updateOffset(Message message) {
        HtmlDisplayImage.getInstance().setOffsetX(message.getOffsetX());
        HtmlDisplayImage.getInstance().setOffsetY(message.getOffsetY());
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
