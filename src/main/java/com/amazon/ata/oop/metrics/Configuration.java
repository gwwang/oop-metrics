package com.amazon.ata.oop.metrics;

import com.amazon.ata.oop.metrics.reporting.ExampleMetricsReporterFactory;
import com.amazon.ata.oop.metrics.reporting.MetricsFactory;
import com.amazon.ata.oop.metrics.reporting.MetricsFactoryImpl;
import com.amazon.ata.oop.metrics.reporting.MetricsReporter;
import com.amazon.ata.oop.metrics.reporting.MetricsReporterFactory;
import com.amazon.ata.oop.metrics.service.randomstring.RandomStringService;
import com.amazon.ata.oop.metrics.service.randomstring.RandomStringServiceClient;

import java.util.Random;

/**
 * The {@code Configuration} class handles most of the boilerplate
 * code creating the necessary objects for the simulation.
 *
 * This class also provides other configuration such as total number
 * of iterations and string length.
 */
public class Configuration {

    private final int maxIterations = 100;
    private final int minStringLength = 5;
    private final int maxStringLength = 50;
    private final MetricsReporter metricsReporter;

    public Configuration() {
        this.metricsReporter = getMetricsReporterFactory().newMetricsReporter();
    }

    public int getMaxIterations() {
        return maxIterations;
    }

    public int getMinStringLength() {
        return minStringLength;
    }

    public int getMaxStringLength() {
        return maxStringLength;
    }

    // change the body of this method to change to a different Metricsfactory
    public MetricsFactory getMetricsFactory() {
        return new MetricsFactoryImpl(metricsReporter);
    }

    // change the body of this method to change to a different MetricsReporterFactory
    protected MetricsReporterFactory getMetricsReporterFactory() {
        return new ExampleMetricsReporterFactory();
    }

    public MetricsReporter getMetricsReporter() {
        return this.metricsReporter;
    }

    public RandomStringServiceClient getRandomStringServiceClient() {
        return new RandomStringServiceClient(new RandomStringService(new Random(), new Random()));
    }

}
