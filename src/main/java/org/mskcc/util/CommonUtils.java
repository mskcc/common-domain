package org.mskcc.util;

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
}
