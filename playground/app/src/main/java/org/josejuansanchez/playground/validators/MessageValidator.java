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

            case Constants.ACCELEROMETER:
                isValid = validateAccelerometerMessage();
                break;

            case Constants.UPDATE_MESSAGE:
                isValid = validateUpdateMessage();
                break;

            case Constants.SURFACEVIEW:
                isValid = validateSurfaceViewMessage();
                break;

            case Constants.SURFACEVIEW_SET_BACKGROUND_COLOR:
                isValid = validateSurfaceViewMessageRGB();
                break;

            case Constants.TEXT_TO_SPEECH:
                isValid = validateTextToSpeechMessage();
                break;

            case Constants.VIBRATE:
                isValid = validateVibrateMessage();
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

    private boolean validateSurfaceViewMessage() {
        // TODO:
        return true;
    }

    private boolean validateSurfaceViewMessageRGB() {
        // TODO:
        return true;
    }

    private boolean validateAccelerometerMessage() {
        // TODO:
        return true;
    }

    private boolean validateTextToSpeechMessage() {
        // TODO:
        return true;
    }

    private boolean validateVibrateMessage() {
        // TODO:
        return true;
    }

    private boolean validateSeekBarMessage() {

        // ids is a mandatory tag
        if (message.getIds() == null) {
            errorMessage.setText("'ids' is a mandatory tag");
            return false;
        }

        if (message.getIds().length <= 0) {
            errorMessage.setText("'ids' must contain at least one element");
            return false;
        }

        // labels and ids tags must contain the same number of elements
        if (message.getLabels() != null) {
            if (message.getLabels().length != message.getIds().length) {
                errorMessage.setText("'labels' and 'ids' tags must contain the same number of elements");
                return false;
            }
        }

        // max_values and ids tags must contain the same number of elements
        if (message.getMaxValues() != null) {
            if (message.getMaxValues().length != message.getIds().length) {
                errorMessage.setText("'max_values' and 'ids' tags must contain the same number of elements");
                return false;
            }
        }

        // min_values and ids tags must contain the same number of elements
        if (message.getMinValues() != null) {
            if (message.getMinValues().length != message.getIds().length) {
                errorMessage.setText("'min_values' and 'ids' tags must contain the same number of elements");
                return false;
            }

            // check that the min_values are lower than the max_values
            int total = message.getIds().length;
            for (int i = 0; i < total; i++) {
                if (message.getMinValues()[i] > message.getMaxValues()[i]) {
                    errorMessage.setText("'min_values' should be lower than 'max_values'");
                    return false;
                }
            }
        }

        // action is a mandatory tag
        if (message.getAction() == null) {
            errorMessage.setText("'action' is a mandatory tag");
            return false;
        }

        // connection is a mandatory tag
        if (message.getAction().getConnection() == null) {
            errorMessage.setText("'action.connection' is a mandatory tag and can be: 'http', 'serial', 'mqtt' or 'bluetooth'");
            return false;
        }

        // uris is a mandatory tag only for HTTP and MQTT
        if (message.getAction().getConnection() == Action.Connectivity.HTTP ||
            message.getAction().getConnection() == Action.Connectivity.MQTT) {

            if (message.getAction().getUris() == null) {
                errorMessage.setText("a valid value for 'uris' tag is needed");
                return false;
            }
        }

        // check the uris and the topic for the mqtt case
        if (message.getAction().getConnection() == Action.Connectivity.MQTT) {

            // We have to check the uris because the MqttClient class only allows tcp, ssl or local.
            int totalUris = message.getAction().getUris().length;
            for(int i=0; i < totalUris; i++) {
                if (!validateMqttURI(message.getAction().getUris()[i])) {
                    errorMessage.setText("the 'uris' should start with 'tcp', 'ssl' or 'local'");
                    return false;
                }
            }

            if (message.getAction().getTopics() == null) {
                errorMessage.setText("a valid value for 'topics' tag is needed");
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
