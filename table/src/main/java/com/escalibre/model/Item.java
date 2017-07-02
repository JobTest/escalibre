package com.escalibre.model;


import com.escalibre.util.BasicUtil;

public class Item {

    private String word;
    private String id;

    public Item(){
    }
    
    public Item(String word){
        this.word = word;
        id = BasicUtil.getUniqueId();
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
        Item item = (Item) o;
        return word.equals(item.word)
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
