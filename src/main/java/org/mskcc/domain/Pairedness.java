package org.mskcc.domain;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public enum Pairedness {
    PE("PE"),
    SE("SE");

    private final String name;
    private static final Map<String, Pairedness> nameToEnum = new HashMap<>();

    static {
        for (Pairedness enumValue : values()) {
    		nameToEnum.put(enumValue.name, enumValue);
    	}
    }

    Pairedness(String name) {
    	this.name = name;
    }

    public static Pairedness fromString(String name) {
    	if(!nameToEnum.containsKey(name))
    	    throw new RuntimeException(format("Unsupported %s: %s", Pairedness.class.getName(), name));

    	return nameToEnum.get(name);
    }

    @Override
    public String toString() {
    	return name;
    }
}
