package org.mskcc.util.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessBuilderCurlCaller implements CurlCaller {
    @Override
    public String call(String... parameters) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(parameters);
        Process process = processBuilder.start();

        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder responseStrBuilder = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            responseStrBuilder.append(line);
        }

        return responseStrBuilder.toString();
    }
}
