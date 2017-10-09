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
    private static Sample notAvailableSample = new NotAvailableSample();
    private final String igoId;
    private final Predicate<Sample> validSamplePredicate;
    private Map<String, Run> runs = new LinkedHashMap<>();
    private Sample pairing;
    private String cmoSampleId = Constants.UNDEFINED;
    private int numberOfReads;
    private String alias = "";
    private Map<String, String> properties = new LinkedHashMap<>();
    private boolean pooledNormal;
    private boolean transfer;
    private boolean hasNimbleGen;
    private boolean isTumor;
    private Recipe recipe;
    private String requestId;
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

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Sample(String igoId, Predicate<Sample> validSamplePredicate) {
        this.igoId = igoId;
        this.validSamplePredicate = validSamplePredicate;
    }

    public Multimap<String, Protocol> getProtocols() {
        return protocols;
    }

    public int getNumberOfReads() {
        return numberOfReads;
    }

    public void setNumberOfReads(int numberOfReads) {
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

    public Set<String> getValidRunIds(){
        return runs.values().stream()
                .filter(Run::isPassed)
                .map(r -> r.getId())
                .collect(Collectors.toSet());
    }

    public Run putRunIfAbsent(String runID) {
        if (!runs.containsKey(runID)) {
            Run run = new Run(runID);
            runs.put(runID, run);
            Run.addRun(run);
        }
        return runs.get(runID);
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
        if(!runs.containsKey(run.getId()))
            runs.put(run.getId(), run);
        return runs.get(run.getId());
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
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

    public void setParentRequestId(String parentRequestId) {
        this.parentRequestId = parentRequestId;
    }

    public String getParentRequestId() {
        return parentRequestId;
    }

    public boolean hasParentRequest() {
        return !StringUtils.isEmpty(parentRequestId);
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    public String getSeqName() {
        return seqName;
    }

    public static Sample getNotAvailableSample() {
        return notAvailableSample;
    }

}
