package org.mskcc.util.email;

import javax.mail.MessagingException;

public interface Notificator {
    void notifyMessage(String requestId, String message) throws Exception;

    String getMessageSeparator();
}
