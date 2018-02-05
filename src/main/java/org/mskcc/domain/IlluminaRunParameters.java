package org.mskcc.domain;

import java.util.HashMap;
import java.util.Map;

public class IlluminaRunParameters {
    Map<String, Object> parameterFields = new HashMap<>();

    public Map<String, Object> getParameterFields() {
        return parameterFields;
    }

    public void getParameterFields(Map<String, Object> parameterFields) {
        this.parameterFields = parameterFields;
    }

    public void put(String fieldName, Object value) {
        parameterFields.putIfAbsent(fieldName, value);
    }

    public Object getField(String name) {
        return parameterFields.get(name);
    }

    public boolean containsField(String name) {
        return parameterFields.containsKey(name);
    }
}
