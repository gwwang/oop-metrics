package com.amazon.ata.oop.metrics.reporting;

/**
 * This is an example MetricsReporter that does the following:
 * - record total number of metrics received
 * - record the max length encountered
 * - record the min length encountered
 */
public class ExampleMetricsReporter implements MetricsReporter {

    private int count = 0;
    private int maxLength = Integer.MIN_VALUE;
    private int minLength = Integer.MAX_VALUE;

    /**
     * For each Metrics object, quickly update internal state.
     * @param metrics
     */
    @Override
    public void accept(Metrics metrics) {
        this.count++;
        int length = metrics.getLength();
        this.maxLength = Math.max(this.maxLength, length);
        this.minLength = Math.min(this.minLength, length);
    }

    @Override
    public void generateReport() {
        String report = "Metric count\t%s\nMax length\t%s\nMin Length\t%s";
        System.out.println(String.format(report, count, maxLength, minLength));
    }

    public int getCount() {
        return count;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getMinLength() {
        return minLength;
    }
}
