package com.silvanh.xmlModels;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "funds")
public class FundsModel {

    @JacksonXmlProperty(localName = "fund")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<FundModel> fundList;

    public List<FundModel> getFundList() {
        return fundList;
    }
}
