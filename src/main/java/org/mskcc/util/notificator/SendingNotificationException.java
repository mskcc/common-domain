package org.mskcc.util.notificator;

public class SendingNotificationException extends Exception {
    public SendingNotificationException(String errorMessage) {
        super(errorMessage);
    }

    public SendingNotificationException(String message, Exception e) {
        super(message, e);
    }
}
