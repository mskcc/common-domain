package org.mskcc.domain.instrument;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public enum InstrumentType {
    ALL_COMPATIBLE_NA_NORMAL("All compatible na normal"),
    BIOANALYZER("Bioanalyzer"),
    COVARIS("Covaris"),
    DMP_SAMPLE("DMPSample"),
    FRAGMENT_ANALYZER("Fragment Analyzer"),
    GEL_IMAGER("GelImager"),
    HISEQ("HiSeq"),
    LABEL_PRINTER("Label Printer"),
    MISEQ("MiSeq"),
    NANODROP("Nanodrop"),
    NANODROPPER("Nanodropper"),
    NEXT_SEQ("NextSeq"),
    NOVASEQ("NovaSeq"),
    QUANT_IT("Quant-it"),
    QUANT_IT_NEO("Quant-it-Neo"),
    QUIT("Quit"),
    SPECTRA_MAX("SpectraMax"),
    TAPESTATION("Tapestation"),
    THERMOCYCLER("Thermocycler");

    private static final Multimap<InstrumentType, InstrumentType> instrumentCompatibility = HashMultimap.create();
    private static final Map<String, InstrumentType> nameToEnum = new HashMap<>();
    private static final Map<String, InstrumentType> instrumentTypeToNames = new HashMap<>();

    static {
        for (InstrumentType enumValue : values()) {
            nameToEnum.put(enumValue.value, enumValue);
        }
    }

    private final String value;

    InstrumentType(String value) {
        this.value = value;
    }

    public static InstrumentType fromString(String name) {
        if (!nameToEnum.containsKey(name))
            throw new RuntimeException(format("Unsupported %s: %s", InstrumentType.class.getName(), name));

        return nameToEnum.get(name);
    }

    public static void addCompatibility(InstrumentType instrumentType1, InstrumentType instrumentType2) {
        instrumentCompatibility.put(instrumentType1, instrumentType2);
        instrumentCompatibility.put(instrumentType2, instrumentType1);
    }

    public static void mapNameToType(String instrumentName, InstrumentType instrumentType) {
        instrumentTypeToNames.put(instrumentName, instrumentType);
    }

    public static InstrumentType getInstrumentTypeByName(String instrumentName) {
        if (!instrumentTypeToNames.containsKey(instrumentName))
            throw new RuntimeException(String.format("Unsupported instrument name: %s", instrumentName));

        return instrumentTypeToNames.get(instrumentName);
    }

    public static boolean isCompatible(List<InstrumentType> normalInstrumentTypes, List<InstrumentType>
            tumorInstrumentType) {
        if (isCompatibleWithAll(normalInstrumentTypes) || isCompatibleWithAll(tumorInstrumentType))
            return true;

        return hasMatchedSeqType(normalInstrumentTypes, tumorInstrumentType) && hasMatchedSeqType
                (tumorInstrumentType, normalInstrumentTypes);
    }

    private static boolean hasMatchedSeqType(List<InstrumentType> instrumentTypes1, List<InstrumentType>
            instrumentTypes2) {
        return instrumentTypes1.stream()
                .allMatch(it -> isCompatible(instrumentTypes2, it));
    }

    private static boolean isCompatible(List<InstrumentType> instrumentTypes, InstrumentType instrumentType) {
        return instrumentTypes.contains(instrumentType) || instrumentTypes.stream().anyMatch(i -> ((HashMultimap)
                instrumentCompatibility).get(instrumentType).contains(i));
    }

    private static boolean isCompatibleWithAll(List<InstrumentType> instrumentTypes) {
        return instrumentTypes.size() == 1 && (instrumentTypes.get(0) == ALL_COMPATIBLE_NA_NORMAL ||
                instrumentTypes.get(0) == DMP_SAMPLE);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
