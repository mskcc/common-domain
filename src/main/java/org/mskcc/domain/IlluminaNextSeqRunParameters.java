package org.mskcc.domain;

import java.util.HashMap;
import java.util.Map;

public class IlluminaNextSeqRunParameters extends IlluminaRunParameters implements SequencingParameters {
    public String getRunLength(){
        Long read1 = (Long)super.getField("Read1");
        Long read2 = (Long)super.getField("Read2");
        Long length = read1 - 1;
        String runLength = "PE" + length.toString() ;
        if(read2 == null || read2.equals("")){
            runLength = "SR" + length.toString() ;
        }
        return runLength;
    }

}
