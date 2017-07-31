package com.amazon.ata.oop.metrics;

import com.amazon.ata.oop.metrics.reporting.Metrics;
import com.amazon.ata.oop.metrics.reporting.MetricsFactory;
import com.amazon.ata.oop.metrics.reporting.MetricsReporter;
import com.amazon.ata.oop.metrics.service.randomstring.RandomStringServiceClient;
import com.amazon.ata.oop.metrics.service.randomstring.model.GenerateAlphaStringRequest;
import com.amazon.ata.oop.metrics.service.randomstring.model.GenerateAlphaStringResponse;

import java.time.Instant;
import java.util.Random;

/**
 *  The {@code Simulator} is the entry point class of this project.
 */
public final class Simulator {

    private final MetricsFactory metricsFactory;
    private final int iterations;
    private final int minStringLength;
    private final int maxStringLength;
    private final RandomStringServiceClient serviceClient;
    private final MetricsReporter metricsReporter;

    public Simulator(Configuration configuration) {
        this.metricsFactory = configuration.getMetricsFactory();
        this.iterations = configuration.getMaxIterations();
        this.minStringLength = configuration.getMinStringLength();
        this.maxStringLength = configuration.getMaxStringLength();
        this.serviceClient = configuration.getRandomStringServiceClient();
        this.metricsReporter = configuration.getMetricsReporter();
    }

    public void runSimulation() {

        System.out.printf("Running simulation\nIterations:%s\nMinLength:%s\nMaxLength:%s\n",
                          iterations, minStringLength, maxStringLength);

        Random randomLength = new Random();
        int progressMod = Math.max(1,iterations / 10);
        int percentage = 0;

        // for each iteration:
        // - get a random length request
        // - get a new metric instance and intialize
        // - call the service
        // - close the metric instance
        for (int i = 0; i < iterations; i++) {
            int stringLength = getNextLength(randomLength);
            Metrics metrics = newMetrics(stringLength);
            callService(stringLength);
            closeMetrics(metrics);

            if (i % progressMod == 0) {
                System.out.printf("%s%% ", percentage++ * 10);
            }
        }

        System.out.println("\nFinished simulation.");
        metricsReporter.generateReport();
    }

    private String callService(int stringLength) {
        GenerateAlphaStringRequest request = new GenerateAlphaStringRequest(stringLength);
        GenerateAlphaStringResponse response = serviceClient.generateAlphaString(request);
        return response.getRandomAlphaString();
    }

    private Metrics newMetrics(int stringLength) {
        Metrics metrics = metricsFactory.newMetrics();
        metrics.setName("RandomStringService.Latency");
        metrics.setLength(stringLength);
        metrics.setStart(Instant.now());
        return metrics;
    }

    private void closeMetrics(Metrics metrics) {
        metrics.setEnd(Instant.now());
        metrics.close();
    }

    private int getNextLength(Random random) {
        int next = -1;

        do {
            next = random.nextInt(maxStringLength + 1);
        } while (next < minStringLength);

        return next;
    }

    /**
     * This is the where it all begins.
     */
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        Simulator simulator = new Simulator(configuration);
        simulator.runSimulation();
        System.exit(0);
    }

}
