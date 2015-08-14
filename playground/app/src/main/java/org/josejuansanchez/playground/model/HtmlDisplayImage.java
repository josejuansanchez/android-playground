package org.josejuansanchez.playground.model;

/**
 * Created by josejuansanchez on 26/04/15.
 */
public class HtmlDisplayImage {
    private String source;
    private String urlImage;
    private int x;
    private int y;
    private int width;
    private int height;
    private final String TAG_URL_IMAGE = "\\{:url_image:\\}";
    private final String TAG_X = "\\{:x:\\}";
    private final String TAG_Y = "\\{:y:\\}";
    private final String TAG_WIDTH = "\\{:width:\\}";
    private final String TAG_HEIGHT = "\\{:height:\\}";


    private static HtmlDisplayImage instance = new HtmlDisplayImage();

    public static HtmlDisplayImage getInstance() {
        return instance;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public String geturlImage() {
        return urlImage;
    }

    public void seturlImage(String urlImage) {
        this.urlImage = urlImage;

        // Replace the "urlImage" string in the html source
        source = source.replaceAll(TAG_URL_IMAGE, urlImage);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;

        // Replace the "x" string in the html source
        source = source.replaceAll(TAG_X, String.valueOf(x));
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;

        // Replace the "y" string in the html source
        source = source.replaceAll(TAG_Y, String.valueOf(y));
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;

        // Replace the "width" string in the html source
        source = source.replaceAll(TAG_WIDTH, String.valueOf(width));
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;

        // Replace the "height" string in the html source
        source = source.replaceAll(TAG_HEIGHT, String.valueOf(height));
    }
}
