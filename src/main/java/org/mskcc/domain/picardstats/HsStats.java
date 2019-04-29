package org.mskcc.domain.picardstats;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HsStats {
    public String filename;
    public String md5RRS;
    public String baitSet;
    public Long genomeSize;
    public Long baitTerritory;
    public Long targetTerritory;
    public Double baitDesignEfficiency;
    public Long totalReads;
    public Long pfReads;
    public Long pfUniqueReads;
    public Double pctPfReads;
    public Double pctPfUqReads;
    public Long pfUqReadsAligned;
    public Double pctPfUqReadsAligned;
    public Long pfBasesAligned;
    public Long pfUqBasesAligned;
    public Long onBaitBases;
    public Long nearBaitBases;
    public Long offBaitBases;
    public Long onTargetBases;
    public Double pctSelectedBases;
    public Double pctOffBait;
    public Double onBaitVsSelected;
    public Double meanBaitCoverage;
    public Double meanTargetCoverage;
    public Double medianTargetCoverage;
    public Long maxTargetCoverage;
    public Double pctUsableBasesOnBait;
    public Double pctUsableBasesOnTarget;
    public Double foldEnrichment;
    public Double zeroCvgTargetsPct;
    public Double pctExcDupe;
    public Double pctExcMapq;
    public Double pctExcBaseq;
    public Double pctExcOverlap;
    public Double pctExcOffTarget;
    public Double fold80BasePenalty;
    public Double pctTargetBases1X;
    public Double pctTargetBases2X;
    public Double pctTargetBases10X;
    public Double pctTargetBases20X;
    public Double pctTargetBases30X;
    public Double pctTargetBases40X;
    public Double pctTargetBases50X;
    public Double pctTargetBases100X;
    public Long hsLibrarySize;
    public Double hsPenalty10X;
    public Double hsPenalty20X;
    public Double hsPenalty30X;
    public Double hsPenalty40X;
    public Double hsPenalty50X;
    public Double hsPenalty100X;
    public Double atDropout;
    public Double gcDropout;
    public Double hetSnpSensitivity;
    public Double hetSnpQ;
}