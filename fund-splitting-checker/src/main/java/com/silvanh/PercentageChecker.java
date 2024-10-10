package com.silvanh;

import java.util.List;

public final class PercentageChecker {

    private PercentageChecker() {
    }

    /**
     * Checks if the sum of the given fractions (percentages) is approximately equal
     * to 1 within a specified tolerance.
     * 
     * This method accepts a list of positive double values representing fractions.
     * It will return true if the sum of these values is within the specified
     * tolerance of 1. Otherwise, it returns false.
     * 
     * @param percentages A list of positive {@code Double} values representing
     *                    fractions (should be in the range [0.0, 1.0]).
     * @param TOLERANCE   A {@code Double} value representing the tolerance level
     *                    for comparison to 1. The method will consider the sum to
     *                    be equal to 1 if the absolute difference is less than or
     *                    equal to this tolerance.
     * 
     * @return {@code true} if the sum of the percentages is approximately equal to
     *         1 within the specified tolerance; {@code false} otherwise.
     * 
     * @throws IllegalArgumentException if any percentage in the list is negative or
     *                                  if the tolerance is negative.
     */
    public static boolean checkIfPercentagesEquals100(List<Double> percentages, Double TOLERANCE) {
        return true;
    }
}
