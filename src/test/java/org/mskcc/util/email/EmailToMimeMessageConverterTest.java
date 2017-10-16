package org.mskcc.util.email;

import org.junit.Test;
import org.mskcc.util.email.formatter.FileGenerationFailureEmailFormatter;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class EmailToMimeMessageConverterTest {
    private EmailToMimeMessageConverter emailToMimeMessageConverter = new EmailToMimeMessageConverter();
    private FileGenerationFailureEmailFormatter fileGenerationFailureEmailFormatter = new FileGenerationFailureEmailFormatter();

    @Test
    public void whenEmailHasNoRecipients_shouldMimeMessageHaveNoRecipients() throws Exception {
        List<String> recipients = new ArrayList<>();
        String from = "from";
        EmailConfiguration config = new EmailConfiguration(recipients, from, "host");
        String subject = "subj";
        Email email = new Email.Builder(config, subject, "msg").build();

        MimeMessage mimeMessage = emailToMimeMessageConverter.convert(email);

        assertThat(mimeMessage.getFrom().length, is(1));
        assertThat(mimeMessage.getFrom()[0], is(new InternetAddress(email.getFrom())));
        assertThat(mimeMessage.getSubject(), is(email.getSubject()));
        assertThat(mimeMessage.getContent(), is(fileGenerationFailureEmailFormatter.format(email)));
        assertNull(mimeMessage.getAllRecipients());
    }

    @Test
    public void whenEmailHasRecipients_shouldMimeMessageHaveThoseRecipients() throws Exception {
        List<String> recipients = Arrays.asList("rec1", "rec2", "rec3");
        String from = "from@me.or.not";
        EmailConfiguration config = new EmailConfiguration(recipients, from, "jakis.tam.host");
        String subject = "subj";
        Email email = new Email.Builder(config, subject, "msg").build();

        MimeMessage mimeMessage = emailToMimeMessageConverter.convert(email);

        assertThat(mimeMessage.getFrom().length, is(1));
        assertThat(mimeMessage.getFrom()[0], is(new InternetAddress(email.getFrom())));
        assertThat(mimeMessage.getSubject(), is(email.getSubject()));
        assertThat(mimeMessage.getContent(), is(fileGenerationFailureEmailFormatter.format(email)));

        assertThat(mimeMessage.getAllRecipients().length, is(3));

        for (Address address : mimeMessage.getAllRecipients()) {
            assertThat(recipients.contains(address.toString()), is(true));
        }
    }
}