package com.silvanh;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public final class FundXmlReader {

    private static final FundXmlReader INSTANCE = new FundXmlReader();

    private FundXmlReader() {
    }

    public static FundXmlReader getInstance() {
        return INSTANCE;
    }

    /**
     * Loads the XML file based on the provided XmlType and converts it to a list of percentages.
     * 
     * @param xmlType the type of XML to load (valid or invalid)
     * @return a list of percentages loaded from the XML file
     * @throws IOException if an error occurs while reading the XML file
     */
    public List<Double> loadXml(XmlFiles xmlFile) throws IOException {
        Path xmlPath = Path.of(xmlFile.getRelativePath());

        // Check if the file exists
        if (!Files.exists(xmlPath)) {
            throw new IOException("XML file not found: " + xmlPath);
        }

        try (InputStream inputStream = Files.newInputStream(xmlPath)) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);

            // Example of extracting percentages from the XML
            NodeList percentageNodes = document.getElementsByTagName("percentage");
            List<Double> percentages = new ArrayList<>();

            for (int i = 0; i < percentageNodes.getLength(); i++) {
                String percentageValue = percentageNodes.item(i).getTextContent();
                percentages.add(Double.parseDouble(percentageValue));
            }

            return percentages;
        } catch (Exception e) {
            throw new IOException("Error parsing XML file: " + e.getMessage(), e);
        }
    }
}
