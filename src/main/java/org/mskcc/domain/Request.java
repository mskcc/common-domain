package org.mskcc.domain;


import org.mskcc.domain.sample.PooledNormalSample;
import org.mskcc.domain.sample.Sample;
import org.mskcc.util.CommonUtils;
import org.mskcc.util.Constants;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Request {
    public static final String REQUEST_ID = "RequestId";
    public static final String PI_EMAIL = "PIemail";
    public static final String INVESTIGATOR_EMAIL = "Investigatoremail";

    private final String id;
    private Map<String, Sample> samples = new LinkedHashMap<>();
    private Map<String, Pool> pools = new LinkedHashMap<>();
    private Set<LibType> libTypes = new HashSet<>();
    private Set<Strand> strands = new HashSet<>();
    private RequestType requestType;
    private String readMe = "";
    private boolean manualDemux;
    private String name = "";
    private Recipe recipe;
    private boolean bicAutorunnable;
    private String readmeInfo = "";
    private int runNumber;
    private String extraReadMeInfo = "";
    private RequestSpecies species;
    private Set<String> runIds = new TreeSet<>();
    private String pi = "";
    private String invest = "";
    private Set<String> ampTypes = new LinkedHashSet<>();
    private String baitVersion = Constants.EMPTY;
    private Map<String, String> projectInfo = new LinkedHashMap<>();
    private Map<String, Patient> patients = new LinkedHashMap<>();

    private boolean isInnovation;

    public Request(String id) {
        this.id = id;
        isInnovation = id.startsWith(Constants.INNOVATION_PROJECT_ID);
    }

    public Set<String> getRunIds() {
        return runIds;
    }

    public boolean isInnovation() {
        return isInnovation;
    }

    public void setInnovation(boolean innovation) {
        isInnovation = innovation;
    }

    public Map<String, Sample> getSamples() {
        return samples;
    }

    public void setSamples(Map<String, Sample> samples) {
        this.samples = samples;
    }

    public Map<String, Sample> getSamples(Predicate<Sample> samplePredicate) {
        return samples.entrySet().stream()
                .filter(s -> samplePredicate.test(s.getValue()))

                .collect(CommonUtils.getLinkedHashMapCollector());
    }

    public Map<String, Pool> getPools() {
        return pools;
    }

    public String getId() {
        return id;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public Set<Strand> getStrands() {
        return strands;
    }

    public void setStrands(Set<Strand> strands) {
        this.strands = strands;
    }

    public Set<LibType> getLibTypes() {
        return libTypes;
    }

    public void setLibTypes(Set<LibType> libTypes) {
        this.libTypes = libTypes;
    }

    public String getReadMe() {
        return readMe;
    }

    public void setReadMe(String readMe) {
        this.readMe = readMe;
    }

    public boolean isManualDemux() {
        return manualDemux;
    }

    public void setManualDemux(boolean manualDemux) {
        this.manualDemux = manualDemux;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public boolean isBicAutorunnable() {
        return bicAutorunnable;
    }

    public void setBicAutorunnable(boolean bicAutorunnable) {
        this.bicAutorunnable = bicAutorunnable;
    }

    public String getReadmeInfo() {
        return readmeInfo;
    }

    public void setReadmeInfo(String readmeInfo) {
        this.readmeInfo = readmeInfo;
    }

    public void addRunID(String runIDFull) {
        runIds.add(runIDFull);
    }

    public void addAmpType(String ampType) {
        ampTypes.add(ampType);
    }

    public String getInvest() {
        return invest;
    }

    public void setInvest(String invest) {
        this.invest = invest;
    }

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    public int getRunNumber() {
        return runNumber;
    }

    public void setRunNumber(int runNumber) {
        this.runNumber = runNumber;
    }

    public Sample putSampleIfAbsent(String igoSampleId) {
        return putSampleIfAbsent(new Sample(igoSampleId));
    }

    public String getExtraReadMeInfo() {
        //extra readme info is when theere are samples with low coverage. It was requested to be saved in the readme file
        return extraReadMeInfo;
    }

    public void setExtraReadMeInfo(String extraReadMeInfo) {
        this.extraReadMeInfo = extraReadMeInfo;
    }

    public RequestSpecies getSpecies() {
        return species;
    }

    public void setSpecies(RequestSpecies species) {
        this.species = species;
    }

    public Set<String> getAmpTypes() {
        return ampTypes;
    }

    public void setAmpTypes(Set<String> ampTypes) {
        this.ampTypes = ampTypes;
    }

    public String getBaitVersion() {
        return baitVersion;
    }

    public void setBaitVersion(String baitVersion) {
        this.baitVersion = baitVersion;
    }

    public Sample getSample(String igoSampleId) {
        return samples.get(igoSampleId);
    }

    public Pool putPoolIfAbsent(String poolIgoId) {
        pools.putIfAbsent(poolIgoId, new Pool(poolIgoId));
        return pools.get(poolIgoId);
    }

    public Map<String, Patient> getPatients() {
        return patients;
    }

    public Patient putPatientIfAbsent(String patientId) {
        patients.putIfAbsent(patientId, new Patient(patientId));
        return patients.get(patientId);
    }

    public Patient putPatientIfAbsent(Patient patient) {
        String patientId = patient.getPatientId();
        patients.putIfAbsent(patientId, patient);
        return patients.get(patientId);
    }

    public Map<String, String> getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(Map<String, String> projectInfo) {
        this.projectInfo = projectInfo;
    }

    public Sample putPooledNormalIfAbsent(String igoNormalId) {
        samples.putIfAbsent(igoNormalId, new PooledNormalSample(igoNormalId));
        return samples.get(igoNormalId);
    }


    public Optional<Sample> getSampleByCorrectedCmoId(String cmoSampleId) {
        Optional<Sample> sample = samples.values().stream()
                .filter(s -> Objects.equals(s.get(Constants.CORRECTED_CMO_ID), cmoSampleId))
                .findFirst();
        return sample;
    }

    public Optional<Sample> getSampleByCmoId(String cmoSampleId) {
        Optional<Sample> sample = samples.values().stream()
                .filter(s -> Objects.equals(s.getCmoSampleId(), cmoSampleId))
                .findFirst();
        return sample;
    }

    public void addStrand(Strand strand) {
        strands.add(strand);
    }

    public void addLibType(LibType libType) {
        libTypes.add(libType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        return id != null ? id.equals(request.id) : request.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Sample putSampleIfAbsent(Sample sample) {
        samples.putIfAbsent(sample.getIgoId(), sample);
        return samples.get(sample.getIgoId());
    }

    public List<Recipe> getSamplesRecipes() {
        return samples.values().stream().map(s -> s.getRecipe()).collect(Collectors.toList());
    }

    public void putPoolIfAbsent(Pool pool) {
        pools.put(pool.getIgoId(), pool);
    }

    public void addProjectProperty(String propertyName, String value) {
        projectInfo.put(propertyName, value);
    }

    public Sample getOrCreate(String igoSampleId) {
        if(!samples.containsKey(igoSampleId))
            return new Sample(igoSampleId);

        return samples.get(igoSampleId);
    }
}
