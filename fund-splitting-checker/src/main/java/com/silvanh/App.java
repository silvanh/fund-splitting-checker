package com.silvanh;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;


/**
 * Hello world!
 *
 */
public class App {
    private static final BigDecimal TOLERANCE = new BigDecimal("0.01");
    public static void main(String[] args) {
        FundXmlReader fundXmlReader = FundXmlReader.getInstance();
        List<List<BigDecimal>> validPercentages = fundXmlReader.loadXml(XmlFiles.VALID_XML);
        List<List<BigDecimal>> invalidPercentages = fundXmlReader.loadXml(XmlFiles.INVALID_XML);

        for (List<BigDecimal> position: CollectionUtils.emptyIfNull(validPercentages)) {
            System.out.println(position);
            if (!PercentageChecker.checkIfPercentagesEquals100(position, TOLERANCE)) {
                System.err.println("fund positions do not add up to 100%");
            }
        }

        for (List<BigDecimal> position: CollectionUtils.emptyIfNull(invalidPercentages)) {
            System.out.println(position);
            if (PercentageChecker.checkIfPercentagesEquals100(position, TOLERANCE)) {
                throw new RuntimeException("fund positions should not add up to 100%");
            }
        }
    }

}
