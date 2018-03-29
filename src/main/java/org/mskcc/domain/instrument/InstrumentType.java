package org.mskcc.domain.instrument;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import java.util.HashMap;
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
        instrumentCompatibility.put(InstrumentType.HISEQ, InstrumentType.MISEQ);
        instrumentCompatibility.put(InstrumentType.MISEQ, InstrumentType.HISEQ);
    }

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

    public static void mapNameToType(String instrumentName, InstrumentType instrumentType) {
        instrumentTypeToNames.put(instrumentName, instrumentType);
    }

    public static InstrumentType getInstrumentTypeByName(String instrumentName) {
        if(!instrumentTypeToNames.containsKey(instrumentName))
            throw new RuntimeException(String.format("Unsupported instrument name: %s", instrumentName));

        return instrumentTypeToNames.get(instrumentName);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    public boolean isCompatibleWith(InstrumentType instrumentType) {
        if (instrumentType == ALL_COMPATIBLE_NA_NORMAL || instrumentType == DMP_SAMPLE)
            return true;

        return this == instrumentType || instrumentCompatibility.get(this).contains(instrumentType);
    }
}
