package com.silvanh;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FundXmlReaderTest {

    @Test
    public void ifPercentagesSumUpTo1AndToleranceZeroThenExpectTrue() {
        FundXmlReader xmlReader = FundXmlReader.getInstance();
        List<List<Double>> validPercentages = xmlReader.loadXml(XmlFiles.VALID_XML);

        List<Double> expectedPercentages1 = Arrays.asList(0.2, 0.3, 0.1, 0.41);
        List<Double> expectedPercentages2 = Arrays.asList(0.2, 0.3, 0.1, 0.4);
        List<Double> expectedPercentages3 = Arrays.asList(0.2, 0.3, 0.1, 0.39);
        List<List<Double>> allExpectedPercentages = Arrays.asList(expectedPercentages1, expectedPercentages2, expectedPercentages3);
        assertEquals(allExpectedPercentages, validPercentages); 
    }

}
