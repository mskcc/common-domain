package org.mskcc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class JavaxEmailSender implements EmailSender {
    private static final Logger LOGGER = LoggerFactory.getLogger(JavaxEmailSender.class);

    @Override
    public void send(String from, String to, String host, String subject, String text) throws MessagingException {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        Session mailSession = Session.getDefaultInstance(props, null);

        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(from));
        String[] recipients = to.split(",");
        InternetAddress[] addresses = new InternetAddress[recipients.length];

        for (int i = 0; i < recipients.length; i++) {
            addresses[i] = new InternetAddress(recipients[i]);
        }
        message.addRecipients(Message.RecipientType.TO, addresses);
        message.setSubject(subject);
        message.setText(text);
        message.setSentDate(new Date());

        LOGGER.info(String.format("Sending email from: %s to: %s using host: %s with subject: %s", from, to, host, subject));
        Transport.send(message);
    }

    @Override
    public void sendWithFiles(String from, String to, String host, String subject, String text, String files) throws MessagingException {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", host);
        Session mailSession = Session.getDefaultInstance(props, null);

        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(from));
        String[] recipients = to.split(",");
        InternetAddress[] addresses = new InternetAddress[recipients.length];

        for (int i = 0; i < recipients.length; i++) {
            addresses[i] = new InternetAddress(recipients[i]);
        }
        message.addRecipients(Message.RecipientType.TO, addresses);
        message.setSubject(subject);
        // This is a multipart message, so create Multipart (message) and add the BodyParts
        Multipart multipart = new MimeMultipart();
        BodyPart messageParts = new MimeBodyPart();

        // First add the body text
        messageParts.setText(text + "\n");
        multipart.addBodyPart(messageParts);

        //Next add files
        String[] filenames = files.split(",");

        for (int x = 0; x < filenames.length; x++) {
            messageParts = new MimeBodyPart();
            DataSource source = new FileDataSource(filenames[x]);
            messageParts.setDataHandler(new DataHandler(source));
            String[] nameParts = filenames[x].split("/");
            String name = nameParts[nameParts.length - 1];
            messageParts.setFileName(name);
            multipart.addBodyPart(messageParts);
        }

        // Now set content to multipart
        message.setContent(multipart);

        message.setSentDate(new Date());

        LOGGER.info(String.format("Sending email with files from: %s to: %s using host: %s with subject: %s", from, to, host, subject));
        Transport.send(message);
    }
}
