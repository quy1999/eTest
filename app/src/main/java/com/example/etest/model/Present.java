package com.example.etest.model;

import java.io.Serializable;

public class Present implements Serializable {

    private String NameVN;
    private String NameEnglish;

    public Present(String NameVN,String NameEnglish){
        this.NameVN=NameVN;
        this.NameEnglish=NameEnglish;

    }

    public Present(String nameVN) {
        NameVN = nameVN;
    }

    public String getNameVN() {
        return NameVN;
    }

    public void setNameVN(String nameVN) {
        NameVN = nameVN;
    }

    public String getNameEnglish() {
        return NameEnglish;
    }

    public void setNameEnglish(String nameEnglish) {
        NameEnglish = nameEnglish;
    }
}


