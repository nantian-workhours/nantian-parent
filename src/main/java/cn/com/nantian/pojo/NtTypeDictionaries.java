package cn.com.nantian.pojo;

import java.io.Serializable;

public class NtTypeDictionaries implements Serializable{
    private String typeCode;
    private String typeName;

    public NtTypeDictionaries( ) {
    }

    public NtTypeDictionaries(String typeCode, String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }
}