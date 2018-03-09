package org.mskcc.domain;

import org.mskcc.domain.sample.Sample;

import java.util.*;

public class SampleSet  {
    public static final String RECORD_TYPE = "SampleSet";
    public static final String SET_NAME = "Name";
    private final String name;
    private Map<String, Sample> samples = new LinkedHashMap<>();
    private Map<String, Request> requests = new LinkedHashMap<>();
    private String assay;
    private Request prime;
    private String recipe;

    public SampleSet(String sampleId) {
        this.name = sampleId;
    }

    public String getName() {
        return name;
    }

    public Map<String, Sample> getSamples() {
        return samples;
    }

    public void setSamples(Map<String, Sample> samples) {
        this.samples = samples;
    }
    public Sample putSampleIfAbsent(String igoSampleId) {
        return putSampleIfAbsent(new Sample(igoSampleId));
    }

    public Sample putSampleIfAbsent(Sample sample) {
        samples.putIfAbsent(sample.getIgoId(), sample);
        return samples.get(sample.getIgoId());
    }

    public Map<String, Request> getRequests() {
        return requests;
    }
    public Request putRequestIfAbsent(String requestId) {
        return putSampleIfAbsent(new Request(requestId));
    }

    public Request putSampleIfAbsent(Request request) {
        requests.putIfAbsent(request.getId(), request);
        return requests.get(request.getId());
    }

    public void setRequests(Map<String, Request> requests) {
        this.requests = requests;
    }

    public String getAssay() {
        return assay;
    }

    public void setAssay(String assay) {
        this.assay = assay;
    }

    public Request getPrime() {
        return prime;
    }

    public void setPrime(Request prime) {
        this.prime = prime;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleSet sampleSet = (SampleSet) o;
        return Objects.equals(name, sampleSet.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
