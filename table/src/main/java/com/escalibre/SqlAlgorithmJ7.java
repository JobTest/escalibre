package com.escalibre;


import com.escalibre.model.Tbl;

import java.util.*;

public class SqlAlgorithmJ7 extends Algorithm {

    /**
     * Класический способ с вложенным циклом
     * *************************************
     * Эффективено использует память.
     * Обладает низкой производительностью. Реализация ложиться на разработчика.
     */

    public List<Tbl> leftJoinCustom(List<Tbl> tblA, List<Tbl> tblB){
        if (tblA==null)
            return null;
        else if (tblB==null)
            return tblA;

        List<Tbl> left = new ArrayList<>();
        for (Tbl a : tblA){
            for (Tbl b : tblB){
                if (!a.equals(b))
                    left.add(a);
            }
        }
        return left;
    }

    public List<Tbl> rightJoinCustom(List<Tbl> tblA, List<Tbl> tblB){
        if (tblB==null)
            return null;
        else if (tblA==null)
            return tblB;

        List<Tbl> right = new ArrayList<>();
        for (Tbl b : tblB){
            for (Tbl a : tblA){
                if (!b.equals(a))
                    right.add(b);
            }
        }
        return right;
    }

    /**
     * Используются встроенные методы коллекции 'removeAll'
     * ****************************************************
     * Реализован с помощью встроенных методов коллекции. Обладает средней производительностью.
     * В период выполнения память сильно раздувается. (Чтобы погасить этот факт можно клонировать копию списка)
     */

    public List<Tbl> leftJoin(List<Tbl> tblA, List<Tbl> tblB){
        if (tblA==null)
            return null;
        else if (tblB==null)
            return tblA;

        List<Tbl> left = (ArrayList) ((ArrayList) tblA).clone();
        return left.removeAll(tblB)
                ? left
                : null;
    }

    public List<Tbl> rightJoin(List<Tbl> tblA, List<Tbl> tblB){
        if (tblB==null)
            return null;
        else if (tblA==null)
            return tblB;

        List<Tbl> right = (ArrayList) ((ArrayList) tblB).clone();
        return right.removeAll(tblA)
                ? right
                : null;
    }
}
