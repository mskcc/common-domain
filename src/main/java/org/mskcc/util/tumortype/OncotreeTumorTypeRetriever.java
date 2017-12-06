package org.mskcc.util.tumortype;

import org.mskcc.domain.sample.TumorType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class OncotreeTumorTypeRetriever implements TumorTypeRetriever {
    private final String tumorTypeServiceUrl;

    public OncotreeTumorTypeRetriever(String tumorTypeServiceUrl) {
        this.tumorTypeServiceUrl = tumorTypeServiceUrl;
    }

    @Override
    public List<TumorType> retrieve() {
        TumorTypesList tumorTypesList = new RestTemplate().getForObject(tumorTypeServiceUrl, TumorTypesList.class);

        return tumorTypesList.getTumorTypes();
    }
}
