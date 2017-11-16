package org.mskcc.domain.sample;

import org.mskcc.domain.RequestSpecies;

import java.util.function.Predicate;

public class HumanSamplePredicate implements Predicate<BankedSample> {
    @Override
    public boolean test(BankedSample bankedSample) {
        return RequestSpecies.getSpeciesByValue(bankedSample.getSpecies()) == RequestSpecies.HUMAN ||
                SpecimenType.fromValue(bankedSample.getSpecimenType()) == SpecimenType.PDX ||
                SpecimenType.fromValue(bankedSample.getSpecimenType()) == SpecimenType.XENOGRAFT ||
                SpecimenType.fromValue(bankedSample.getSpecimenType()) == SpecimenType.XENOGRAFTDERIVEDCELLLINE;
    }
}
