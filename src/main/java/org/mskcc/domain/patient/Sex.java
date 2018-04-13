package org.mskcc.domain.patient;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public enum Sex {
    F("F"),
    M("M");

    private static final Map<String, Sex> nameToEnum = new HashMap<>();

    static {
        for (Sex enumValue : values()) {
            nameToEnum.put(enumValue.name, enumValue);
        }
    }

    private final String name;

    Sex(String name) {
        this.name = name;
    }

    public static Sex fromString(String name) {
        if (!nameToEnum.containsKey(name))
            throw new RuntimeException(format("Unsupported %s: %s", Sex.class.getName(), name));

        return nameToEnum.get(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
