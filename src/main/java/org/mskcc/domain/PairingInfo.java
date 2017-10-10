package org.mskcc.domain;

import org.mskcc.domain.sample.Sample;

public class PairingInfo {
    private final Sample tumor;
    private final Sample normal;

    public PairingInfo(Sample tumor, Sample normal) {
        this.tumor = tumor;
        this.normal = normal;
    }

    public Sample getTumor() {
        return tumor;
    }

    public Sample getNormal() {
        return normal;
    }
}
