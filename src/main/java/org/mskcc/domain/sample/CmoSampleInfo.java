package org.mskcc.domain.sample;

import java.util.HashMap;
import java.util.Map;

public class CmoSampleInfo {
    public static final String DATA_TYPE_NAME = "SampleCMOInfoRecords";

    public static final String ALT_ID = "AltId";
    public static final String CLINICAL_INFO = "ClinicalInfo";
    public static final String CMO_PATIENT_ID = "CmoPatientId";
    public static final String CMOSAMPLE_CLASS = "CMOSampleClass";
    public static final String COLLECTION_YEAR = "CollectionYear";
    public static final String CORRECTED_CMOID = "CorrectedCMOID";
    public static final String CORRECTED_INVEST_PATIENT_ID = "CorrectedInvestPatientId";
    public static final String CREATED_BY = "CreatedBy";
    public static final String DATA_RECORD_NAME = "DataRecordName";
    public static final String DATE_CREATED = "DateCreated";
    public static final String DATE_REQUESTED = "DateRequested";
    public static final String DMPLIBRARY_INPUT = "DMPLibraryInput";
    public static final String DMPLIBRARY_OUTPUT = "DMPLibraryOutput";
    public static final String DMPSAMPLE_ID = "DMPSampleId";
    public static final String ESTIMATED_PURITY = "EstimatedPurity";
    public static final String GENDER = "Gender";
    public static final String GENETIC_ALTERATIONS = "GeneticAlterations";
    public static final String MULTI_PARENT_LINK_107 = "MultiParentLink107";
    public static final String OTHER_SAMPLE_ID = "OtherSampleId";
    public static final String PATIENT_ID = "PatientId";
    public static final String PRESERVATION = "Preservation";
    public static final String RECORD_ID = "RecordId";
    public static final String REQUEST_ID = "RequestId";
    public static final String SAMPLE_ID = "SampleId";
    public static final String SAMPLE_ORIGIN = "SampleOrigin";
    public static final String SAMPLE_PAIR = "SamplePair";
    public static final String SPECIES = "Species";
    public static final String SPECIMEN_TYPE = "SpecimenType";
    public static final String TISSUE_LOCATION = "TissueLocation";
    public static final String TISSUE_SOURCE = "TissueSource";
    public static final String TUMOR_OR_NORMAL = "TumorOrNormal";
    public static final String TUMOR_SUBTYPE = "TumorSubtype";
    public static final String TUMOR_TYPE = "TumorType";
    public static final String USER_SAMPLE_ID = "UserSampleID";

    private Map<String, Object> fields = new HashMap<>();

    public CmoSampleInfo() {
    }

