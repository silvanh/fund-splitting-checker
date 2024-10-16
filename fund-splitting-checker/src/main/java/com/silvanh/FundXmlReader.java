package com.silvanh;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.silvanh.xmlModels.FundModel;
import com.silvanh.xmlModels.FundsModel;
import com.silvanh.xmlModels.PositionModel;

public class FundXmlReader {

    private static final FundXmlReader INSTANCE = new FundXmlReader();

    private FundXmlReader() {
    }

    public static FundXmlReader getInstance() {
        return INSTANCE;
    }

    /**
     * Loads the XML file specified by the given {@link XmlFiles} enum and converts it to a list of lists of percentages.
     * 
     * <p>This method reads an XML file that conforms to the expected structure defined by the {@link FundsModel},
     * extracting percentage values from each fund and returning them as a list of lists. Each inner list represents
     * the percentages for a specific fund.</p>
     * 
     * @param xmlFile the type of XML to load, which specifies the path to the file (valid or invalid).
     *                This should not be {@code null}.
     * @return a {@code List<List<Double>>} containing lists of percentages loaded from the XML file.
     *         If parsing of the file fails for any reason (e.g., IO error, parsing error), {@code null} is returned.
     * 
     * @throws IllegalArgumentException if the XML file path does not exist or is not a valid file.
     */
    public Map<String, List<BigDecimal>> loadXml(XmlFiles xmlFile)  {

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(xmlFile.getRelativePath())) {
            if (inputStream == null) {
                throw new IOException("XML file not found: " + xmlFile.getRelativePath());
            }

            XmlMapper xmlMapper = new XmlMapper();
            FundsModel funds = xmlMapper.readValue(inputStream, FundsModel.class);
            
            Map<String, List<BigDecimal>> allPercentages = new HashMap<>();

            for (FundModel fund : CollectionUtils.emptyIfNull(funds.getFundList())) {
                List<BigDecimal> percentages = new ArrayList<>();
                for (PositionModel position : CollectionUtils.emptyIfNull(fund.getPositionList())) {
                    percentages.add(position.getPercentage());
                }
                allPercentages.put(fund.getIsin(), percentages);
            }

            return allPercentages;
        } catch (IOException e) {
            System.err.println("Error loading XML file: " + e.getMessage());
            return null;
        }
    }
}
