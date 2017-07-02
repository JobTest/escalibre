package com.escalibre.model;


import com.escalibre.util.IdUniqueUtil;

public class Tbl {

    private String word;
    private String id;

    public Tbl(){
    }
    
    public Tbl(String word){
        this.word = word;
        id = IdUniqueUtil.getUniqueId();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        Tbl tbl = (Tbl) o;
        return word.equals(tbl.word)
                ? true
                : false;
    }

    @Override
    public String toString() {
        return "{" +
                "'" + word + '\'' +
                "='" + id + '\'' +
                '}';
    }
}
