package org.mskcc.util.email.formatter;

import org.mskcc.util.email.Email;

public class FileGenerationFailureEmailFormatter {
    public String format(Email email) {
        return String.format("%s\n\n%s\n\n%s", email.getTitle(), email.getMessage(), email.getFooter());
    }
}
