package com.amazon.ata.oop.metrics.service.randomstring;

import com.amazon.ata.oop.metrics.service.randomstring.model.GenerateAlphaStringRequest;
import com.amazon.ata.oop.metrics.service.randomstring.model.GenerateAlphaStringResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RandomStringServiceTest {

    private static final long RANDOM_SEED = 0L;
    private RandomStringService service;
    private Random randomChar;
    private Random randomDelay;

    @Before
    public void setup() {
        this.randomChar = new Random(RANDOM_SEED);
        this.randomDelay = new Random(RANDOM_SEED);
        this.service = new RandomStringService(randomChar, randomDelay);
    }

    @Test
    public void generatesStringOfProperLength() {
        GenerateAlphaStringRequest request = new GenerateAlphaStringRequest(10);
        GenerateAlphaStringResponse response = service.generateAlphaString(request);

        assertNotNull(response);
        assertEquals(request.getLength(), response.getRandomAlphaString().length());
    }

    @Test
    public void generatesExpectedString() {
        GenerateAlphaStringRequest request = new GenerateAlphaStringRequest(15);
        GenerateAlphaStringResponse response = service.generateAlphaString(request);

        String expectedString = generateExpectedString(request.getLength());
        assertEquals(expectedString, response.getRandomAlphaString());

    }

    private String generateExpectedString(int length) {

        //It is possible to reproduce a randomly generated number as
        //long as it is using the same seed.
        //
        //For more details, look into {@link java.util.Random}

        Random random = new Random(RANDOM_SEED);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(RandomStringService.CHARS[random.nextInt(RandomStringService.CHARS.length)]);
        }
        return sb.toString();
    }

}
