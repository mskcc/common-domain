package org.mskcc.util.email;

import javax.mail.MessagingException;

public interface EmailSender {
    void send(Email email) throws MessagingException;
}
