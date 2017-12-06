package org.mskcc.util.tumortype;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.mskcc.domain.sample.TumorType;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TumorTypesList {
    private String disclaimer;

    @JsonProperty("record-count")
    private int recordCount;

    @JsonProperty("results")
    private List<TumorType> tumorTypes;

    public TumorTypesList() {
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public List<TumorType> getTumorTypes() {
        return tumorTypes;
    }

    public void setTumorTypes(List<TumorType> tumorTypes) {
        this.tumorTypes = tumorTypes;
    }
}
