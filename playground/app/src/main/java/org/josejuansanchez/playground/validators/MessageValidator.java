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
            case Constants.SEEKBAR:
                isValid = validateSeekBarMessage();
                break;
        }
        return isValid;
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

            if (message.getAction().getTopic() == null) {
                errorMessage.setText("a valid value for 'topic' tag is needed");
                return false;
            }
        }

        return true;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }
}
