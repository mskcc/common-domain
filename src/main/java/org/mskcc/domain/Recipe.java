package org.mskcc.domain;

import org.springframework.core.ParameterizedTypeReference;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Recipe {
    AGILENT_V_4_51_MB_HUMAN("Agilent_v4_51MB_Human"),
    AMPLI_SEQ("AmpliSeq"),
    AMPLICON_SEQ("AmpliconSeq"),
    ARCHER_FUSION_PLEX("ArcherFusionPlex"),
    ARCHER_HEMEPANEL("Archer-HemePanel"),
    ARCHER_SOLIDTUMORPANEL("Archer-SolidTumorPanel"),
    ARCHER_IMMUNOVERSE("Archer-Immunoverse"),
    ATAC_SEQ("ATACSeq"),

    CH_IP_SEQ("ChIPSeq"),
    CRISPR_SCREEN("CRISPRScreen"),
    CRISPR_SEQ("CRISPRSeq"),
    CUSTOM_CAPTURE("CustomCapture"),

    DD_PCR("ddPCR"),
    DROP_SEQ("DropSeq"),

    EXPANDED_GENOMICS("Expanded_Genomics"),
    EXTRACTION_USER_PICKUP("Extraction-UserPickup"),

    FINGERPRINTING("Fingerprinting"),
    FUSION_DISCOVERY_SEQ("FusionDiscoverySeq"),

    HEME_PACT_V_3("HemePACT_v3"),
    HEME_PACT_V_4("HemePACT_v4"),
    HUMAN_WHOLE_GENOME("HumanWholeGenome"),

    IDT_Exome_v1("IDT_Exome_v1"),
    IDT_Exome_v1_FP("IDT_Exome_v1_FP"),
    IDT_Exome_v1_IMPACT468("IDT_Exome_v1_IMPACT468"),
    IMMUNO_SEQ("ImmunoSeq"),
    IMPACT_341("IMPACT341"),
    IMPACT_410("IMPACT410"),
    IMPACT_410_PLUS("IMPACT410+"),
    IMPACT_468("IMPACT468"),
    IN_DROP_SEQ("InDropSeq"),
    ION_AMPLISEQ_CANCER_HOTSPOT_V2("IonAmpliseqCancerHotspotv2"),
    IWG("IWG"),

    M_IMPACT_V_1("M-IMPACT_v1"),
    METHYL_CAPTURE_SEQ("MethylCaptureSeq"),
    METHYL_MINER("MethylMiner"),
    MOUSE_WHOLE_GENOME("MouseWholeGenome"),
    WHOLE_GENOME_BISULFITE_SEQUENCING("WholeGenomeBisulfiteSequencing"),
    MRN_TO_CMOID("MRN_to_CMOID"),
    MSK_ACCESS_V1("MSK-ACCESS_v1"),
    MULTIPLE_OF_THE_ABOVE("(Multiple of the Above)"),

    NANO_STRING("nanoString"),
    NINETY_SIX_WELL_SMARTSEQ2("96Well_SmartSeq2"),

    QC_DISCARD("QC_Discard"),
    QC_PICKUP("QC_Pickup"),

    R_LOOP_DNA_SEQ("R_Loop_DNA_Seq"),
    RIBO_PROFILE_SEQ("RiboProfileSeq"),
    RNA_SEQ("RNASeq"),
    RNA_SEQ_POLY_A("RNASeq_PolyA"),
    RNA_SEQ_RIBO_DEPLETE("RNASeq_RiboDeplete"),
    RRBS("RRBS"),

    SH_RNA_SEQ("shRNASeq"),
    SHALLOW_WGS("ShallowWGS"),
    SMARTER_AMP_SEQ("SMARTerAmpSeq"),
    SPO_11_OLIGO("Spo11Oligo"),
    STR("STR"),

    TCRSeq("TCRSeq"),
    TEN_X_GENOMICS_ATAC("10X_Genomics_ATAC"),
    TEN_X_GENOMICS_CNV("10X_Genomics_CNV"),
    TEN_X_GENOMICS_GENEEXPRESSION("10X_Genomics_GeneExpression"),
    TEN_X_Genomics_RNA("10X_Genomics_RNA"),
    TEN_X_GENOMICS_VDJ_GENEEXPRESSION("10X_Genomics_VDJ_GeneExpression"),
    TEN_X_Genomics_WGS("10X_Genomics_WGS"),

    WHOLE_EXOME_SEQUENCING("WholeExomeSequencing"),
    WHOLE_GENOME_BISULFATE_SEQUENCING("WholeGenomeBisulfateSequencing"),
    WHOLE_GENOME_SEQUENCING("WholeGenomeSequencing");

    private static final Map<String, Recipe> valueToRecipe = new HashMap<>();

    static {
        for (Recipe recipe : Recipe.values()) {
            valueToRecipe.put(recipe.value.toLowerCase(), recipe);
        }
    }

    private String value;

    Recipe(String value) {
        this.value = value;
    }

    public static Recipe getRecipeByValue(String value) {
        if (value == null || value.isEmpty())
            throw new EmptyRecipeException("Empty recipe");

        String loweredValue = value.toLowerCase();
        if (!valueToRecipe.containsKey(loweredValue))
            throw new UnsupportedRecipeException(String.format("Unsupported recipe: %s", value));

        return valueToRecipe.get(loweredValue);
    }

    private static ParameterizedTypeReference<List<String>> getResponseType() {
        return new ParameterizedTypeReference<List<String>>() {
        };
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static class UnsupportedRecipeException extends RuntimeException {
        public UnsupportedRecipeException(String message) {
            super(message);
        }
    }

    public static class EmptyRecipeException extends RuntimeException {
        public EmptyRecipeException(String message) {
            super(message);
        }
    }
}

