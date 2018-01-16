package org.mskcc.domain.sample;

import javax.persistence.*;

@Entity
@Table(name = "external_sample")
public class ExternalSample {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, name = "run_id")
    private String runID;

    @Column(nullable = false, name = "bam_path")
    private String bamPath;

    @Column
    private String origin;

    @Column(name = "specimen_type")
    private String specimenType;

    @Column(name = "nucleid_acid")
    private String nucleidAcid;

    @Column(name = "cmo_id")
    private String cmoId;

    @Column(nullable = false, name = "external_id")
    private String externalId;

    @Column(name = "patient_cmo_id")
    private String patientCmoId;

    @Column(nullable = false, name = "patient_external_id")
    private String patientDmpId;

    public ExternalSample(String runID, String bamPath, String externalId, String patientDmpId) {
        this.runID = runID;
        this.bamPath = bamPath;
        this.externalId = externalId;
        this.patientDmpId = patientDmpId;
    }

    ExternalSample() {
    }

    public String getRunID() {
        return this.runID;
    }

    public void setRunID(String runID) {
        this.runID = runID;
    }

    public String getBamPath() {
        return this.bamPath;
    }

    public void setBamPath(String bamPath) {
        this.bamPath = bamPath;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setSpecimenType(String specimenType) {
        this.specimenType = specimenType;
    }

    public void setNucleidAcid(String nucleidAcid) {
        this.nucleidAcid = nucleidAcid;
    }

    public void setCmoId(String cmoId) {
        this.cmoId = cmoId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public void setPatientCmoId(String patientCmoId) {
        this.patientCmoId = patientCmoId;
    }

    public void setPatientDmpId(String patientDmpId) {
        this.patientDmpId = patientDmpId;
    }

    public String getOrigin() {
        return this.origin;
    }

    public String getSpecimenType() {
        return this.specimenType;
    }

    public String getNucleidAcid() {
        return this.nucleidAcid;
    }

    public String getCmoId() {
        return this.cmoId;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public String getPatientCmoId() {
        return this.patientCmoId;
    }

    public String getPatientDmpId() {
        return this.patientDmpId;
    }

    public Long getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "ZSample{" +
                "id=" + id +
                ", runID='" + runID + '\'' +
                ", origin='" + origin + '\'' +
                ", specimenType='" + specimenType + '\'' +
                ", nucleidAcid='" + nucleidAcid + '\'' +
                ", cmoId='" + cmoId + '\'' +
                ", externalId='" + externalId + '\'' +
                ", patientCmoId='" + patientCmoId + '\'' +
                ", patientDmpId='" + patientDmpId + '\'' +
                '}';
    }
}
