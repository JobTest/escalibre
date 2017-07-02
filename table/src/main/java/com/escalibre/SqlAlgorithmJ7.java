package com.escalibre;


import com.escalibre.model.Item;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

public class SqlAlgorithmJ7 extends Algorithm {

    /**
     * Класический способ с вложенным циклом
     * *************************************
     * Эффективено использует память. Высокая скорость.
     * Реализация ложиться на разработчика.
     */

    public List<Item> leftJoinCustom(List<Item> tblA, List<Item> tblB){
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

    public List<Item> rightJoinCustom(List<Item> tblA, List<Item> tblB){
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

    /**
     * Используются встроенные методы коллекции 'removeAll'
     * ****************************************************
     * Имеет высокую скорость.
     * Реализован с помощью встроенных методов коллекции.
     * В период выполнения память сильно раздувается. (Чтобы погасить этот факт можно клонировать копию списка)
     */

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
}
