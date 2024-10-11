package com.silvanh.xmlModels;


import java.math.BigDecimal;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class PositionModel {

    @JacksonXmlProperty(localName = "percentage")
    private BigDecimal percentage;

    @JacksonXmlProperty(isAttribute = true)
    private String id; 

    public BigDecimal getPercentage() {
        return percentage;
    }

    public String getId() {
        return id;
    }

}
