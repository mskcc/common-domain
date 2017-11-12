package org.mskcc.domain.sample;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public enum NucleicAcid {
    DNA("DNA"),
    RNA("RNA"),
    DNA_AND_RNA("DNA and RNA");

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
        if (StringUtils.isEmpty(value))
            throw new IllegalArgumentException("Nucleid Acid is empty");
        if (!valueToNucleicAcid.containsKey(value))
            throw new RuntimeException(String.format("Unsupported Nucleic Acid: %s", value));
        return valueToNucleicAcid.get(value);
    }

    public String getValue() {
        return value;
    }
}
