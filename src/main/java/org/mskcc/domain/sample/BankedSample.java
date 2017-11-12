package org.mskcc.domain.sample;

import java.util.Map;

public class BankedSample extends Sample {
    public static final String DATA_TYPE_NAME = "BankedSample";
    public static final String BARCODE_ID = "BarcodeId";
    public static final String INVESTIGATOR = "Investigator";
    public static final String PROMOTED = "Promoted";
    public static final String REQUESTED_READS = "RequestedReads";
    public static final String RUN_TYPE = "RunType";
    public static final String SAMPLE_CLASS = "SampleClass";
    public static final String SERVICE_ID = "ServiceId";
    public static final String TISSUE_SITE = "TissueSite";

    public BankedSample(String sampleId) {
        super(sampleId);
    }

    public BankedSample(Map<String, Object> fields) {
        super((String) fields.get(USER_SAMPLE_ID));
        this.fields = fields;
    }

    public String getRunType() {
        return (String) fields.get(RUN_TYPE);
    }

    public void setRunType(String value) {
        fields.put(RUN_TYPE, value);
    }

    public Double getRequestedReads() {
        return (Double) fields.get(REQUESTED_READS);
    }

    public void setRequestedReads(Double value) {
        fields.put(REQUESTED_READS, value);
    }

    public String getInvestigator() {
        return (String) fields.get(INVESTIGATOR);
    }

    public void setInvestigator(String value) {
        fields.put(INVESTIGATOR, value);
    }

    public String getBarcodeId() {
        return (String) fields.get(BARCODE_ID);
    }

    public void setBarcodeId(String value) {
        fields.put(BARCODE_ID, value);
    }

    public Boolean getPromoted() {
        return (Boolean) fields.get(PROMOTED);
    }

    public void setPromoted(Boolean value) {
        fields.put(PROMOTED, value);
    }

    public String getServiceId() {
        return (String) fields.get(SERVICE_ID);
    }

    public void setServiceId(String value) {
        fields.put(SERVICE_ID, value);
    }

    public String getSampleClass() {
        return (String) fields.get(SAMPLE_CLASS);
    }

    public void setSampleClass(String value) {
        fields.put(SAMPLE_CLASS, value);
    }

    @Override
    public String getSampleId() {
        return getUserSampleID();
    }
}
