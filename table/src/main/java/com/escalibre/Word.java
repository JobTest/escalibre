package com.escalibre;


public class Word {

    private String val;

    public Word(String val){
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    @Override public boolean equals(Object that) {
        Word word = (Word) that;
        return val.equals(word.getVal())
                ? true
                : false;
    }

    @Override public int hashCode() {
        return val != null
                ? val.hashCode()
                : 0;
    }

    @Override public String toString() {
        return "'" + val + "'";
    }
}
