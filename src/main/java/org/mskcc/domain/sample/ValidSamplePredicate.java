package org.mskcc.domain.sample;

import org.apache.log4j.Logger;

import java.util.function.Predicate;

class ValidSamplePredicate implements Predicate<Sample> {
    private static final Logger LOGGER = Logger.getLogger(ValidSamplePredicate.class);

    @Override
    public boolean test(Sample sample) {
        boolean hasValidRun = sample.getRuns().values().stream()
                .anyMatch(r -> r.isPassed());

        if (!hasValidRun)
            LOGGER.warn(String.format("Sample %s has no valid runs. It will be omitted.", sample.getIgoId()));

        return hasValidRun;
    }
}
