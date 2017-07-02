package com.escalibre;


import com.escalibre.model.Item;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class AlgorithmJ8 extends Algorithm {

    public List<String> leftJoin(List<Item> tblA, List<Item> tblB){
        if (tblA==null)
            return null;
        else if (tblB==null)
            return tblA.stream()
                    .map(i -> i.getId())
                    .collect(Collectors.toList());
        return tblA.parallelStream()
                .filter(i -> !tblB.contains(i))
                .map(i -> i.getId())
                .collect(Collectors.toList());
//        return tblA.parallelStream()
//                .filter(a -> (tblB.parallelStream()
//                        .noneMatch(b -> tblA.contains(b))))
//                .collect(Collectors.toList());
    }

    public List<String> rightJoin(List<Item> tblA, List<Item> tblB){
        if (tblB==null)
            return null;
        else if (tblA==null)
            return tblB.stream()
                    .map(i -> i.getId())
                    .collect(Collectors.toList());
        return tblB.parallelStream()
                .filter(i -> !tblA.contains(i))
                .map(i -> i.getId())
                .collect(Collectors.toList());
//        return tblB.parallelStream()
//                .filter(b -> (tblA.parallelStream()
//                        .noneMatch(a -> tblB.contains(a))))
//                .collect(Collectors.toList());
    }
}
