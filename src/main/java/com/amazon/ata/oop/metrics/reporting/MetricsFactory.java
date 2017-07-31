package com.amazon.ata.oop.metrics.reporting;

public interface MetricsFactory {
    /**
     * Produces a Metrics instance.
     * @return
     */
    Metrics newMetrics();

}
