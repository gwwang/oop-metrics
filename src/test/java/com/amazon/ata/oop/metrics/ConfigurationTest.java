package com.amazon.ata.oop.metrics;

import com.amazon.ata.oop.metrics.reporting.ExampleMetricsReporter;
import com.amazon.ata.oop.metrics.reporting.ExampleMetricsReporterFactory;
import com.amazon.ata.oop.metrics.reporting.MetricsFactory;
import com.amazon.ata.oop.metrics.reporting.MetricsFactoryImpl;
import com.amazon.ata.oop.metrics.reporting.MetricsReporter;
import com.amazon.ata.oop.metrics.reporting.MetricsReporterFactory;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConfigurationTest {

    private Configuration configuration = new Configuration();

    @Test
    public void getMetricsFactoryTest() {
        MetricsFactory metricsFactory = configuration.getMetricsFactory();
        assertTrue(metricsFactory instanceof MetricsFactoryImpl);
    }

    @Test
    public void getMetricsReporterFactoryTest() {
        MetricsReporterFactory metricsReporterFactory = configuration.getMetricsReporterFactory();
        assertTrue(metricsReporterFactory instanceof ExampleMetricsReporterFactory);
    }

    @Test
    public void getMetricsReporterTest() {
        MetricsReporter metricsReporter = configuration.getMetricsReporter();
        assertTrue(metricsReporter instanceof ExampleMetricsReporter);
    }

}
