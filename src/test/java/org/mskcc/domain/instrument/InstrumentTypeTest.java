package org.mskcc.domain.instrument;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mskcc.domain.instrument.InstrumentType.*;

public class InstrumentTypeTest {
    @Before
    public void setUp() throws Exception {
        addCompatibility(MISEQ, HISEQ);
    }

    @Test
    public void whenSequencerTypesAreGiven_shouldValidateCompatibility() throws Exception {
        assertIsCompatible(asList(HISEQ), asList(HISEQ), true);
        assertIsCompatible(asList(HISEQ), asList(MISEQ), true);
        assertIsCompatible(asList(MISEQ), asList(MISEQ), true);
        assertIsCompatible(asList(HISEQ), asList(NOVASEQ), false);
        assertIsCompatible(asList(NOVASEQ), asList(MISEQ), false);
        assertIsCompatible(asList(NOVASEQ), asList(BIOANALYZER), false);
        assertIsCompatible(asList(BIOANALYZER), asList(NOVASEQ), false);
        assertIsCompatible(asList(HISEQ), asList(BIOANALYZER), false);
        assertIsCompatible(asList(NOVASEQ), asList(NOVASEQ), true);
        assertIsCompatible(asList(BIOANALYZER), asList(BIOANALYZER), true);

        assertIsCompatible(asList(HISEQ, NOVASEQ), asList(HISEQ, NOVASEQ), true);
        assertIsCompatible(asList(HISEQ, NOVASEQ), asList(NOVASEQ, HISEQ), true);
        assertIsCompatible(asList(HISEQ, NOVASEQ), asList(MISEQ, NOVASEQ), true);

        assertIsCompatible(asList(HISEQ, NOVASEQ, HISEQ), asList(HISEQ, NOVASEQ), true);
        assertIsCompatible(asList(HISEQ, NOVASEQ, NOVASEQ), asList(MISEQ, NOVASEQ), true);
        assertIsCompatible(asList(HISEQ, NOVASEQ, NOVASEQ), asList(HISEQ, NOVASEQ), true);
        assertIsCompatible(asList(HISEQ, NOVASEQ, MISEQ), asList(MISEQ, NOVASEQ), true);

        assertIsCompatible(asList(HISEQ, NOVASEQ), asList(MISEQ, NOVASEQ), true);
        assertIsCompatible(asList(HISEQ, NOVASEQ, MISEQ, BIOANALYZER, COVARIS), asList(MISEQ, NOVASEQ, COVARIS,
                COVARIS, BIOANALYZER), true);

    }

    private void assertIsCompatible(List<InstrumentType> normalTypes, List<InstrumentType> tumorTypes, boolean
            expected) {
        boolean isCompatible = isCompatible(normalTypes, tumorTypes);
        assertThat(isCompatible, is(expected));
    }
}