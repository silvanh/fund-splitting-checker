package com.silvanh;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class FundXmlReaderTest {

    @Test
    public void ifPassingValidXmlFileIntoXmlReaderThenShouldReturnCorrectValues() {
        FundXmlReader xmlReader = FundXmlReader.getInstance();
        List<List<BigDecimal>> validPercentages = xmlReader.loadXml(XmlFiles.VALID_XML);

        List<BigDecimal> expectedPercentages1 = createBigDecimalList(Arrays.asList(0.2, 0.3, 0.1, 0.41));
        List<BigDecimal> expectedPercentages2 = createBigDecimalList(Arrays.asList(0.2, 0.3, 0.1, 0.4));
        List<BigDecimal> expectedPercentages3 = createBigDecimalList(Arrays.asList(0.2, 0.3, 0.1, 0.39));
        List<List<BigDecimal>> allExpectedPercentages = Arrays.asList(expectedPercentages1, expectedPercentages2, expectedPercentages3);
        assertEquals(allExpectedPercentages, validPercentages); 
    }

    @Test
    public void ifPassingInvalidXmlFileIntoXmlReaderThenShouldReturnCorrectValues() {
        FundXmlReader xmlReader = FundXmlReader.getInstance();
        List<List<BigDecimal>> validPercentages = xmlReader.loadXml(XmlFiles.INVALID_XML);

        List<BigDecimal> expectedPercentages1 = createBigDecimalList(Arrays.asList(0.2, 0.3, 0.1, 0.4));
        List<BigDecimal> expectedPercentages2 = createBigDecimalList(Arrays.asList(0.2, 0.2, 0.1, 0.512));
        List<BigDecimal> expectedPercentages3 = createBigDecimalList(Arrays.asList(0.185, 0.3, 0.1, 0.4));
        List<List<BigDecimal>> allExpectedPercentages = Arrays.asList(expectedPercentages1, expectedPercentages2, expectedPercentages3);
        assertEquals(allExpectedPercentages, validPercentages); 
    }

    private List<BigDecimal> createBigDecimalList(List<Double> values) {
        return values.stream().map(BigDecimal::valueOf).collect(Collectors.toList());
    }

}
