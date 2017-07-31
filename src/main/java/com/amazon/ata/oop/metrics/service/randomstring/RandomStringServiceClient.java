package com.amazon.ata.oop.metrics.service.randomstring;

import com.amazon.ata.oop.metrics.service.randomstring.model.GenerateAlphaStringRequest;
import com.amazon.ata.oop.metrics.service.randomstring.model.GenerateAlphaStringResponse;

public class RandomStringServiceClient {

    private final RandomStringService service;

    public RandomStringServiceClient(RandomStringService service) {
        this.service = service;
    }

    public GenerateAlphaStringResponse generateAlphaString(GenerateAlphaStringRequest request) {
        return service.generateAlphaString(request);
    }

}
