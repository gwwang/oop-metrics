package com.amazon.ata.oop.metrics.reporting;

public interface MetricsReporter {

    void accept(Metrics metrics);

    void generateReport();

}
