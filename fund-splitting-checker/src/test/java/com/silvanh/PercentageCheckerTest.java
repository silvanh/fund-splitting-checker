package com.silvanh;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class PercentageCheckerTest {

    @Test
    public void ifPercentagesSumUpTo1AndToleranceZeroThenExpectTrue() {
        boolean result = PercentageChecker
            .checkIfPercentagesEquals100(Arrays.asList(0.5, 0.5), 0.0);
        assertTrue(result); 
    }

    @Test
    public void ifPercentagesSumUpTo1ButHaveOnlyOneElementAndToleranceZeroThenExpectTrue() {
        boolean result = PercentageChecker
            .checkIfPercentagesEquals100(Arrays.asList(1.0), 0.0);
        assertTrue(result); 
    }

    @Test
    public void ifPercentagesSumUpWithinToleranceAndToleranceIsNotZeroThenExpectTrue() {
        boolean result = PercentageChecker
            .checkIfPercentagesEquals100(Arrays.asList(0.1, 0.4, 0.1, 0.35), 0.1);
        assertTrue(result); 
    }

    @Test
    public void ifPercentagesSumUpWithinExactlyToToleranceAndToleranceIsNotZeroThenExpectTrue() {
        boolean result = PercentageChecker
            .checkIfPercentagesEquals100(Arrays.asList(0.1, 0.4, 0.1, 0.3), 0.1);
        assertTrue(result); 
    }

    @Test
    public void ifPercentagesSumUpNotTo1AndToleranceZeroThenExpectFalse() {
        boolean result = PercentageChecker
            .checkIfPercentagesEquals100(Arrays.asList(0.5, 0.4), 0.0);
        assertFalse(result); 
    }

    @Test
    public void ifPercentagesAreNullButToleranceIsOkExpectIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PercentageChecker.checkIfPercentagesEquals100(null, 0.0);
        });
    }

    @Test
    public void ifPercentagesHaveNegativeNumberButToleranceIsOkExpectIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PercentageChecker.checkIfPercentagesEquals100(Arrays.asList(0.5, -0.4), 0.0);
        });
    }

    @Test
    public void ifPercentagesHaveAllNegativeNumberButToleranceIsOkExpectIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PercentageChecker.checkIfPercentagesEquals100(Arrays.asList(-0.5, -0.4), 0.0);
        });
    }

    @Test
    public void ifPercentagesIsOnlyOneNegativeNumberButToleranceIsOkExpectIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PercentageChecker.checkIfPercentagesEquals100(Arrays.asList(-0.5), 0.0);
        });
    }

    @Test
    public void ifPercentagesAreCorrectButToleranceIsNegativeNumberExpectIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PercentageChecker.checkIfPercentagesEquals100(Arrays.asList(0.5, 0.4, 0.1), -0.1d);
        });
    }
}
