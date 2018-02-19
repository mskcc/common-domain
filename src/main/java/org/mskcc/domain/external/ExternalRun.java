package org.mskcc.domain.external;

public class ExternalRun {
    private String realRunId;
    private String anonymizedId = "";

    // default contructor for JPA
    protected ExternalRun() {
    }

    public ExternalRun(String realRunId) {
        this.realRunId = realRunId;
    }

    public ExternalRun(String realRunId, String anonymizedId) {
        this.realRunId = realRunId;
        this.anonymizedId = anonymizedId;
    }

    public String getRealRunId() {
        return realRunId;
    }

    public String getAnonymizedId() {
        return anonymizedId;
    }

    @Override
    public String toString() {
        return "ExternalRun{" +
                "realRunId='" + realRunId + '\'' +
                ", anonymizedId='" + anonymizedId + '\'' +
                '}';
    }
}