    public CmoSampleInfo(Map<String, Object> fields) {
        this.fields = fields;
    }

    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }

    public String getCorrectedCMOID() {
        return (String) fields.get(CORRECTED_CMOID);
    }

    public void setCorrectedCMOID(String value) {
        fields.put(CORRECTED_CMOID, value);
    }

    public String getCorrectedInvestPatientId() {
        return (String) fields.get(CORRECTED_INVEST_PATIENT_ID);
    }

    public void setCorrectedInvestPatientId(String value) {
        fields.put(CORRECTED_INVEST_PATIENT_ID, value);
    }

    public String getSamplePair() {
        return (String) fields.get(SAMPLE_PAIR);
    }

    public void setSamplePair(String value) {
        fields.put(SAMPLE_PAIR, value);
    }

    public String getSampleId() {
        return (String) fields.get(SAMPLE_ID);
    }

    public void setSampleId(String value) {
        fields.put(SAMPLE_ID, value);
    }

    public String getRequestId() {
        return (String) fields.get(REQUEST_ID);
    }

    public void setRequestId(String value) {
        fields.put(REQUEST_ID, value);
    }

    public String getUserSampleID() {
        return (String) fields.get(USER_SAMPLE_ID);
    }

    public void setUserSampleID(String value) {
        fields.put(USER_SAMPLE_ID, value);
    }

    public String getOtherSampleId() {
        return (String) fields.get(OTHER_SAMPLE_ID);
    }

    public void setOtherSampleId(String value) {
        fields.put(OTHER_SAMPLE_ID, value);
    }

    public String getCmoPatientId() {
        return (String) fields.get(CMO_PATIENT_ID);
    }

    public void setCmoPatientId(String value) {
        fields.put(CMO_PATIENT_ID, value);
    }

    public Double getDMPLibraryInput() {
        return (Double) fields.get(DMPLIBRARY_INPUT);
    }

    public void setDMPLibraryInput(Double value) {
        fields.put(DMPLIBRARY_INPUT, value);
    }

    public Double getDMPLibraryOutput() {
        return (Double) fields.get(DMPLIBRARY_OUTPUT);
    }

    public void setDMPLibraryOutput(Double value) {
        fields.put(DMPLIBRARY_OUTPUT, value);
    }

    public String getDMPSampleId() {
        return (String) fields.get(DMPSAMPLE_ID);
    }

    public void setDMPSampleId(String value) {
        fields.put(DMPSAMPLE_ID, value);
    }

    public Long getDateRequested() {
        return (Long) fields.get(DATE_REQUESTED);
    }

    public void setDateRequested(Long value) {
        fields.put(DATE_REQUESTED, value);
    }

    public String getPreservation() {
        return (String) fields.get(PRESERVATION);
    }

    public void setPreservation(String value) {
        fields.put(PRESERVATION, value);
    }

    public String getSpecies() {
        return (String) fields.get(SPECIES);
    }

    public void setSpecies(String value) {
        fields.put(SPECIES, value);
    }

    public String getCreatedBy() {
        return (String) fields.get(CREATED_BY);
    }

    public String getDataRecordName() {
        return (String) fields.get(DATA_RECORD_NAME);
    }

    public Long getDateCreated() {
        return (Long) fields.get(DATE_CREATED);
    }

    public String getTumorOrNormal() {
        return (String) fields.get(TUMOR_OR_NORMAL);
    }

    public void setTumorOrNormal(String value) {
        fields.put(TUMOR_OR_NORMAL, value);
    }

    public String getTumorType() {
        return (String) fields.get(TUMOR_TYPE);
    }

    public void setTumorType(String value) {
        fields.put(TUMOR_TYPE, value);
    }

    public String getTumorSubtype() {
        return (String) fields.get(TUMOR_SUBTYPE);
    }

    public void setTumorSubtype(String value) {
        fields.put(TUMOR_SUBTYPE, value);
    }

    public String getCollectionYear() {
        return (String) fields.get(COLLECTION_YEAR);
    }

    public void setCollectionYear(String value) {
        fields.put(COLLECTION_YEAR, value);
    }

    public String getSampleOrigin() {
        return (String) fields.get(SAMPLE_ORIGIN);
    }

    public void setSampleOrigin(String value) {
        fields.put(SAMPLE_ORIGIN, value);
    }

    public String getTissueLocation() {
        return (String) fields.get(TISSUE_LOCATION);
    }

    public void setTissueLocation(String value) {
        fields.put(TISSUE_LOCATION, value);
    }

    public String getClinicalInfo() {
        return (String) fields.get(CLINICAL_INFO);
    }

    public void setClinicalInfo(String value) {
        fields.put(CLINICAL_INFO, value);
    }

    public String getGeneticAlterations() {
        return (String) fields.get(GENETIC_ALTERATIONS);
    }

    public void setGeneticAlterations(String value) {
        fields.put(GENETIC_ALTERATIONS, value);
    }

    public Double getEstimatedPurity() {
        return (Double) fields.get(ESTIMATED_PURITY);
    }

    public void setEstimatedPurity(Double value) {
        fields.put(ESTIMATED_PURITY, value);
    }

    public String getTissueSource() {
        return (String) fields.get(TISSUE_SOURCE);
    }

    public void setTissueSource(String value) {
        fields.put(TISSUE_SOURCE, value);
    }

    public String getPatientId() {
        return (String) fields.get(PATIENT_ID);
    }

    public void setPatientId(String value) {
        fields.put(PATIENT_ID, value);
    }

    public String getGender() {
        return (String) fields.get(GENDER);
    }

    public void setGender(String value) {
        fields.put(GENDER, value);
    }

    public String getSpecimenType() {
        return (String) fields.get(SPECIMEN_TYPE);
    }

    public void setSpecimenType(String value) {
        fields.put(SPECIMEN_TYPE, value);
    }

    public String getCMOSampleClass() {
        return (String) fields.get(CMOSAMPLE_CLASS);
    }

    public void setCMOSampleClass(String value) {
        fields.put(CMOSAMPLE_CLASS, value);
    }

    public String getAltId() {
        return (String) fields.get(ALT_ID);
    }

    public void setAltId(String value) {
        fields.put(ALT_ID, value);
    }

    public String getMultiParentLink107() {
        return (String) fields.get(MULTI_PARENT_LINK_107);
    }
}
