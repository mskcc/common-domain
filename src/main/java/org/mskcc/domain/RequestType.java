package org.mskcc.domain;

import java.util.HashMap;
import java.util.Map;

public enum RequestType {
    IMPACT("impact"),
    EXOME("exome"),
    OTHER("other"),
    RNASEQ("rnaseq");

    private static Map<String, RequestType> nameToRequestType = new HashMap<>();

    static {
        for (RequestType requestType : values()) {
            nameToRequestType.put(requestType.getName(), requestType);
        }
    }

    private String name;

    RequestType(String name) {
        this.name = name;
    }

    public static RequestType getByName(String name) {
        if (!nameToRequestType.containsKey(name))
            throw new RuntimeException(String.format("Unsupported Request Type: %s", name));
        return nameToRequestType.get(name);
    }

    public String getName() {
        return name;
    }
}
