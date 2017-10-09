package org.mskcc.domain.sample;

public class NotAvailableSample extends Sample {
    private final String naId = "na";

    public NotAvailableSample() {
        super("na");
    }

    @Override
    public String getCmoSampleId() {
        return naId;
    }
}
