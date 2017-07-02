package com.escalibre;


import com.escalibre.model.Item;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class SqlAlgorithmJ8 extends Algorithm {

    /**
     * Используются stream из Java-8
     * *****************************
     * Обладает низкой производительностью.
     * Такой способ более безопасный для работы с циклами.
     */

    public List<Item> leftJoin(List<Item> tblA, List<Item> tblB){
        if (tblA==null)
            return null;
        else if (tblB==null)
            return tblA;
        return tblA.parallelStream()
                .filter(i -> !tblB.contains(i))
                .collect(Collectors.toList());
    }

    public List<Item> rightJoin(List<Item> tblA, List<Item> tblB){
        if (tblB==null)
            return null;
        else if (tblA==null)
            return tblB;
        return tblB.parallelStream()
                .filter(i -> !tblA.contains(i))
                .collect(Collectors.toList());
    }


    /**
     * Альтернативный вариант в стиле Java-8
     * *************************************
     * (Обладает низкой производительностью)
     */

    public List<Item> leftJoinAlternative(List<Item> tblA, List<Item> tblB){
        if (tblA==null)
            return null;
        else if (tblB==null)
            return tblA;

        return tblA.parallelStream()
                .filter(a -> (tblB.parallelStream()
                        .noneMatch(b -> tblA.contains(b))))
                .collect(Collectors.toList());
    }

    public List<Item> rightJoinAlternative(List<Item> tblA, List<Item> tblB){
        if (tblB==null)
            return null;
        else if (tblA==null)
            return tblB;

        return tblB.parallelStream()
                .filter(b -> (tblA.parallelStream()
                        .noneMatch(a -> tblB.contains(a))))
                .collect(Collectors.toList());
    }


    /*
     * Еще один альтернативный вариант
     * *******************************
     * Позволяет одновременно получать и конвертировтаь результат...
     */

    public List<String> leftJoinToIds(List<Item> tblA, List<Item> tblB){
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
    }

    public List<String> rightJoinToIds(List<Item> tblA, List<Item> tblB){
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
    }
}
