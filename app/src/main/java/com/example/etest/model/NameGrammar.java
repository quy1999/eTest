package com.example.etest.model;

import java.io.Serializable;

public class NameGrammar implements Serializable {

    private String NameGrammar;

    public NameGrammar(String nameGrammar) {
        NameGrammar = nameGrammar;
    }

    public String getNameGrammar() {
        return NameGrammar;
    }

    public void setNameGrammar(String nameGrammar) {
        NameGrammar = nameGrammar;
    }
}
