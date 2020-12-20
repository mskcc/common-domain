package org.mskcc.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CommonUtils {
    public static <T> Collector<Map.Entry<String, T>, ?, LinkedHashMap<String, T>> getLinkedHashMapCollector() {
        return Collectors.toMap(p -> p.getKey(), p -> p.getValue(), (u, v) -> {
            throw new IllegalStateException(String.format("Duplicate key %s", u));
        }, LinkedHashMap::new);
    }

    public static String requireNonNullNorEmpty(String string, String message) {
        if (string == null || "".equals(string))
            throw new NullOrEmptyException(message);
        return string;
    }

    public static void runAndCatchNpe(Runnable runnable) {
        try {
            runnable.run();
        } catch (NullPointerException omitted) {
        }
    }

    public static <T> boolean collectionsEqualsIgnoreOrder(Collection<T> c1, Collection<T> c2) {
        return new HashSet<>(c1).equals(new HashSet<>(c2));
    }

    public static class NullOrEmptyException extends RuntimeException {
        public NullOrEmptyException(String message) {
            super(message);
        }
    }

    public static boolean isPooledNormal(String sampleId) {
        return sampleId.startsWith("CTRL-") || sampleId.contains(Constants.POOLNORMAL);
    }
}
