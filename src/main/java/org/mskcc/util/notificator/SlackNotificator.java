package org.mskcc.util.notificator;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SlackNotificator implements Notificator {
    private static final Logger LOGGER = Logger.getLogger(SlackNotificator.class);

    private final String webhookUrl;
    private final String channel;
    private final String user;
    private final String icon;

    public SlackNotificator(String webhookUrl, String channel, String user, String icon) {
        this.webhookUrl = webhookUrl;
        this.channel = channel;
        this.user = user;
        this.icon = icon;
    }

    @Override
    public void notifyMessage(String requestId, String message) throws Exception {
        LOGGER.info(String.format("Sending Slack notification to channel: %s", channel));

        ProcessBuilder processBuilder = new ProcessBuilder("curl", "-X", "POST", "--data-urlencode", getMessage
                (message), webhookUrl);
        Process process = processBuilder.start();

        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder responseStrBuilder = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            responseStrBuilder.append(line);
        }

        LOGGER.info(String.format("Slack notification response: %s", responseStrBuilder.toString()));
    }

    private String getMessage(String message) {
        return String.format("payload={\"channel\": \"%s\", \"username\": \"%s\", \"text\": \"%s\", \"icon_emoji\": " +
                "\"%s\"}", channel, user, message, icon);
    }

    @Override
    public String getMessageSeparator() {
        return System.lineSeparator();
    }
}
