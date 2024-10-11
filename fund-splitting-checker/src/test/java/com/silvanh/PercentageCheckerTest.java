package com.silvanh;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class PercentageCheckerTest {

    @Test
    public void ifPercentagesSumUpTo1AndToleranceZeroThenExpectTrue() {
        boolean result = PercentageChecker
            .checkIfPercentagesEquals100(createBigDecimalList(Arrays.asList(0.5, 0.5)), new  BigDecimal("0.0"));
        assertTrue(result); 
    }

    @Test
    public void ifPercentagesSumUpTo1ButHaveOnlyOneElementAndToleranceZeroThenExpectTrue() {
        boolean result = PercentageChecker
            .checkIfPercentagesEquals100(createBigDecimalList(Arrays.asList(1.0)), new  BigDecimal("0.0"));
        assertTrue(result); 
    }

    @Test
    public void ifPercentagesSumUpWithinLowerToleranceAndToleranceIsNotZeroThenExpectTrue() {
        boolean result = PercentageChecker
            .checkIfPercentagesEquals100(createBigDecimalList(Arrays.asList(0.1, 0.4, 0.1, 0.35)), new  BigDecimal("0.1"));
        assertTrue(result); 
    }

    @Test
    public void ifPercentagesSumUpWithinUpperToleranceAndToleranceIsNotZeroThenExpectTrue() {
        boolean result = PercentageChecker
            .checkIfPercentagesEquals100(createBigDecimalList(Arrays.asList(0.2, 0.4, 0.1, 0.35)), new  BigDecimal("0.1"));
        assertTrue(result); 
    }

    @Test
    public void ifPercentagesSumUpWithinExactlyToLowerToleranceAndToleranceIsNotZeroThenExpectTrue() {
        boolean result = PercentageChecker
            .checkIfPercentagesEquals100(createBigDecimalList(Arrays.asList(0.1, 0.4, 0.1, 0.3)), new  BigDecimal("0.1"));
        assertTrue(result); 
    }

    @Test
    public void ifPercentagesSumUpWithinExactlyToUpperToleranceAndToleranceIsNotZeroThenExpectTrue() {
        boolean result = PercentageChecker
            .checkIfPercentagesEquals100(createBigDecimalList(Arrays.asList(0.1, 0.4, 0.3, 0.3)), new  BigDecimal("0.1"));
        assertTrue(result); 
    }

    @Test
    public void ifPercentagesSumUpNotTo1AndToleranceZeroThenExpectFalse() {
        boolean result = PercentageChecker
            .checkIfPercentagesEquals100(createBigDecimalList(Arrays.asList(0.5, 0.4)), new  BigDecimal("0.0"));
        assertFalse(result); 
    }

    @Test
    public void ifPercentagesAreNullButToleranceIsOkExpectIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PercentageChecker.checkIfPercentagesEquals100(null, new  BigDecimal("0.0"));
        });
    }

    @Test
    public void ifPercentagesHaveNegativeNumberButToleranceIsOkExpectIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PercentageChecker.checkIfPercentagesEquals100(createBigDecimalList(Arrays.asList(0.5, -0.4)), new  BigDecimal("0.0"));
        });
    }

    @Test
    public void ifPercentagesHaveAllNegativeNumberButToleranceIsOkExpectIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PercentageChecker.checkIfPercentagesEquals100(createBigDecimalList(Arrays.asList(-0.5, -0.4)), new  BigDecimal("0.0"));
        });
    }

    @Test
    public void ifPercentagesIsOnlyOneNegativeNumberButToleranceIsOkExpectIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PercentageChecker.checkIfPercentagesEquals100(createBigDecimalList(Arrays.asList(-0.5)), new  BigDecimal("0.0"));
        });
    }

    @Test
    public void ifPercentagesAreCorrectButToleranceIsNegativeNumberExpectIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PercentageChecker.checkIfPercentagesEquals100(createBigDecimalList(Arrays.asList(0.5, 0.4, 0.1)), new  BigDecimal("-0.1d"));
        });
    }

    private List<BigDecimal> createBigDecimalList(List<Double> values) {
        return values.stream().map(BigDecimal::valueOf).collect(Collectors.toList());
    }
}
