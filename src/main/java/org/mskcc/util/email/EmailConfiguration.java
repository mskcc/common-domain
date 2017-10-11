package org.mskcc.util.email;

import java.util.List;

public class EmailConfiguration {
    private final List<String> recipients;
    private final String from;
    private final String host;

    public EmailConfiguration(List<String> recipients, String from, String host) {
        this.recipients = recipients;
        this.from = from;
        this.host = host;
    }

    @Override
    public String toString() {
        return "EmailConfiguration{" +
                "recipients=" + recipients +
                ", from='" + from + '\'' +
                ", host='" + host + '\'' +
                '}';
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public String getFrom() {
        return from;
    }

    public String getHost() {
        return host;
    }
}
