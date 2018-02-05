package org.mskcc.domain.sample;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import org.apache.commons.lang3.StringUtils;
import org.mskcc.domain.*;
import org.mskcc.util.CommonUtils;
import org.mskcc.util.Constants;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Sample {
    public static final String DATA_TYPE_NAME = "Sample";
    public static final String ACTIVE_WORKFLOW_ID = "ActiveWorkflowId";
    public static final String ALT_ID = "AltId";
    public static final String ASSAY = "Assay";
    public static final String CELL_COUNT = "CellCount";
    public static final String CLINICAL_INFO = "ClinicalInfo";
    public static final String CMO_PATIENT_ID = "CmoPatientId";
    public static final String CMOSAMPLE_CLASS = "CMOSampleClass";
    public static final String COL_POSITION = "ColPosition";
    public static final String COLLECTION_YEAR = "CollectionYear";
    public static final String COMMENTS = "Comments";
    public static final String CONCENTRATION = "Concentration";
    public static final String CONCENTRATION_UNITS = "ConcentrationUnits";
    public static final String CONTAINER_TYPE = "ContainerType";
    public static final String CONTROL_LOT_NUMBER = "ControlLotNumber";
    public static final String CONTROL_VOLUME_USED = "ControlVolumeUsed";
    public static final String CREATED_BY = "CreatedBy";
    public static final String CUSTOM_CAPTURE_PANEL = "CustomCapturePanel";
    public static final String DATA_RECORD_NAME = "DataRecordName";
    public static final String DATE_CREATED = "DateCreated";
    public static final String DATE_MODIFIED = "DateModified";
    public static final String ENTERED_WORKFLOW_TIME = "EnteredWorkflowTime";
    public static final String ESIMATED_PURITY = "EsimatedPurity";
    public static final String ESTIMATED_PURITY = "EstimatedPurity";
    public static final String EXEMPLAR_SAMPLE_STATUS = "ExemplarSampleStatus";
    public static final String EXEMPLAR_SAMPLE_TYPE = "ExemplarSampleType";
    public static final String GENDER = "Gender";
    public static final String GENETIC_ALTERATIONS = "GeneticAlterations";
    public static final String IS_CONTROL = "IsControl";
    public static final String IS_POOLED = "IsPooled";
    public static final String MICRONIC_TUBE_BARCODE = "MicronicTubeBarcode";
    public static final String NATO_EXTRACT = "NAtoExtract";
    public static final String ORGANISM = "Organism";
    public static final String OTHER_SAMPLE_ID = "OtherSampleId";
    public static final String PATIENT_ID = "PatientId";
    public static final String PLATFORM = "Platform";
    public static final String PRESERVATION = "Preservation";
    public static final String RECEIVED_QUANTITY = "ReceivedQuantity";
    public static final String RECIPE = "Recipe";
    public static final String RECORD_ID = "RecordId";
    public static final String REQUEST_ID = "RequestId";
    public static final String REQUEST_RECORD_ID_LIST = "RequestRecordIdList";
    public static final String ROW_POSITION = "RowPosition";
    public static final String SAMPLE_ID = "SampleId";
    public static final String SAMPLE_ORIGIN = "SampleOrigin";
    public static final String SAMPLE_RECORD_ID = "SampleRecordId";
    public static final String SAMPLE_REPLACED = "SampleReplaced";
    public static final String SORT_FIELD = "SortField";
    public static final String SORTING_FIELD = "SortingField";
    public static final String SOURCE_LIMS_ID = "SourceLimsId";
    public static final String SPECIES = "Species";
    public static final String SPECIMEN_TYPE = "SpecimenType";
    public static final String SPIKE_IN_GENES = "SpikeInGenes";
    public static final String STORAGE_LOCATION_BARCODE = "StorageLocationBarcode";
    public static final String STORAGE_UNIT_PATH = "StorageUnitPath";
    public static final String TISSUE_LOCATION = "TissueLocation";
    public static final String TISSUE_SOURCE = "TissueSource";
    public static final String TOTAL_MASS = "TotalMass";
    public static final String TUBE_BARCODE = "TubeBarcode";
    public static final String TUMOR_OR_NORMAL = "TumorOrNormal";
    public static final String TUMOR_SUBTYPE = "TumorSubtype";
    public static final String TUMOR_TYPE = "TumorType";
    public static final String USER_SAMPLE_ID = "UserSampleID";
    public static final String VOLUME = "Volume";

    private static Sample notAvailableSample = new NotAvailableSample();
    private final String igoId;
    private final Predicate<Sample> validSamplePredicate;

    protected Map<String, Object> fields = new HashMap<>();

    private Map<String, Run> runs = new LinkedHashMap<>();
    private Sample pairing;
    private String cmoSampleId = Constants.UNDEFINED;
    private long numberOfReads;
    private String alias = "";
    private Map<String, String> properties = new LinkedHashMap<>();
    private boolean pooledNormal;
    private boolean transfer;
    private boolean hasNimbleGen;
    private boolean isTumor;
    private CmoSampleInfo cmoSampleInfo = new CmoSampleInfo();
    private String sampleClass;
    private TumorNormalType tumorNormalType;
    private Set<Strand> strands = new HashSet<>();
    private Set<ProtocolType> protocolTypes = new HashSet<>();
    private List<KapaAgilentCaptureProtocol> kapaAgilentCaptureProtocols1 = new ArrayList<>();
    private List<KapaAgilentCaptureProtocol> kapaAgilentCaptureProtocols2 = new ArrayList<>();
    private List<NimbleGenHybProtocol> nimbleGenHybProtocols = new ArrayList<>();
    private Multimap<String, Protocol> protocols = LinkedListMultimap.create();
    private Request request;
    private String parentRequestId;
    private String seqName;
    public Sample(String igoId) {
        this(igoId, new ValidSamplePredicate());
    }

    public Sample(String igoId, Predicate<Sample> validSamplePredicate) {
        this.igoId = igoId;
        this.validSamplePredicate = validSamplePredicate;
    }

    public static Sample getNotAvailableSample() {
        return notAvailableSample;
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public void setFields(Map<String, Object> fields) {
        this.fields = fields;
    }

    public String getSampleId() {
        return (String) fields.get(SAMPLE_ID);
    }

    public void setSampleId(String value) {
        fields.put(SAMPLE_ID, value);
    }

    public String getOtherSampleId() {
        return (String) fields.get(OTHER_SAMPLE_ID);
    }

    public void setOtherSampleId(String value) {
        fields.put(OTHER_SAMPLE_ID, value);
    }

    public String getUserSampleID() {
        return (String) fields.get(USER_SAMPLE_ID);
    }

    public void setUserSampleID(String value) {
        fields.put(USER_SAMPLE_ID, value);
    }

    public String getExemplarSampleStatus() {
        return (String) fields.get(EXEMPLAR_SAMPLE_STATUS);
    }

    public void setExemplarSampleStatus(String value) {
        fields.put(EXEMPLAR_SAMPLE_STATUS, value);
    }

    public String getExemplarSampleType() {
        return (String) fields.get(EXEMPLAR_SAMPLE_TYPE);
    }

    public void setExemplarSampleType(String value) {
        fields.put(EXEMPLAR_SAMPLE_TYPE, value);
    }

    public String getRequestId() {
        return (String) fields.get(REQUEST_ID);
    }

    public void setRequestId(String value) {
        fields.put(REQUEST_ID, value);
    }

    public String getContainerType() {
        return (String) fields.get(CONTAINER_TYPE);
    }

    public void setContainerType(String value) {
        fields.put(CONTAINER_TYPE, value);
    }

    public String getTubeBarcode() {
        return (String) fields.get(TUBE_BARCODE);
    }

    public void setTubeBarcode(String value) {
        fields.put(TUBE_BARCODE, value);
    }

    public String getSourceLimsId() {
        return (String) fields.get(SOURCE_LIMS_ID);
    }

    public void setSourceLimsId(String value) {
        fields.put(SOURCE_LIMS_ID, value);
    }

    public String getMicronicTubeBarcode() {
        return (String) fields.get(MICRONIC_TUBE_BARCODE);
    }

    public void setMicronicTubeBarcode(String value) {
        fields.put(MICRONIC_TUBE_BARCODE, value);
    }

    public String getCellCount() {
        return (String) fields.get(CELL_COUNT);
    }

    public void setCellCount(String value) {
        fields.put(CELL_COUNT, value);
    }

    public Double getReceivedQuantity() {
        return (Double) fields.get(RECEIVED_QUANTITY);
    }

    public void setReceivedQuantity(Double value) {
        fields.put(RECEIVED_QUANTITY, value);
    }

    public String getNAtoExtract() {
        return (String) fields.get(NATO_EXTRACT);
    }

    public void setNAtoExtract(String value) {
        fields.put(NATO_EXTRACT, value);
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

    public Double getTotalMass() {
        return (Double) fields.get(TOTAL_MASS);
    }

    public void setTotalMass(Double value) {
        fields.put(TOTAL_MASS, value);
    }

    public Double getEsimatedPurity() {
        return (Double) fields.get(ESIMATED_PURITY);
    }

    public void setEsimatedPurity(Double value) {
        fields.put(ESIMATED_PURITY, value);
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

    public String getStorageLocationBarcode() {
        return (String) fields.get(STORAGE_LOCATION_BARCODE);
    }

    public void setStorageLocationBarcode(String value) {
        fields.put(STORAGE_LOCATION_BARCODE, value);
    }

    public String getStorageUnitPath() {
        return (String) fields.get(STORAGE_UNIT_PATH);
    }

    public void setStorageUnitPath(String value) {
        fields.put(STORAGE_UNIT_PATH, value);
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

    public String getPlatform() {
        return (String) fields.get(PLATFORM);
    }

    public void setPlatform(String value) {
        fields.put(PLATFORM, value);
    }

    public Recipe getRecipe() {
        return Recipe.getRecipeByValue((String) fields.get(RECIPE));
    }

    public void setRecipe(String value) {
        fields.put(RECIPE, value);
    }

    public Boolean getIsControl() {
        return (Boolean) fields.get(IS_CONTROL);
    }

    public void setIsControl(Boolean value) {
        fields.put(IS_CONTROL, value);
    }

    public Long getSortField() {
        return (Long) fields.get(SORT_FIELD);
    }

    public void setSortField(Long value) {
        fields.put(SORT_FIELD, value);
    }

    public String getAltId() {
        return (String) fields.get(ALT_ID);
    }

    public void setAltId(String value) {
        fields.put(ALT_ID, value);
    }

    public String getOrganism() {
        return (String) fields.get(ORGANISM);
    }

    public void setOrganism(String value) {
        fields.put(ORGANISM, value);
    }

    public String getRequestRecordIdList() {
        return (String) fields.get(REQUEST_RECORD_ID_LIST);
    }

    public void setRequestRecordIdList(String value) {
        fields.put(REQUEST_RECORD_ID_LIST, value);
    }

    public Long getSortingField() {
        return (Long) fields.get(SORTING_FIELD);
    }

    public void setSortingField(Long value) {
        fields.put(SORTING_FIELD, value);
    }

    public Long getSampleRecordId() {
        return (Long) fields.get(SAMPLE_RECORD_ID);
    }

    public void setSampleRecordId(Long value) {
        fields.put(SAMPLE_RECORD_ID, value);
    }

    public String getCustomCapturePanel() {
        return (String) fields.get(CUSTOM_CAPTURE_PANEL);
    }

    public void setCustomCapturePanel(String value) {
        fields.put(CUSTOM_CAPTURE_PANEL, value);
    }

    public String getSpikeInGenes() {
        return (String) fields.get(SPIKE_IN_GENES);
    }

    public void setSpikeInGenes(String value) {
        fields.put(SPIKE_IN_GENES, value);
    }

    public String getAssay() {
        return (String) fields.get(ASSAY);
    }

    public void setAssay(String value) {
        fields.put(ASSAY, value);
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

    public String getCmoPatientId() {
        return (String) fields.get(CMO_PATIENT_ID);
    }

    public void setCmoPatientId(String value) {
        fields.put(CMO_PATIENT_ID, value);
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

    public Boolean getSampleReplaced() {
        return (Boolean) fields.get(SAMPLE_REPLACED);
    }

    public void setSampleReplaced(Boolean value) {
        fields.put(SAMPLE_REPLACED, value);
    }

    public Double getControlVolumeUsed() {
        return (Double) fields.get(CONTROL_VOLUME_USED);
    }

    public void setControlVolumeUsed(Double value) {
        fields.put(CONTROL_VOLUME_USED, value);
    }

    public String getControlLotNumber() {
        return (String) fields.get(CONTROL_LOT_NUMBER);
    }

    public void setControlLotNumber(String value) {
        fields.put(CONTROL_LOT_NUMBER, value);
    }

    public String getComments() {
        return (String) fields.get(COMMENTS);
    }

    public void setComments(String value) {
        fields.put(COMMENTS, value);
    }

    public String getCreatedBy() {
        return (String) fields.get(CREATED_BY);
    }

    public Long getDateCreated() {
        return (Long) fields.get(DATE_CREATED);
    }

    public Long getDateModified() {
        return (Long) fields.get(DATE_MODIFIED);
    }

    public void setDateModified(Long value) {
        fields.put(DATE_MODIFIED, value);
    }

    public String getDataRecordName() {
        return (String) fields.get(DATA_RECORD_NAME);
    }

    public Boolean getIsPooled() {
        return (Boolean) fields.get(IS_POOLED);
    }

    public void setIsPooled(Boolean value) {
        fields.put(IS_POOLED, value);
    }

    public Long getActiveWorkflowId() {
        return (Long) fields.get(ACTIVE_WORKFLOW_ID);
    }

    public void setActiveWorkflowId(Long value) {
        fields.put(ACTIVE_WORKFLOW_ID, value);
    }

    public String getEnteredWorkflowTime() {
        return (String) fields.get(ENTERED_WORKFLOW_TIME);
    }

    public void setEnteredWorkflowTime(String value) {
        fields.put(ENTERED_WORKFLOW_TIME, value);
    }

    public long getRecordId() {
        return (long) fields.get(RECORD_ID);
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Multimap<String, Protocol> getProtocols() {
        return protocols;
    }

    public long getNumberOfReads() {
        return numberOfReads;
    }

    public void setNumberOfReads(long numberOfReads) {
        this.numberOfReads = numberOfReads;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public Set<ProtocolType> getProtocolTypes() {
        return protocolTypes;
    }

    public String get(String key) {
        return properties.getOrDefault(key, "");
    }

    public void put(String key, String value) {
        properties.put(key, value);
    }

    public Object getField(String value) {
        return fields.get(value);
    }

    public boolean isPooledNormal() {
        return pooledNormal;
    }

    public void setPooledNormal(boolean pooledNormal) {
        this.pooledNormal = pooledNormal;
    }

    public boolean isTransfer() {
        return transfer;
    }

    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }

    @Override
    public String toString() {
        return cmoSampleId;
    }

    public boolean isValid() {
        return validSamplePredicate.test(this);
    }

    public boolean hasAlias() {
        return alias != null && !Objects.equals(alias, "");
    }

    public String getIgoId() {
        return igoId;
    }

    public void addRun(Run run) {
        runs.put(run.getId(), run);
    }

    public Map<String, Run> getRuns() {
        return runs;
    }

    public Map<String, Run> getRuns(Predicate<Run> runPredicate) {
        return runs.entrySet().stream().filter(e -> runPredicate.test(e.getValue())).collect(CommonUtils.getLinkedHashMapCollector());
    }

    public boolean containsRun(String id) {
        return runs.containsKey(id);
    }

    public void addRuns(Collection<Run> runs) {
        this.runs.putAll(runs.stream()
                .map(r -> new AbstractMap.SimpleEntry<>(r.getId(), r))
                .collect(Collectors.toMap(r -> r.getKey(), r -> r.getValue())));
    }

    public Set<Run> getValidRuns() {
        return runs.values().stream()
                .filter(Run::isPassed)
                .collect(Collectors.toSet());
    }

    public Set<String> getValidRunIds() {
        return runs.values().stream()
                .filter(Run::isPassed)
                .map(r -> r.getId())
                .collect(Collectors.toSet());
    }

    public Run putRunIfAbsent(String runID) {
        return putRunIfAbsent(new Run(runID));
    }

    public Set<Run> getBadRuns() {
        return runs.values()
                .stream()
                .filter(r -> r.isBadRun())
                .collect(Collectors.toSet());
    }

    public String getCmoSampleId() {
        return cmoSampleId;
    }

    public void setCmoSampleId(String cmoSampleId) {
        this.cmoSampleId = cmoSampleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sample sample = (Sample) o;
        return igoId != null ? igoId.equals(sample.igoId) : sample.igoId == null;
    }

    @Override
    public int hashCode() {
        return igoId != null ? igoId.hashCode() : 0;
    }

    public Sample getPairing() {
        return pairing;
    }

    public void setPairing(Sample pairing) {
        this.pairing = pairing;
    }

    public boolean isHasNimbleGen() {
        return hasNimbleGen;
    }

    public void setHasNimbleGen(boolean hasNimbleGen) {
        this.hasNimbleGen = hasNimbleGen;
    }

    public void setIsTumor(boolean isTumor) {
        this.isTumor = isTumor;
    }

    public boolean isTumor() {
        return isTumor;
    }

    public Run putRunIfAbsent(Run run) {
        if (!runs.containsKey(run.getId())) {
            runs.put(run.getId(), run);
            Run.addRun(run);
        }
        return runs.get(run.getId());
    }

    public CmoSampleInfo getCmoSampleInfo() {
        return cmoSampleInfo;
    }

    public void setCmoSampleInfo(CmoSampleInfo cmoSampleInfo) {
        this.cmoSampleInfo = cmoSampleInfo;
    }

    public String getSampleClass() {
        return sampleClass;
    }

    public void setSampleClass(String sampleClass) {
        this.sampleClass = sampleClass;
    }

    public TumorNormalType getTumorNormalType() {
        return tumorNormalType;
    }

    public void setTumorNormalType(TumorNormalType tumorNormalType) {
        this.tumorNormalType = tumorNormalType;
    }

    public Set<Strand> getStrands() {
        return strands;
    }

    public void addProtocol(ProtocolType protocolType) {
        protocolTypes.add(protocolType);
    }

    public void addProtocol(String name, Protocol protocol) {
        protocols.put(name, protocol);
    }

    public void addStrand(Strand strand) {
        strands.add(strand);
    }

    public List<KapaAgilentCaptureProtocol> getKapaAgilentCaptureProtocols1() {
        return kapaAgilentCaptureProtocols1;
    }

    public void setKapaAgilentCaptureProtocols1(List<KapaAgilentCaptureProtocol> kapaAgilentCaptureProtocols1) {
        this.kapaAgilentCaptureProtocols1 = kapaAgilentCaptureProtocols1;
    }

    public List<KapaAgilentCaptureProtocol> getKapaAgilentCaptureProtocols2() {
        return kapaAgilentCaptureProtocols2;
    }

    public void setKapaAgilentCaptureProtocols2(List<KapaAgilentCaptureProtocol> kapaAgilentCaptureProtocols2) {
        this.kapaAgilentCaptureProtocols2 = kapaAgilentCaptureProtocols2;
    }

    public List<NimbleGenHybProtocol> getNimbleGenHybProtocols() {
        return nimbleGenHybProtocols;
    }

    public void setNimbleGenHybProtocols(List<org.mskcc.domain.NimbleGenHybProtocol> nimbleGenHybProtocols) {
        this.nimbleGenHybProtocols = nimbleGenHybProtocols;
    }

    public void addNimbleGenHybProtocol(NimbleGenHybProtocol nimbleGenHybProtocol) {
        nimbleGenHybProtocols.add(nimbleGenHybProtocol);
    }

    public String getParentRequestId() {
        return parentRequestId;
    }

    public void setParentRequestId(String parentRequestId) {
        this.parentRequestId = parentRequestId;
    }

    public boolean hasParentRequest() {
        return !StringUtils.isEmpty(parentRequestId);
    }

    public String getSeqName() {
        return seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    public String getCorrectedCmoSampleId() {
        return cmoSampleInfo.getCorrectedCMOID();
    }

    public String getCorrectedCmoSampleOrigin() {
        return cmoSampleInfo.getSampleOrigin();
    }

    public String getCorrectedSpecimenType() {
        return cmoSampleInfo.getSpecimenType();
    }

    public void setCorrectedCmoId(String value) {
        cmoSampleInfo.setCorrectedCMOID(value);
    }

    public String getCorrectedSampleClass() {
        return cmoSampleInfo.getCMOSampleClass();
    }
}
