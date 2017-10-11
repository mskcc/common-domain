package org.mskcc.util.email;

import java.util.ArrayList;
import java.util.List;

public class Email {
    private final EmailConfiguration emailConfiguration;
    private final String subject;
    private final String title;
    private final String message;
    private final String footer;
    private final List<String> files;

    private Email(Builder builder) {
        emailConfiguration = builder.getEmailConfiguration();
        subject = builder.getSubject();
        title = builder.getTitle();
        message = builder.getMessage();
        footer = builder.getFooter();
        files = builder.files;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailConfiguration=" + emailConfiguration +
                ", subject='" + subject + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", footer='" + footer + '\'' +
                ", files=" + files +
                '}';
    }

    public String getSubject() {
        return subject;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getFooter() {
        return footer;
    }

    public EmailConfiguration getEmailConfiguration() {
        return emailConfiguration;
    }

    public List<String> getFiles() {
        return files;
    }

    public String getHost() {
        return emailConfiguration.getHost();
    }

    public String getFrom() {
        return emailConfiguration.getFrom();
    }

    public List<String> getRecipients() {
        return emailConfiguration.getRecipients();
    }

    public static class Builder {
        private final EmailConfiguration emailConfiguration;
        private final String subject;
        private final String message;
        private String title = "";
        private String footer = "";
        private List<String> files = new ArrayList<>();

        public Builder(EmailConfiguration emailConfiguration, String subject, String message) {
            this.emailConfiguration = emailConfiguration;
            this.subject = subject;
            this.message = message;
        }

        public EmailConfiguration getEmailConfiguration() {
            return emailConfiguration;
        }

        public Email build() {
            return new Email(this);
        }

        public String getSubject() {
            return subject;
        }

        public String getMessage() {
            return message;
        }

        public String getTitle() {
            return title;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public String getFooter() {
            return footer;
        }

        public Builder withFooter(String footer) {
            this.footer = footer;
            return this;
        }

        public Builder withFiles(List<String> files) {
            this.files = files;
            return this;
        }
    }
}
