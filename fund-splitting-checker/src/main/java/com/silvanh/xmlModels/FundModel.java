package com.silvanh.xmlModels;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class FundModel {

    @JacksonXmlProperty(localName = "position")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<PositionModel> positionList;

    @JacksonXmlProperty(isAttribute = true)
    private String isin;

    public List<PositionModel> getPositionList() {
        return positionList;
    }

    public String getIsin() {
        return isin;
    }

}
