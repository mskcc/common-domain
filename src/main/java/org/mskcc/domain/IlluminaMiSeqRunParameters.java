package org.mskcc.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;

public class IlluminaMiSeqRunParameters extends IlluminaRunParameters implements SequencingParameters {
    public String getRunLength(){
        String sampleSheetName = (String)super.getField("SampleSheetName");
        String runLength = "NA";
        Pattern pat = Pattern.compile("[A-Z0-9]+-(\\d+)V[0-9]");
        Matcher fileInfo = pat.matcher(sampleSheetName);
        if(sampleSheetName != null && fileInfo.matches()){ 
            Integer length = Integer.parseInt(fileInfo.group(1));
            if(length == 50){
                runLength = "SR" + length.toString() ;
            } else {
              runLength =  "PE" + (new Integer(length/2)).toString() ;
            }
        }
        return runLength;
    }

}
