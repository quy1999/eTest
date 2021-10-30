package com.example.etest.model;

import java.io.Serializable;

public class TypeWorks implements Serializable {

    private  String NameVNTypes;
    private String NameENTypes;

    public TypeWorks(String NameVNTypes,String NameENTypes) {
        this.NameVNTypes = NameVNTypes;
        this.NameENTypes=NameENTypes;
    }

    public String getNameVNTypes() {
        return NameVNTypes;
    }

    public void setNameVNTypes(String nameVNTypes) {
        NameVNTypes = nameVNTypes;
    }

    public String getNameENTypes() {
        return NameENTypes;
    }

    public void setNameENTypes(String nameENTypes) {
        NameENTypes = nameENTypes;
    }
}
