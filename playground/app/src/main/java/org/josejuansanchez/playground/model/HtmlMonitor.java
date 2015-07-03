package org.josejuansanchez.playground.model;

/**
 * Created by josejuansanchez on 26/06/15.
 */
public class HtmlMonitor {
    private String source;
    private String label;
    private String value;
    private String timestamp;
    private final String TAG_LABEL = "\\{:label:\\}";
    private final String TAG_VALUE = "\\{:value:\\}";
    private final String TAG_TIMESTAMP = "\\{:timestamp:\\}";

    private static HtmlMonitor instance = new HtmlMonitor();
    public static HtmlMonitor getInstance() {
        return instance;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setLabel(String label) {
        this.label = label;

        // Replace the "label" string in the html source
        source = source.replaceAll(TAG_LABEL, label);
    }

    public void setValue(String value) {
        this.value = value;

        // Replace the "value" string in the html source
        source = source.replaceAll(TAG_VALUE, value);
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;

        // Replace the "timestamp" string in the html source
        source = source.replaceAll(TAG_TIMESTAMP, timestamp);
    }
}