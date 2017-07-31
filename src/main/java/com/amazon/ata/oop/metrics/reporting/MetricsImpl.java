package com.amazon.ata.oop.metrics.reporting;

import java.time.Duration;
import java.time.Instant;

public final class MetricsImpl implements Metrics {

    private final MetricsReporter metricsReporter;
    private boolean notClosed = true;

    private String name;
    private int length;
    private Instant start;
    private Instant end;

    // We want this constructor to be package protected to enforce MetricsFactory usage
    MetricsImpl(MetricsReporter metricsReporter) {
        this.metricsReporter = metricsReporter;
    }

    @Override
    public void setName(String name) {
        if (notClosed) {
            this.name = name;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setLength(int length) {
        if (notClosed) {
            this.length = length;
        }

    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void setStart(Instant instant) {
        if (notClosed) {
            this.start = instant;
        }
    }

    @Override
    public Instant getStart() {
        return start;
    }

    @Override
    public void setEnd(Instant instant) {
        if (notClosed) {
            this.end = instant;
        }
    }

    @Override
    public Instant getEnd() {
        return end;
    }

    @Override
    public Duration getDuration() {
        return Duration.between(start, end);
    }

    @Override
    public void close() {
        this.notClosed = false;
        metricsReporter.accept(this);
    }
}
