package com.escalibre;


import com.escalibre.model.Item;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

public class AlgorithmJ7 extends Algorithm {

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

    public List<Item> leftJoin2(List<Item> tblA, List<Item> tblB){
        if (tblA==null)
            return null;
        else if (tblB==null)
            return tblA;

        List<Item> left = new ArrayList<>();
        for (Item a : tblA){
            for (Item b : tblB){
                if (!a.equals(b))
                    left.add(a);
            }
        }
        return left;
    }

    public List<Item> rightJoin2(List<Item> tblA, List<Item> tblB){
        if (tblB==null)
            return null;
        else if (tblA==null)
            return tblB;

        List<Item> right = new ArrayList<>();
        for (Item b : tblB){
            for (Item a : tblA){
                if (!b.equals(a))
                    right.add(b);
            }
        }
        return right;
    }
}
