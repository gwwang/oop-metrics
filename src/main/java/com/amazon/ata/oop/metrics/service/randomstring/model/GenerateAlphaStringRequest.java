package com.amazon.ata.oop.metrics.service.randomstring.model;

import java.util.Objects;

public class GenerateAlphaStringRequest {

    private final int length;

    public GenerateAlphaStringRequest(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenerateAlphaStringRequest that = (GenerateAlphaStringRequest) o;
        return this.length == that.length;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.length);
    }

    @Override
    public String toString() {
        return "GenerateAlphaStringRequest{length=" + length + '}';
    }
}
