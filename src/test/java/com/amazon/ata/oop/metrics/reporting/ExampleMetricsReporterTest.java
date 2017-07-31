package com.amazon.ata.oop.metrics.reporting;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExampleMetricsReporterTest {

    @InjectMocks
    private ExampleMetricsReporter reporter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAcceptMetrics() {
        Metrics metrics = mock(Metrics.class);

        // this is using a feature in Mockito where
        // multiple calls to a method stub will return different values.
        // Here, I am specifying 10 for the first, 20 as second, and 30
        // for the 3rd and more calls.
        when(metrics.getLength()).thenReturn(10, 20, 30);

        // simulate accept metrics 3 times
        reporter.accept(metrics);
        reporter.accept(metrics);
        reporter.accept(metrics);

        assertEquals(10, reporter.getMinLength());
        assertEquals(30, reporter.getMaxLength());
        assertEquals(3, reporter.getCount());
    }

}
