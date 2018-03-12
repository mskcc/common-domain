package org.mskcc.domain;

import java.util.HashMap;
import java.util.Map;

public enum QcStatus {
    FAILED("Failed"),
    NEW_LIBRARY_NEEDED("New-Library-Needed"),
    PASSED("Passed"),
    RECAPTURE_SAMPLE("Recapture-Sample"),
    REPOOL_SAMPLE("Repool-Sample"),
    REQUIRED_ADDITIONAL_READS("Required-Additional-Reads"),
    RESEQUENCE_POOL("Resequence-Pool"),
    UNDER_REVIEW("Under-Review");

    private static final Map<String, QcStatus> valueToQcStatus = new HashMap<>();

    static {
        for (QcStatus qcStatus : values()) {
            valueToQcStatus.put(qcStatus.value, qcStatus);
        }
    }

    private String value;

    QcStatus(String value) {
        this.value = value;
    }

    public static QcStatus getByValue(String value) {
        if(!valueToQcStatus.containsKey(value))
            throw new RuntimeException(String.format("Qc status: %s doesn't exist", value));

        return valueToQcStatus.get(value);
    }

    public String getValue() {
        return value;
    }
}
