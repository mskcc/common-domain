package org.mskcc.domain;

import java.util.HashMap;
import java.util.Map;

public class IlluminaHiSeqRunParameters extends IlluminaRunParameters implements SequencingParameters {
    public String getRunLength(){
        String read1 = (String)super.getField("Read1");
        String read2 = (String)super.getField("Read2");
        Integer length = Integer.parseInt(read1) - 1;
        String runLength = "PE" + length.toString() ;
        if(read2 == null || read2.equals("")){
            runLength = "SR" + length.toString() ;
        }
        return runLength;
    }

}
