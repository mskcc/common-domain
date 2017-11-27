package org.mskcc.util.notificator;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SlackNotificator implements Notificator {
    public static final String SLACK_RESPONSE_SUCCESS = "ok";
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

        String[] parameters = {"curl", "-X", "POST", "--data-urlencode", getMessage
                (message), webhookUrl};
        ProcessBuilder processBuilder = new ProcessBuilder(parameters);
        Process process = processBuilder.start();

        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder responseStrBuilder = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            responseStrBuilder.append(line);
        }

        String response = responseStrBuilder.toString();
        if (!response.startsWith(SLACK_RESPONSE_SUCCESS)) {
            String errorMessage = String.format("Slack notification not sent to channel: %s with message: %s. Cause: " +
                            "%s",
                    channel, message, response);
            LOGGER.warn(errorMessage);
            throw new SendingNotificationException(errorMessage);
        }
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
