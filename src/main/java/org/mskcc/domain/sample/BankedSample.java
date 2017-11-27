package org.mskcc.domain.sample;

import java.util.HashMap;
import java.util.Map;

public class BankedSample {
    public static final String DATA_TYPE_NAME = "BankedSample";
    public static final String CELL_COUNT = "CellCount";
    public static final String SAMPLE_ORIGIN = "SampleOrigin";
    public static final String SAMPLE_CLASS = "SampleClass";
    public static final String ROW_INDEX = "RowIndex";
    public static final String TRANSACTION_ID = "TransactionId";
    public static final String SPECIES = "Species";
    public static final String SAMPLE_TYPE = "SampleType";
    public static final String REQUEST_ID = "RequestId";
    public static final String INVESTIGATOR = "Investigator";
    public static final String PROMOTED = "Promoted";
    public static final String SERVICE_ID = "ServiceId";
    public static final String USER_SAMPLE_ID = "UserSampleID";
    public static final String ORGANISM = "Organism";
    public static final String TUMOR_OR_NORMAL = "TumorOrNormal";
    public static final String TUBE_BARCODE = "TubeBarcode";
    public static final String PLATE_ID = "PlateId";
    public static final String ROW_POSITION = "RowPosition";
    public static final String COL_POSITION = "ColPosition";
    public static final String RECIPE = "Recipe";
    public static final String PRESERVATION = "Preservation";
    public static final String VOLUME = "Volume";
    public static final String CONCENTRATION = "Concentration";
    public static final String CONCENTRATION_UNITS = "ConcentrationUnits";
    public static final String RUN_TYPE = "RunType";
    public static final String REQUESTED_READS = "RequestedReads";
    public static final String PATIENT_ID = "PatientId";
    public static final String BARCODE_ID = "BarcodeId";
    public static final String OTHER_SAMPLE_ID = "OtherSampleId";
    public static final String GENETIC_ALTERATIONS = "GeneticAlterations";
    public static final String GENDER = "Gender";
    public static final String ESTIMATED_PURITY = "EstimatedPurity";
    public static final String COLLECTION_YEAR = "CollectionYear";
    public static final String CLINICAL_INFO = "ClinicalInfo";
    public static final String SPECIMEN_TYPE = "SpecimenType";
    public static final String TISSUE_SITE = "TissueSite";
    public static final String TUMOR_TYPE = "TumorType";
    public static final String SPIKE_IN_GENES = "SpikeInGenes";
    public static final String PLATFORM = "Platform";
    public static final String ASSAY = "Assay";
    public static final String NATO_EXTRACT = "NAtoExtract";
    public static final String CREATED_BY = "CreatedBy";
    public static final String DATA_RECORD_NAME = "DataRecordName";
    public static final String DATE_CREATED = "DateCreated";
    public static final String RECORD_ID = "RecordId";

    private final String id;
    private Map<String, Object> fields = new HashMap<>();

    public BankedSample(String id) {
        this.id = id;
    }

