package org.mskcc.domain.sample;

import java.util.HashMap;
import java.util.Map;

public enum SpecimenType {
    BIOPSY("Biopsy"),
    RESECTION("Resection"),
    BLOOD("Blood"),
    CELLLINE("CellLine"),
    CFDNA("cfDNA"),
    PDX("PDX"),
    XENOGRAFT("Xenograft"),
    XENOGRAFTDERIVEDCELLLINE("XenograftDerivedCellLine"),
    RAPIDAUTOPSY("RapidAutopsy"),
    FINGERNAILS("Fingernails"),
    ORGANOID("Organoid"),
    SALIVA("Saliva"),
    OTHER("other");

    private static final Map<String, SpecimenType> valueToSpecimenType = new HashMap<>();

    static {
        for (SpecimenType specimenType : values()) {
            valueToSpecimenType.put(specimenType.value, specimenType);
        }
    }

    private String value;

    SpecimenType(String value) {
        this.value = value;
    }

    public static SpecimenType fromValue(String value) {
        if (!valueToSpecimenType.containsKey(value))
            throw new RuntimeException(String.format("Unsupported Specimen Type: %s", value));
        return valueToSpecimenType.get(value);
    }

    public String getValue() {
        return value;
    }
}
