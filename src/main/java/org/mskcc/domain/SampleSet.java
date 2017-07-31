package org.mskcc.domain;

import org.mskcc.domain.sample.Sample;

import java.util.HashSet;
import java.util.Set;

public class SampleSet {
    private final String id;
    private String name;
    private Set<Request> requests = new HashSet<>();
    private Set<Sample> samples = new HashSet<>();

    public SampleSet(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Request> getRequests() {
        return requests;
    }

    public void setRequests(Set<Request> requests) {
        this.requests = requests;
    }

    public Set<Sample> getSamples() {
        return samples;
    }

    public void setSamples(Set<Sample> samples) {
        this.samples = samples;
    }

    public void addRequest(Request request) {
        this.requests.add(request);
    }

    public void addSample(Sample sample) {
        this.samples.add(sample);
    }
}
