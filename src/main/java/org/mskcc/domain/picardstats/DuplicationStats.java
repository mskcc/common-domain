package org.mskcc.domain.picardstats;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DuplicationStats {
    public String filename;
    public String md5RRS;
    public String LIBRARY;
    public Long unpairedReadsExamined;
    public Long readPairsExamined;
    public Long secondaryOrSupplementaryRds;
    public Long unmappedReads;
    public Long unpairedReadDuplicates;
    public Long readPairDuplicates;
    public Long readPairOpticalDuplicates;
    public Double percentDuplication;
    public Long estimatedLibrarySize;
}