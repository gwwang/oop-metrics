package com.amazon.ata.oop.metrics.service.randomstring;

import com.amazon.ata.oop.metrics.service.randomstring.model.GenerateAlphaStringRequest;
import com.amazon.ata.oop.metrics.service.randomstring.model.GenerateAlphaStringResponse;

import java.util.Random;

public class RandomStringService {

    protected static final int MAX_DELAY = 1000; // max delay of 1 second
    protected static final char[] CHARS = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                                            'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u',
                                            'v', 'w', 'x', 'y', 'z'};
    private final Random randomChar;
    private final Random randomDelay;

    public RandomStringService(Random randomChar, Random randomDelay) {
        this.randomChar = randomChar;
        this.randomDelay = randomDelay;
    }

    public GenerateAlphaStringResponse generateAlphaString(GenerateAlphaStringRequest request) {
        String str = generateAfterRandomDelay(request.getLength());
        return new GenerateAlphaStringResponse(str);
    }

    private String generateAfterRandomDelay(int length) {
        delay();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARS[randomChar.nextInt(CHARS.length)]);
        }
        return sb.toString();
    }

    /**
     * This method is used to emulate latency
     */
    private void delay() {
        long delayMillis = randomDelay.nextInt(MAX_DELAY);
        try {
            Thread.sleep(delayMillis);
        } catch (InterruptedException e) {
            // this shouldn't happen here as this simulation is a single threaded application.
        }
    }

}
