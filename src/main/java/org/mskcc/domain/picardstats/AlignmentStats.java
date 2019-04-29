package org.mskcc.domain.picardstats;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlignmentStats {
    public String filename;
    public String md5RRS;
    public Category category;
    public Long totalReads;
    public Long pfReads;
    public Double pctPfReads;
    public Long pfNoiseReads;
    public Long pfReadsAligned;
    public Double pctPfReadsAligned;
    public Long pfAlignedBases;
    public Long pfHqAlignedReads;
    public Long pfHqAlignedBases;
    public Long pfHqAlignedQ20Bases;
    public Double pfHqMedianMismatches;
    public Double pfMismatchRate;
    public Double pfHqErrorRate;
    public Double pfIndelRate;
    public Double meanReadLength;
    public Long readsAlignedInPairs;
    public Double pctReadsAlignedInPairs;
    public Long pfReadsImproperPairs;
    public Double pctPfReadsImproperPairs;
    public Long badCycles;
    public Double strandBalance;
    public Double pctChimeras;
    public Double pctAdapter;

    public enum Category {UNPAIRED, FIRST_OF_PAIR, SECOND_OF_PAIR, PAIR}
}