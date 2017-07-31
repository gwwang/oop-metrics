package com.amazon.ata.oop.metrics;

import com.amazon.ata.oop.metrics.reporting.Metrics;
import com.amazon.ata.oop.metrics.reporting.MetricsFactory;
import com.amazon.ata.oop.metrics.reporting.MetricsReporter;
import com.amazon.ata.oop.metrics.service.randomstring.RandomStringServiceClient;
import com.amazon.ata.oop.metrics.service.randomstring.model.GenerateAlphaStringRequest;
import com.amazon.ata.oop.metrics.service.randomstring.model.GenerateAlphaStringResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SimulatorTest {

    @Mock
    private Configuration configuration;
    @Mock
    private RandomStringServiceClient client;
    @Mock
    private MetricsFactory metricsFactory;
    @Mock
    private MetricsReporter metricsReporter;
    private Simulator simulator;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(configuration.getMaxIterations()).thenReturn(1);
        when(configuration.getMinStringLength()).thenReturn(1);
        when(configuration.getMaxStringLength()).thenReturn(10);
        when(configuration.getMetricsFactory()).thenReturn(metricsFactory);
        when(configuration.getMetricsReporter()).thenReturn(metricsReporter);
        when(configuration.getRandomStringServiceClient()).thenReturn(client);
    }

    @Test
    public void usesConfigurationToObjects() {
        new Simulator(configuration);
        verify(configuration).getMaxIterations();
        verify(configuration).getMaxStringLength();
        verify(configuration).getMinStringLength();
        verify(configuration).getRandomStringServiceClient();
        verify(configuration).getMetricsFactory();
        verify(configuration).getMetricsReporter();
    }

    @Test
    public void testSimulatorSequenceOfCalls() {
        Metrics metrics = mock(Metrics.class);

        when(metricsFactory.newMetrics()).thenReturn(metrics);
        when(client.generateAlphaString(any())).thenReturn(new GenerateAlphaStringResponse("abc"));

        new Simulator(configuration).runSimulation();

        InOrder inOrder = inOrder(metricsFactory, metrics, client, metricsReporter);

        inOrder.verify(metricsFactory).newMetrics();
        inOrder.verify(metrics).setName(anyString());
        inOrder.verify(metrics).setLength(anyInt());
        inOrder.verify(metrics).setStart(any(Instant.class));
        inOrder.verify(client).generateAlphaString(any(GenerateAlphaStringRequest.class));
        inOrder.verify(metrics).close();
        inOrder.verify(metricsReporter).generateReport();
    }

}
