package com.amazon.ata.oop.metrics.reporting;

public class MetricsFactoryImpl implements MetricsFactory {

    private final MetricsReporter metricsReporter;

    public MetricsFactoryImpl(MetricsReporter metricsReporter) {
        this.metricsReporter = metricsReporter;
    }

    @Override
    public Metrics newMetrics() {
        return new MetricsImpl(metricsReporter);
    }
}
