package org.mskcc.domain;

import org.mskcc.util.Constants;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PooledNormalSample extends Sample {
    public PooledNormalSample(String id) {
        super(id);
    }

    @Override
    public boolean isValid() {
        return !getProperties().get(Constants.CAPTURE_BAIT_SET).contains(",");
    }

    @Override
    public Set<Run> getValidRuns() {
        return runs.values().stream()
                .filter(r -> Run.getAllRuns(Run::isPassed).contains(r)).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getValidRunIds() {
        Set<String> includeRunIds = Arrays.stream(get(Constants.INCLUDE_RUN_ID).split(";")).filter(r -> !"".equals(r)).collect(Collectors.toSet());

        // 05737_R jest PITT_0112 ktorego nie powinno byc
        /*Set<String> passedRuns = runs.values().stream()
                .filter(r -> Run.getAllRuns().contains(r)).map(r -> r.getId()).collect(Collectors.toSet());*/

        Set<String> passedRuns = runs.values().stream().filter(r -> r.getPoolQcStatus() == QcStatus.PASSED).map(r -> r.getId()).collect(Collectors.toSet());
        Set<String> validRunIds = new HashSet<>();
        validRunIds.addAll(includeRunIds);
//        validRunIds.addAll(passedRuns);
        return validRunIds;
    }

    @Override
    public Run putRunIfAbsent(String runID) {
        if (!runs.containsKey(runID)) {
            Run run = new Run(runID);
            runs.put(runID, run);
        }
        return runs.get(runID);
    }
}
