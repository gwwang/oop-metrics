package com.amazon.ata.oop.metrics.reporting;

/**
 * Factory class for creating ExampleMetricsReporter instances.
 */
public class ExampleMetricsReporterFactory implements MetricsReporterFactory {

    @Override
    public MetricsReporter newMetricsReporter() {
        return new ExampleMetricsReporter();
    }
}
