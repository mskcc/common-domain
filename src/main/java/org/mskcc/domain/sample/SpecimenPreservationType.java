package org.mskcc.domain.sample;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public enum SpecimenPreservationType {
    FROZEN("Frozen"),
    FFPE("FFPE"),
    CYTOLOGY("Cytology"),
    BLOOD("Blood"),
    FRESH("Fresh"),
    OCT("OCT"),
    TRIZOL("Trizol"),
    OTHER("other");

    private static final Map<String, SpecimenPreservationType> nameToSpecimenPreservationType = new HashMap<>();

    static {
        for (SpecimenPreservationType enumValue : values()) {
            nameToSpecimenPreservationType.put(enumValue.name, enumValue);
        }
    }

    private final String name;

    SpecimenPreservationType(String name) {
        this.name = name;
    }

    public static SpecimenPreservationType fromString(String name) {
        if (!nameToSpecimenPreservationType.containsKey(name))
            throw new RuntimeException(format("Unsupported %s: %s", SpecimenPreservationType.class.getName(), name));

        return nameToSpecimenPreservationType.get(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
