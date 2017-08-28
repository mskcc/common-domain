package org.mskcc.util;

import java.util.Optional;

public class TestUtils {
    public static Optional<Exception> assertThrown(Runnable runnable) {
        try {
            runnable.run();
            return Optional.empty();
        } catch (Exception e) {
            return Optional.of(e);
        }
    }
}
