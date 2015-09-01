package org.josejuansanchez.playground.model;

import java.io.Serializable;

/**
 * Created by josejuansanchez on 01/05/15.
 */
public class Message implements Serializable {

    private int type;
    private String url;
    private int x;
    private int y;
    private int width;
    private int height;
    private int offset_x;
    private int offset_y;
    private float rotation;
    private float zoomFactor;
    private String command;
    private Transformation transformation;
    private String label;
    private String value;
    private String timestamp;
    private long milliseconds;
    private String text;
    private String labels[];
    private Action action;
    private int max_values[];
    private int min_values[];
    private int initial_values[];
    private int r;
    private int g;
    private int b;

    public Message(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public int getOffsetX() {
        return offset_x;
    }

    public void setOffsetX(int offset_x) {
        this.offset_x = offset_x;
    }

    public int getOffsetY() {
        return offset_y;
    }

    public void setOffsetY(int offset_y) {
        this.offset_y = offset_y;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public float getZoomFactor() {
        return zoomFactor;
    }

    public void setZoomFactor(float zoomFactor) {
        this.zoomFactor = zoomFactor;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Transformation getTransformation() {
        return transformation;
    }

    public void setTransformation(Transformation transformation) {
        this.transformation = transformation;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public long getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int[] getMaxValues() {
        return max_values;
    }

    public void setMaxValues(int[] max_values) {
        this.max_values = max_values;
    }

    public int[] getMinValues() {
        return min_values;
    }

    public void setMinValues(int[] min_values) {
        this.min_values = min_values;
    }

    public int[] getInitialValues() {
        return initial_values;
    }

    public void setInitialValues(int[] initial_values) {
        this.initial_values = initial_values;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
