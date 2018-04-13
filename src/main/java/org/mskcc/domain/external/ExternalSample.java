package org.mskcc.domain.external;

public class ExternalSample {
    private String externalId;
    private String filePath;
    private String externalPatientId;
    private String tumorNormal;
    private int counter;
    private String runId;
    private String sampleOrigin;
    private String sampleClass;
    private String cmoId;
    private String nucleidAcid;
    private String patientCmoId;
    private String specimenType;
    private String sex;
    private String oncotreeCode;
    private String baitVersion;
    private String tissueSite;
    private String preservationType;

    public ExternalSample(int counter,
                          String externalId,
                          String externalPatientId,
                          String filePath,
                          String runId,
                          String sampleClass,
                          String sampleOrigin,
                          String tumorNormal) {
        this.counter = counter;
        this.externalId = externalId;
        this.externalPatientId = externalPatientId;
        this.filePath = filePath;
        this.sampleOrigin = sampleOrigin;
        this.runId = runId;
        this.sampleClass = sampleClass;
        this.tumorNormal = tumorNormal;
    }

    // empty constructor for json
    public ExternalSample() {
    }

    public String getExternalRunId() {
        return this.runId;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getSampleOrigin() {
        return this.sampleOrigin;
    }

    public void setSampleOrigin(String sampleOrigin) {
        this.sampleOrigin = sampleOrigin;
    }

    public String getSpecimenType() {
        return this.specimenType;
    }

    public void setSpecimenType(String specimenType) {
        this.specimenType = specimenType;
    }

    public String getNucleidAcid() {
        return this.nucleidAcid;
    }

    public void setNucleidAcid(String nucleidAcid) {
        this.nucleidAcid = nucleidAcid;
    }

    public String getCmoId() {
        return this.cmoId;
    }

    public void setCmoId(String cmoId) {
        this.cmoId = cmoId;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getPatientCmoId() {
        return this.patientCmoId;
    }

    public void setPatientCmoId(String patientCmoId) {
        this.patientCmoId = patientCmoId;
    }

    public String getExternalPatientId() {
        return this.externalPatientId;
    }

    public void setExternalPatientId(String externalPatientId) {
        this.externalPatientId = externalPatientId;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getSampleClass() {
        return sampleClass;
    }

    public void setSampleClass(String sampleClass) {
        this.sampleClass = sampleClass;
    }

    public String getTumorNormal() {
        return tumorNormal;
    }

    public void setTumorNormal(String tumorNormal) {
        this.tumorNormal = tumorNormal;
    }

    public String getRunId() {
        return runId;
    }

    public void setRunId(String runId) {
        this.runId = runId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOncotreeCode() {
        return oncotreeCode;
    }

    public void setOncotreeCode(String oncotreeCode) {
        this.oncotreeCode = oncotreeCode;
    }

    public String getBaitVersion() {
        return baitVersion;
    }

    public void setBaitVersion(String baitVersion) {
        this.baitVersion = baitVersion;
    }

    public String getTissueSite() {
        return tissueSite;
    }

    public void setTissueSite(String tissueSite) {
        this.tissueSite = tissueSite;
    }

    public String getPreservationType() {
        return preservationType;
    }

    public void setPreservationType(String preservationType) {
        this.preservationType = preservationType;
    }

    @Override
    public String toString() {
        return "ExternalSample{" +
                "externalId='" + externalId + '\'' +
                ", externalPatientId='" + externalPatientId + '\'' +
                ", tumorNormal='" + tumorNormal + '\'' +
                ", counter=" + counter +
                ", runId='" + runId + '\'' +
                ", sampleOrigin='" + sampleOrigin + '\'' +
                ", sampleClass='" + sampleClass + '\'' +
                ", cmoId='" + cmoId + '\'' +
                ", nucleidAcid='" + nucleidAcid + '\'' +
                ", patientCmoId='" + patientCmoId + '\'' +
                ", specimenType='" + specimenType + '\'' +
                ", sex='" + sex + '\'' +
                ", oncotreeCode='" + oncotreeCode + '\'' +
                ", baitVersion='" + baitVersion + '\'' +
                ", tissueSite='" + tissueSite + '\'' +
                ", preservationType='" + preservationType + '\'' +
                '}';
    }
}
