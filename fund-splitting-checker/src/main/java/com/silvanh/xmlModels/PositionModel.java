package com.silvanh.xmlModels;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class PositionModel {

    @JacksonXmlProperty(localName = "percentage")
    private Double percentage;

    @JacksonXmlProperty(isAttribute = true)
    private String id; 

    public Double getPercentage() {
        return percentage;
    }

    public String getId() {
        return id;
    }

}
