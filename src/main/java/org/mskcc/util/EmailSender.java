package org.mskcc.util;

import javax.mail.MessagingException;

public interface EmailSender {
    void send(String from, String to, String host, String subject, String text) throws MessagingException;

    void sendWithFiles(String from, String to, String host, String subject, String text, String files) throws MessagingException;
}
