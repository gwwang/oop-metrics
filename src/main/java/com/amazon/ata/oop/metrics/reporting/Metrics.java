package com.amazon.ata.oop.metrics.reporting;

import java.time.Duration;
import java.time.Instant;

public interface Metrics {

    /**
     * Sets the name for this metric
     * @param name
     */
    void setName(String name);

    /**
     * Gets the name for this metric
     * @return String
     */
    String getName();

    /**
     * Sets the length for this metric
     * @param length
     */
    void setLength(int length);

    /**
     * Gets the length for this metric
     * @return int
     */
    int getLength();

    /**
     * Sets the start Instant
     * @param instant
     */
    void setStart(Instant instant);

    /**
     * Get the start Instant
     * @return Instant
     */
    Instant getStart();

    /**
     * Sets the end Instant
     * @param instant
     */
    void setEnd(Instant instant);

    /**
     * Gets the end Instant
     * @return Instant
     */
    Instant getEnd();

    /**
     * Gets the Duration of the metric.  The Duration should be calculated as the time elapsed between
     * the start Instant and end Instant.
     * @return Duration
     */
    Duration getDuration();

    /**
     * Indicate that the metric instance has all the necessary information and should be sent to a
     * MetricsReporter.
     */
    void close();

}
