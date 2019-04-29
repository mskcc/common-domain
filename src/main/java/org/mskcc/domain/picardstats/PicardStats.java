package org.mskcc.domain.picardstats;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PicardStats {
    private String filename;

    private String run;
    private String request;
    private String sample;

    private String referenceGenome;
    private String fileType;
    private Date lastModified;
    private Date fileImported;
    private String md5RRS;
    private boolean parseOK;

    private AlignmentStats alignmentStats;
    private CpcgStats cpcgStats;
    private DuplicationStats duplicationStats;
    private HsStats hsStats;
    private QStats qStats;
    private RnaSeqStats rnaSeqStats;
    private WgsStats wgsStats;
}