package com.escalibre;


import com.escalibre.model.Item;
import java.util.*;
import java.util.stream.Collectors;

public class AlgorithmWithJava7 {

    public List<Item> leftJoin(List<Item> tblA, List<Item> tblB){
        if (tblA==null)
            return null;
        else if (tblB==null)
            return tblA;

        List<Item> left = (ArrayList) ((ArrayList) tblA).clone();
        return left.removeAll(tblB)
                ? left
                : null;
    }

    public List<Item> rightJoin(List<Item> tblA, List<Item> tblB){
        if (tblB==null)
            return null;
        else if (tblA==null)
            return tblB;

        List<Item> right = (ArrayList) ((ArrayList) tblB).clone();
        return right.removeAll(tblA)
                ? right
                : null;
    }

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
