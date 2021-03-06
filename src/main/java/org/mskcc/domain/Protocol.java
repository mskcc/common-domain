package org.mskcc.domain;

import java.util.HashMap;
import java.util.Map;

public class Protocol {
    private Map<String, Object> protocolFields = new HashMap<>();
    private Boolean valid;

    public Map<String, Object> getProtocolFields() {
        return protocolFields;
    }

    public void setProtocolFields(Map<String, Object> protocolFields) {
        this.protocolFields = protocolFields;
    }

    public void put(String fieldName, Object value) {
        protocolFields.putIfAbsent(fieldName, value);
    }

    public Object getField(String name) {
        return protocolFields.get(name);
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Boolean isValid() {
        return valid;
    }

    public boolean containsField(String name) {
        return protocolFields.containsKey(name);
    }
}
