package org.mskcc.util.email;

import org.mskcc.util.email.formatter.FileGenerationFailureEmailFormatter;

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

public class EmailToMimeMessageConverter {
    private FileGenerationFailureEmailFormatter fileGenerationFailureEmailFormatter = new FileGenerationFailureEmailFormatter();

    public MimeMessage convert(Email email) throws MessagingException {
        Properties props = System.getProperties();
        props.put("mail.smtp.host", email.getHost());
        Session mailSession = Session.getDefaultInstance(props, null);

        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress(email.getFrom()));
        addRecipients(email, message);
        message.setSubject(email.getSubject());
        message.setText(getMessage(email));
        message.setSentDate(new Date());

        addFilesIfExist(email, message);
        return message;
    }

    private String getMessage(Email email) {
        return fileGenerationFailureEmailFormatter.format(email);
    }

    private void addRecipients(Email email, MimeMessage message) throws MessagingException {
        InternetAddress[] addresses = new InternetAddress[email.getRecipients().size()];

        for (int i = 0; i < email.getRecipients().size(); i++) {
            addresses[i] = new InternetAddress(email.getRecipients().get(i));
        }

        message.addRecipients(Message.RecipientType.TO, addresses);
    }

    private void addFilesIfExist(Email email, MimeMessage message) throws MessagingException {
        if (email.getFiles().size() > 0) {
            Multipart multipart = new MimeMultipart();
            BodyPart messageParts = new MimeBodyPart();

            messageParts.setText(getMessage(email) + "\n");
            multipart.addBodyPart(messageParts);

            for (String fileName : email.getFiles()) {
                messageParts = new MimeBodyPart();
                DataSource source = new FileDataSource(fileName);
                messageParts.setDataHandler(new DataHandler(source));
                String[] nameParts = fileName.split("/");
                String name = nameParts[nameParts.length - 1];
                messageParts.setFileName(name);
                multipart.addBodyPart(messageParts);
            }

            message.setContent(multipart);
        }
    }

}
