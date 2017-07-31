package com.amazon.ata.oop.metrics.service.randomstring.model;

import java.util.Objects;

public class GenerateAlphaStringResponse {

    private final String randomAlphaString;

    public GenerateAlphaStringResponse(String randomAlphaString) {
        this.randomAlphaString = randomAlphaString;
    }

    public String getRandomAlphaString() {
        return randomAlphaString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenerateAlphaStringResponse that = (GenerateAlphaStringResponse) o;
        return this.randomAlphaString.equals(that.randomAlphaString);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(randomAlphaString);
    }

    @Override
    public String toString() {
        return "GenerateAlphaStringResponse{randomAlphaString='" + randomAlphaString + "\'}";
    }
}
