package org.mskcc.domain;

import java.util.function.Predicate;

public class PostQcPassedPredicate implements Predicate<Run> {
    @Override
    public boolean test(Run run) {
        return run.getPostQcStatus() == QcStatus.PASSED || run.getPostQcStatus() == null;
    }
}
