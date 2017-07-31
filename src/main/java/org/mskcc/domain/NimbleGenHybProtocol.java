package org.mskcc.domain;

import java.util.Date;

public class NimbleGenHybProtocol extends Protocol {
    private String igoSampleId;
    private Date creationDate;

    public String getIgoSampleId() {
        return igoSampleId;
    }

    public void setIgoSampleId(String igoSampleId) {
        this.igoSampleId = igoSampleId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