    public BankedSample(String id, Map<String, Object> fields) {
        this.id = id;
        this.fields = fields;
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public String getCellCount() {
        return (String) fields.get(CELL_COUNT);
    }

    public void setCellCount(String value) {
        fields.put(CELL_COUNT, value);
    }

    public String getSampleOrigin() {
        return (String) fields.get(SAMPLE_ORIGIN);
    }

    public void setSampleOrigin(String value) {
        fields.put(SAMPLE_ORIGIN, value);
    }

    public String getSampleClass() {
        return (String) fields.get(SAMPLE_CLASS);
    }

    public void setSampleClass(String value) {
        fields.put(SAMPLE_CLASS, value);
    }

    public Integer getRowIndex() {
        return (Integer) fields.get(ROW_INDEX);
    }

    public void setRowIndex(Integer value) {
        fields.put(ROW_INDEX, value);
    }

    public Long getTransactionId() {
        return (Long) fields.get(TRANSACTION_ID);
    }

    public void setTransactionId(Long value) {
        fields.put(TRANSACTION_ID, value);
    }

    public String getSpecies() {
        return (String) fields.get(SPECIES);
    }

    public void setSpecies(String value) {
        fields.put(SPECIES, value);
    }

    public String getSampleType() {
        return (String) fields.get(SAMPLE_TYPE);
    }

    public void setSampleType(String value) {
        fields.put(SAMPLE_TYPE, value);
    }

    public String getRequestId() {
        return (String) fields.get(REQUEST_ID);
    }

    public void setRequestId(String value) {
        fields.put(REQUEST_ID, value);
    }

    public String getInvestigator() {
        return (String) fields.get(INVESTIGATOR);
    }

    public void setInvestigator(String value) {
        fields.put(INVESTIGATOR, value);
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

    public String getUserSampleID() {
        return (String) fields.get(USER_SAMPLE_ID);
    }

    public void setUserSampleID(String value) {
        fields.put(USER_SAMPLE_ID, value);
    }

    public String getOrganism() {
        return (String) fields.get(ORGANISM);
    }

    public void setOrganism(String value) {
        fields.put(ORGANISM, value);
    }

    public String getTumorOrNormal() {
        return (String) fields.get(TUMOR_OR_NORMAL);
    }

    public void setTumorOrNormal(String value) {
        fields.put(TUMOR_OR_NORMAL, value);
    }

    public String getTubeBarcode() {
        return (String) fields.get(TUBE_BARCODE);
    }

    public void setTubeBarcode(String value) {
        fields.put(TUBE_BARCODE, value);
    }

    public String getPlateId() {
        return (String) fields.get(PLATE_ID);
    }

    public void setPlateId(String value) {
        fields.put(PLATE_ID, value);
    }

    public String getRowPosition() {
        return (String) fields.get(ROW_POSITION);
    }

    public void setRowPosition(String value) {
        fields.put(ROW_POSITION, value);
    }

    public String getColPosition() {
        return (String) fields.get(COL_POSITION);
    }

    public void setColPosition(String value) {
        fields.put(COL_POSITION, value);
    }

    public String getRecipe() {
        return (String) fields.get(RECIPE);
    }

    public void setRecipe(String value) {
        fields.put(RECIPE, value);
    }

    public String getPreservation() {
        return (String) fields.get(PRESERVATION);
    }

    public void setPreservation(String value) {
        fields.put(PRESERVATION, value);
    }

    public Double getVolume() {
        return (Double) fields.get(VOLUME);
    }

    public void setVolume(Double value) {
        fields.put(VOLUME, value);
    }

    public Double getConcentration() {
        return (Double) fields.get(CONCENTRATION);
    }

    public void setConcentration(Double value) {
        fields.put(CONCENTRATION, value);
    }

    public String getConcentrationUnits() {
        return (String) fields.get(CONCENTRATION_UNITS);
    }

    public void setConcentrationUnits(String value) {
        fields.put(CONCENTRATION_UNITS, value);
    }

    public String getRunType() {
        return (String) fields.get(RUN_TYPE);
    }

    public void setRunType(String value) {
        fields.put(RUN_TYPE, value);
    }

    public String getRequestedReads() {
        return (String) fields.get(REQUESTED_READS);
    }

    public void setRequestedReads(String value) {
        fields.put(REQUESTED_READS, value);
    }

    public String getPatientId() {
        return (String) fields.get(PATIENT_ID);
    }

    public void setPatientId(String value) {
        fields.put(PATIENT_ID, value);
    }

    public String getBarcodeId() {
        return (String) fields.get(BARCODE_ID);
    }

    public void setBarcodeId(String value) {
        fields.put(BARCODE_ID, value);
    }

    public String getOtherSampleId() {
        return (String) fields.get(OTHER_SAMPLE_ID);
    }

    public void setOtherSampleId(String value) {
        fields.put(OTHER_SAMPLE_ID, value);
    }

    public String getGeneticAlterations() {
        return (String) fields.get(GENETIC_ALTERATIONS);
    }

    public void setGeneticAlterations(String value) {
        fields.put(GENETIC_ALTERATIONS, value);
    }

    public String getGender() {
        return (String) fields.get(GENDER);
    }

    public void setGender(String value) {
        fields.put(GENDER, value);
    }

    public Double getEstimatedPurity() {
        return (Double) fields.get(ESTIMATED_PURITY);
    }

    public void setEstimatedPurity(Double value) {
        fields.put(ESTIMATED_PURITY, value);
    }

    public String getCollectionYear() {
        return (String) fields.get(COLLECTION_YEAR);
    }

    public void setCollectionYear(String value) {
        fields.put(COLLECTION_YEAR, value);
    }

    public String getClinicalInfo() {
        return (String) fields.get(CLINICAL_INFO);
    }

    public void setClinicalInfo(String value) {
        fields.put(CLINICAL_INFO, value);
    }

    public String getSpecimenType() {
        return (String) fields.get(SPECIMEN_TYPE);
    }

    public void setSpecimenType(String value) {
        fields.put(SPECIMEN_TYPE, value);
    }

    public String getTissueSite() {
        return (String) fields.get(TISSUE_SITE);
    }

    public void setTissueSite(String value) {
        fields.put(TISSUE_SITE, value);
    }

    public String getTumorType() {
        return (String) fields.get(TUMOR_TYPE);
    }

    public void setTumorType(String value) {
        fields.put(TUMOR_TYPE, value);
    }

    public String getSpikeInGenes() {
        return (String) fields.get(SPIKE_IN_GENES);
    }

    public void setSpikeInGenes(String value) {
        fields.put(SPIKE_IN_GENES, value);
    }

    public String getPlatform() {
        return (String) fields.get(PLATFORM);
    }

    public void setPlatform(String value) {
        fields.put(PLATFORM, value);
    }

    public String getAssay() {
        return (String) fields.get(ASSAY);
    }

    public void setAssay(String value) {
        fields.put(ASSAY, value);
    }

    public String getNAtoExtract() {
        return (String) fields.get(NATO_EXTRACT);
    }

    public void setNAtoExtract(String value) {
        fields.put(NATO_EXTRACT, value);
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

    public String getId() {
        return id;
    }
}
