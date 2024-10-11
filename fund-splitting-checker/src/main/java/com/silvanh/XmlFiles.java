package com.silvanh;

public enum XmlFiles {
    VALID_XML("input_valid.xml"),
    INVALID_XML("input_valid.xml");

    private final String relativePath;

    XmlFiles(String relativePath) {
        this.relativePath = relativePath;
    }

    public String getRelativePath() {
        return this.relativePath;
    }
}
