package com.tourism.entity;

public class Type {
    private String typeName;

    public String getTypeName() {
        return typeName;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Type{" +
                "typeName='" + typeName + '\'' +
                '}';
    }
}
