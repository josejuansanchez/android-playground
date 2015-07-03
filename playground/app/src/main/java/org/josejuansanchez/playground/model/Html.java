package org.josejuansanchez.playground.model;

/**
 * Created by josejuansanchez on 26/04/15.
 */
public class Html {
    private String urlImage;
    private int x;
    private int y;
    private int width;
    private int height;

    private static Html instance = new Html();

    public static Html getInstance() {
        return instance;
    }

    public String getSource() {
        String html =
                "<html>" +
                "<head>" +
                "<meta name=\"viewport\" content=\"initial-scale=1, maximum-scale=1, user-scalable=no, width=device-width\">" +
                "<style type=\"text/css\">" +
                "body {" +
                "   margin: 0 !important;" +
                "   padding: 0 !important;" +
                "}" +
                "#img {" +
                "    background-image: url(" + urlImage + ");" +
                "    background-repeat: no-repeat;" +
                "    background-position: " + x + "px " + y + "px;" +
                "    width: " + width + "px;" +
                "    height: " + height + "px;" +
                "}" +
                "</style>" +
                "</head>" +
                "<body><div id=\"img\"></div></body></html>";

        return html;
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
}
