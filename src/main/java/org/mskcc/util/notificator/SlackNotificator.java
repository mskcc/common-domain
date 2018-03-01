package org.mskcc.util.notificator;

import org.apache.log4j.Logger;
import org.mskcc.util.http.CurlCaller;
import org.mskcc.util.http.ProcessBuilderCurlCaller;

public class SlackNotificator implements Notificator {
    private static final Logger LOGGER = Logger.getLogger(SlackNotificator.class);

    private static final String SLACK_RESPONSE_SUCCESS = "ok";
    private final String webhookUrl;
    private final String channel;
    private final String user;
    private final String icon;
    private final CurlCaller curlCaller = new ProcessBuilderCurlCaller();

    public SlackNotificator(String webhookUrl, String channel, String user, String icon) {
        this.webhookUrl = webhookUrl;
        this.channel = channel;
        this.user = user;
        this.icon = icon;
    }

    @Override
    public void notifyMessage(String requestId, String message) throws Exception {
        String payload = getMessage(message);
        LOGGER.info(String.format("Sending Slack notification to channel: %s with message: %s", channel, payload));

        String[] parameters = {"curl", "-X", "POST", "--data-urlencode", payload, webhookUrl};
        String response = curlCaller.call(parameters);
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
