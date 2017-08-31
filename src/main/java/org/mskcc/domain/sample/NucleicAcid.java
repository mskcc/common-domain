package org.mskcc.domain.sample;

import java.util.HashMap;
import java.util.Map;

public enum NucleicAcid {
    DNA("DNA"),
    RNA("RNA");

    private static final Map<String, NucleicAcid> valueToNucleicAcid = new HashMap<>();

    static {
        for (NucleicAcid sampleClass : values()) {
            valueToNucleicAcid.put(sampleClass.value, sampleClass);
        }
    }

    private String value;

    NucleicAcid(String value) {
        this.value = value;
    }

    public static NucleicAcid fromValue(String value) {
        if (!valueToNucleicAcid.containsKey(value))
            throw new RuntimeException(String.format("Unsupported Nucleic Acid: %s", value));
        return valueToNucleicAcid.get(value);
    }

    public String getValue() {
        return value;
    }
}
