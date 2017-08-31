package org.mskcc.domain.sample;

import java.util.HashMap;
import java.util.Map;

public enum SampleClass {
    ADJACENT_NORMAL("Adjacent Normal"),
    ADJACENT_TISSUE("Adjacent Tissue"),
    CELL_FREE("Cell free"),
    LOCAL_RECURRENCE("Local Recurrence"),
    METASTASIS("Metastasis"),
    NORMAL("Normal"),
    OTHER("Other"),
    PRIMARY("Primary"),
    UNKNOWN_TUMOR("Unknown Tumor");

    private static final Map<String, SampleClass> valueToSampleClass = new HashMap<>();

    static {
        for (SampleClass sampleClass : values()) {
            valueToSampleClass.put(sampleClass.value, sampleClass);
        }
    }

    private String value;

    SampleClass(String value) {
        this.value = value;
    }

    public static SampleClass fromValue(String value) {
        if (!valueToSampleClass.containsKey(value))
            throw new RuntimeException(String.format("Unsupported Sample Class: %s", value));
        return valueToSampleClass.get(value);
    }

    public String getValue() {
        return value;
    }
}
