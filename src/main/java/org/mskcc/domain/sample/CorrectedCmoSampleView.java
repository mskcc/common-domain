package org.mskcc.domain.sample;

import org.mskcc.util.CommonUtils;

/**
 * CorrectedCmoSampleView stores data needed to create all types of CMO Sample Id. Different Type of samples (eg.
 * Sample and Banked Sample) are converted to CorrectedCmoSampleView to have CMO Sample Id generated.
 */
public class CorrectedCmoSampleView {
    private final String id;
    private String sampleId;
    private String requestId;
    private String patientId;
    private SampleClass sampleClass;
    private SampleOrigin sampleOrigin;
    private SpecimenType specimenType;
    private NucleicAcid nucleidAcid;
    private Integer counter;
    private String correctedCmoId = "";
    private SampleType sampleType;

    public CorrectedCmoSampleView(String id) {
        CommonUtils.requireNonNullNorEmpty(id, String.format("Id is not set"));
        this.id = id;
    }

    public String getCorrectedCmoId() {
        return correctedCmoId;
    }

    public void setCorrectedCmoId(String correctedCmoId) {
        this.correctedCmoId = correctedCmoId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getSampleId() {
        return sampleId;
    }

    public void setSampleId(String sampleId) {
        this.sampleId = sampleId;
    }

    public SampleClass getSampleClass() {
        return sampleClass;
    }

    public void setSampleClass(SampleClass sampleClass) {
        this.sampleClass = sampleClass;
    }

    public SampleOrigin getSampleOrigin() {
        return sampleOrigin;
    }

    public void setSampleOrigin(SampleOrigin sampleOrigin) {
        this.sampleOrigin = sampleOrigin;
    }

    public SpecimenType getSpecimenType() {
        return specimenType;
    }

    public void setSpecimenType(SpecimenType specimenType) {
        this.specimenType = specimenType;
    }

    public NucleicAcid getNucleidAcid() {
        return nucleidAcid;
    }

    public void setNucleidAcid(NucleicAcid nucleidAcid) {
        this.nucleidAcid = nucleidAcid;
    }

    public String getId() {
        return id;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public SampleType getSampleType() {
        return sampleType;
    }

    public void setSampleType(SampleType sampleType) {
        this.sampleType = sampleType;
    }

    @Override
    public String toString() {
        return "CorrectedCmoSampleView{" +
                "id='" + id + '\'' +
                ", sampleId='" + sampleId + '\'' +
                ", sampleType='" + sampleType + '\'' +
                ", requestId='" + requestId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", sampleClass=" + sampleClass +
                ", sampleOrigin=" + sampleOrigin +
                ", specimenType=" + specimenType +
                ", nucleidAcid=" + nucleidAcid +
                ", correctedCmoId='" + correctedCmoId + '\'' +
                '}';
    }
}
