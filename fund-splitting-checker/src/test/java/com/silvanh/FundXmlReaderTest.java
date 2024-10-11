package com.silvanh;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

public class FundXmlReaderTest {

    @Test
    public void ifPassingValidXmlFileIntoXmlReaderThenShouldReturnCorrectValues() {
        // given
        FundXmlReader xmlReader = FundXmlReader.getInstance();

        List<BigDecimal> expectedPercentages1 = createBigDecimalList(Arrays.asList(0.2, 0.3, 0.1, 0.41));
        List<BigDecimal> expectedPercentages2 = createBigDecimalList(Arrays.asList(0.2, 0.3, 0.1, 0.4));
        List<BigDecimal> expectedPercentages3 = createBigDecimalList(Arrays.asList(0.2, 0.3, 0.1, 0.39));
        Map<String, List<BigDecimal>> allExpectedPercentages = new HashMap<>();
        allExpectedPercentages.put("132523652", expectedPercentages1);
        allExpectedPercentages.put("777432112", expectedPercentages2);
        allExpectedPercentages.put("457432475", expectedPercentages3);

        // when
        Map<String, List<BigDecimal>> validPercentages = xmlReader.loadXml(XmlFiles.VALID_XML);

        // then
        assertEquals(allExpectedPercentages, validPercentages);
    }

    @Test
    public void ifPassingInvalidXmlFileIntoXmlReaderThenShouldReturnCorrectValues() {
        // given
        FundXmlReader xmlReader = FundXmlReader.getInstance();

        List<BigDecimal> expectedPercentages1 = createBigDecimalList(Arrays.asList(0.2, 0.3, 0.1, 0.4));
        List<BigDecimal> expectedPercentages2 = createBigDecimalList(Arrays.asList(0.2, 0.2, 0.1, 0.512));
        List<BigDecimal> expectedPercentages3 = createBigDecimalList(Arrays.asList(0.185, 0.3, 0.1, 0.4));
        Map<String, List<BigDecimal>> allExpectedPercentages = new HashMap<>();
        allExpectedPercentages.put("132523652", expectedPercentages1);
        allExpectedPercentages.put("777432112", expectedPercentages2);
        allExpectedPercentages.put("457432475", expectedPercentages3);

        // when 
        Map<String, List<BigDecimal>> validPercentages = xmlReader.loadXml(XmlFiles.INVALID_XML);
        
        // then
        assertEquals(allExpectedPercentages, validPercentages); 
    }

    private List<BigDecimal> createBigDecimalList(List<Double> values) {
        return values.stream().map(BigDecimal::valueOf).collect(Collectors.toList());
    }

}
