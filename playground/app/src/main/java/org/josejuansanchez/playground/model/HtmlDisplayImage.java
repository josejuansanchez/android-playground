package org.josejuansanchez.playground.model;

/**
 * Created by josejuansanchez on 26/04/15.
 */
public class HtmlDisplayImage {
    private String html;
    private String template;
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


    private static HtmlDisplayImage instance = null;

    public static HtmlDisplayImage getInstance() {
        if (instance == null) {
            instance = new HtmlDisplayImage();
        }
        return instance;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }

    public String geturlImage() {
        return urlImage;
    }

    public void seturlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getHtml() {

        html = template;

        // Replace the "urlImage" string in the html template
        html = html.replaceAll(TAG_URL_IMAGE, urlImage);

        // Replace the "x" string in the html template
        html = html.replaceAll(TAG_X, String.valueOf(x));

        // Replace the "y" string in the html template
        html = html.replaceAll(TAG_Y, String.valueOf(y));

        // Replace the "width" string in the html template
        html = html.replaceAll(TAG_WIDTH, String.valueOf(width));

        // Replace the "height" string in the html template
        html = html.replaceAll(TAG_HEIGHT, String.valueOf(height));

        return html;
    }
}
