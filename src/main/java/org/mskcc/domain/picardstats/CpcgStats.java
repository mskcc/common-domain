package org.mskcc.domain.picardstats;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CpcgStats {
    public String filename;
    public String md5RRS;

    public String sampleAlias;
    public String library;
    public String context;
    public Integer totalSites;
    public Long totalBases;
    public Long refNonoxoBases;
    public Long refOxoBases;
    public Long refTotalBases;
    public Long altNonoxoBases;
    public Long altOxoBases;
    public Double oxidationErrorRate;
    public Double oxidationQ;

    public Long cRefRefBases;
    public Long gRefRefBases;
    public Long cRefAltBases;
    public Long gRefAltBases;

    public Double cRefOxoErrorRate;
    public Double cRefOxoQ;
    public Double gRefOxoErrorRate;
    public Double gRefOxoQ;
}