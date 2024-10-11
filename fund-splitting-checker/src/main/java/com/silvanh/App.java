package com.silvanh;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * The {@code App} class serves as the entry point for the Fund Splitting Checker application.
 * It reads fund percentage data from valid and invalid XML files and checks whether the
 * percentages for each fund add up to 100% within a specified tolerance.
 *
 * <p>This class utilizes the {@link FundXmlReader} to load fund data and 
 * {@link PercentageChecker} to validate the percentage totals.</p>
 *
 * <p>If a list of percentages is expected to be valid but does not sum to 100%, an error message
 * is logged indicating the fund's ISIN. Conversely, if a list of percentages 
 * is expected to be invalid but does sum to 100%, an error message is also logged, highlighting
 * the unexpected validation.</p>
 */
public class App {
    private static final BigDecimal TOLERANCE = new BigDecimal("0.01");

    public static void main(String[] args) {
        FundXmlReader fundXmlReader = FundXmlReader.getInstance();
        Map<String, List<BigDecimal>> validPercentages = fundXmlReader.loadXml(XmlFiles.VALID_XML);
        Map<String, List<BigDecimal>> invalidPercentages = fundXmlReader.loadXml(XmlFiles.INVALID_XML);

        if (validPercentages != null && validPercentages.entrySet() != null) {
            for (Entry<String, List<BigDecimal>> position : validPercentages.entrySet()) {
                if (!PercentageChecker.checkIfPercentagesEquals100(position.getValue(), TOLERANCE)) {
                    System.err.println("fund positions from isin " + position.getKey()
                                    + " should add up to 100% but fail within the given Tolerance of +/- "
                                    + TOLERANCE.scaleByPowerOfTen(2) + "%");
                }
            }
        }


        if (invalidPercentages != null && invalidPercentages.entrySet() != null) {
            for (Entry<String, List<BigDecimal>> position : invalidPercentages.entrySet()) {
                if (PercentageChecker.checkIfPercentagesEquals100(position.getValue(), TOLERANCE)) {
                    System.err.println("fund positions from isin " + position.getKey()
                            + " should NOT add up to 100% but was correct within the given Tolerance of +/- "
                            + TOLERANCE.scaleByPowerOfTen(2) + "%");
                }
            }
        }
    }
}
