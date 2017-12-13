package org.mskcc.util.http;

import java.io.IOException;

public interface CurlCaller {
    String call(String... parameters) throws IOException;
}
