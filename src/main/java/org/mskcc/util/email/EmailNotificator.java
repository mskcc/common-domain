package org.mskcc.util.email;

import org.mskcc.util.notificator.Notificator;
import org.mskcc.util.notificator.SendingNotificationException;

import javax.mail.MessagingException;

public abstract class EmailNotificator implements Notificator {
    private final EmailSender emailSender;
    private final EmailConfiguration emailConfiguration;

    public EmailNotificator(EmailSender emailSender, EmailConfiguration emailConfiguration) {
        this.emailSender = emailSender;
        this.emailConfiguration = emailConfiguration;
    }

    @Override
    public void notifyMessage(String requestId, String message) throws Exception {
        Email email = new Email.Builder(emailConfiguration, getSubject(requestId), message)
                .withTitle(getTitle(requestId))
                .withFooter(getFooter())
                .build();

        try {
            emailSender.send(email);
        } catch (MessagingException e) {
            throw new SendingNotificationException(String.format("Unable to send email: %s", email), e);
        }
    }

    protected abstract String getFooter();

    protected abstract String getTitle(String requestId);

    public abstract String getSubject(String requestId);

    @Override
    public String getMessageSeparator() {
        return System.lineSeparator();
    }
}
