package com.silvanh;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PercentageCheckerTest {

    @Test
    public void ifPercentagesSumUpTo1AndToleranceZeroThenExpectTrue() {
        List<Double> percentages = Arrays.asList(0.5, 0.5);
        boolean result = PercentageChecker.checkIfPercentagesEquals100(percentages, 0d);
        assertTrue(result); 
    }
}
