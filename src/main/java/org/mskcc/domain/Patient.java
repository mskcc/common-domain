package org.mskcc.domain;

import org.mskcc.domain.sample.Sample;

import java.util.LinkedHashSet;
import java.util.Set;

public class Patient {
    private static int count = 0;
    private Set<Sample> samples = new LinkedHashSet<>();
    private String patientId;
    private int groupNumber;

    public Patient(String patientId) {
        this.patientId = patientId;
        groupNumber = count++;
    }

    public static void resetGroupCounter() {
        count = 0;
    }

    public Set<Sample> getSamples() {
        return samples;
    }

    public String getPatientId() {
        return patientId;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public boolean isValid() {
        return !patientId.startsWith("#");
    }

    public void addSample(Sample sample) {
        samples.add(sample);
    }

    public void addSamples(Set<Sample> samples) {
        this.samples.addAll(samples);
    }
}
