package com.amazon.ata.oop.metrics.service.randomstring;

import com.amazon.ata.oop.metrics.service.randomstring.model.GenerateAlphaStringRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class RandomStringServiceClientTest {

    @Mock
    private RandomStringService service;
    @InjectMocks
    private RandomStringServiceClient client;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void callsService() {
        GenerateAlphaStringRequest request = new GenerateAlphaStringRequest(10);
        client.generateAlphaString(request);
        verify(service).generateAlphaString(request);
    }

}
