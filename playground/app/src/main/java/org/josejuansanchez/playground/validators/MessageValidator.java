package org.josejuansanchez.playground.validators;

import org.josejuansanchez.playground.Constants;
import org.josejuansanchez.playground.model.Action;
import org.josejuansanchez.playground.model.ErrorMessage;
import org.josejuansanchez.playground.model.Message;

/**
 * Created by josejuansanchez on 31/7/15.
 */
public class MessageValidator {

    private Message message;
    private ErrorMessage errorMessage;

    public MessageValidator(Message message) {
        this.message = message;
        this.errorMessage = new ErrorMessage();
    }

    public boolean validateMessage() {
        boolean isValid = false;

        switch (message.getType()) {
            case Constants.WEBVIEW_DISPLAY_IMAGE:
                isValid = validateWebViewDisplayImageMessage();
                break;

            case Constants.ROTATION:
                isValid = validateRotationMessage();
                break;

            case Constants.SEEKBAR:
                isValid = validateSeekBarMessage();
                break;

            case Constants.UPDATE_MESSAGE:
                isValid = validateUpdateMessage();
                break;
        }
        return isValid;
    }

    private boolean validateWebViewDisplayImageMessage() {
        // TODO:
        return true;
    }

    private boolean validateRotationMessage() {
        // TODO:
        return true;
    }

    private boolean validateUpdateMessage() {
        // TODO:
        return true;
    }

    private boolean validateSeekBarMessage() {

        // labels is a mandatory tag
        if (message.getLabels() == null) {
            errorMessage.setText("'labels' is a mandatory tag");
            return false;
        }

        if (message.getLabels().length <= 0) {
            errorMessage.setText("'labels' must contain at least one element");
            return false;
        }

        // max_values and labels tags must contain the same number of elements
        if (message.getMaxValues() != null) {
            if (message.getMaxValues().length != message.getLabels().length) {
                errorMessage.setText("'max_values' and 'labels' tags must contain the same number of elements");
                return false;
            }
        }

        // min_values and labels tags must contain the same number of elements
        if (message.getMinValues() != null) {
            if (message.getMinValues().length != message.getLabels().length) {
                errorMessage.setText("'min_values' and 'labels' tags must contain the same number of elements");
                return false;
            }
        }

        if (message.getAction() == null) {
            errorMessage.setText("'action' is a mandatory tag");
            return false;
        }

        if (message.getAction().getConnection() == null) {
            errorMessage.setText("'action.connection' is a mandatory tag and can be: 'http', 'serial', 'mqtt' or 'bluetooth'");
            return false;
        }

        if (message.getAction().getConnection() == Action.Connectivity.HTTP) {
            if (message.getAction().getUri() == null) {
                errorMessage.setText("a valid value for 'uri' tag is needed");
                return false;
            }
        }

        if (message.getAction().getConnection() == Action.Connectivity.MQTT) {
            if (message.getAction().getUri() == null) {
                errorMessage.setText("a valid value for 'uri' tag is needed");
                return false;
            }

            // We have to check the uri because the MqttClient class only allows tcp, ssl or local.
            if (!validateMqttURI(message.getAction().getUri())) {
                errorMessage.setText("the 'uri' should start with 'tcp', 'ssl' or 'local'");
                return false;
            }

            if (message.getAction().getTopic() == null) {
                errorMessage.setText("a valid value for 'topic' tag is needed");
                return false;
            }
        }

        return true;
    }

    public boolean validateMqttURI(String uri) {
        if (uri.startsWith("tcp://") || uri.startsWith("ssl://") || uri.startsWith("local://")) {
            return true;
        } else {
            return false;
        }

    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }
}
