package com.escalibre;


import com.escalibre.model.Item;

import java.util.List;
import java.util.stream.Collectors;

public class Algorithm {

    public List<String> toIDs(List<Item> items){
        return items.stream()
                .map(i -> i.getId())
                .collect(Collectors.toList());
    }

    public List<String> toWORDs(List<Item> items){
        return items.stream()
                .map(i -> i.getWord())
                .collect(Collectors.toList());
    }

}
