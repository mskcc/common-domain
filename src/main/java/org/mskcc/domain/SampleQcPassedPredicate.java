package org.mskcc.domain;

import java.util.function.Predicate;

public class SampleQcPassedPredicate implements Predicate<Run> {
    @Override
    public boolean test(Run run) {
        return run.getSampleLevelQcStatus() == QcStatus.PASSED ||
                (run.getSampleLevelQcStatus() == null && run.getPoolQcStatus() == QcStatus.PASSED);
    }
}
