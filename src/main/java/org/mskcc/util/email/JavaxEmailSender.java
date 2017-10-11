package org.mskcc.util.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class JavaxEmailSender implements EmailSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(JavaxEmailSender.class);
    private EmailToMimeMessageConverter emailToMimeMessageConverter;

    public JavaxEmailSender(EmailToMimeMessageConverter emailToMimeMessageConverter) {
        this.emailToMimeMessageConverter = emailToMimeMessageConverter;
    }

    @Override
    public void send(Email email) throws MessagingException {
        MimeMessage mimeMessage = emailToMimeMessageConverter.convert(email);

        LOGGER.info(String.format("Sending email: %s", email));

        Transport.send(mimeMessage);
    }
}
