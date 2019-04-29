package org.mskcc.domain.picardstats;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WgsStats {
    public String filename;
    public String md5RRS;
    public Long genomeTerritory;
    public Double meanCoverage;
    public Double sdCoverage;
    public Double medianCoverage;
    public Double madCoverage;
    public Double pctExcMapq;
    public Double pctExcDupe;
    public Double pctExcUnpaired;
    public Double pctExcBaseq;
    public Double pctExcOverlap;
    public Double pctExcCapped;
    public Double pctExcTotal;
    public Double pct1X;
    public Double pct5X;
    public Double pct10X;
    public Double pct15X;
    public Double pct20X;
    public Double pct25X;
    public Double pct30X;
    public Double pct40X;
    public Double pct50X;
    public Double pct60X;
    public Double pct70X;
    public Double pct80X;
    public Double pct90X;
    public Double pct100X;
    public Double hetSnpSensitivity;
    public Double hetSnpQ;
}