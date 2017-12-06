package org.mskcc.util.tumortype;

import org.mskcc.domain.sample.TumorType;

import java.util.List;

public interface TumorTypeRetriever {
    List<TumorType> retrieve();
}
