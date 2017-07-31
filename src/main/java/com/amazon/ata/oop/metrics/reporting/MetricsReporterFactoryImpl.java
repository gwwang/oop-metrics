package com.amazon.ata.oop.metrics.reporting;

public class MetricsReporterFactoryImpl implements MetricsReporterFactory {
    @Override
    public MetricsReporter newMetricsReporter() {
        return new MetricsReporterImpl();
    }
}
