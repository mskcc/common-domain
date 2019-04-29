package org.mskcc.domain.picardstats;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RnaSeqStats {
    public String filename;
    public String md5RRS;

    public Long pfBases;
    public Long pfAlignedBases;
    public Long ribosomalBases;
    public Long codingBases;
    public Long utrBases;
    public Long intronicBases;
    public Long intergenicBases;
    public Long ignoredReads;
    public Long correctStrandReads;
    public Long incorrectStrandReads;
    public Long numR1TranscriptStrandReads;
    public Long numR2TranscriptStrandReads;
    public Long numUnexplainedReads;
    public Double pctR1TranscriptStrandReads;
    public Double pctR2TranscriptStrandReads;
    public Double pctRibosomalBases;
    public Double pctCodingBases;
    public Double pctUtrBases;
    public Double pctIntronicBases;
    public Double pctIntergenicBases;
    public Double pctMrnaBases;
    public Double pctUsableBases;
    public Double pctCorrectStrandReads;
    public Double medianCvCoverage;
    public Double median5PrimeBias;
    public Double median3PrimeBias;
    public Double median5PrimeTo3PrimeBias;
}