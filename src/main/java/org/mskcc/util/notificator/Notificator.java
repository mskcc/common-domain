package org.mskcc.util.notificator;

public interface Notificator {
    void notifyMessage(String requestId, String message) throws Exception;

    String getMessageSeparator();
}
