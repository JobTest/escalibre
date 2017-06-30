package com.escalibre;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolveAlgorithm extends HashMap<Word, String> {

    public SolveAlgorithm(final Map<Word, String> tblA, final Map<Word, String> tblB){
        putAll(tblA);
        putAll(tblB);
    }

    public List<String> getByInclude(final Map<Word,String> tbl){
        keySet().removeAll(tbl.keySet());

        return new ArrayList<>(values());
    }

    public List<String> getByExclude(final Map<Word,String> tbl){
        keySet().retainAll(tbl.keySet());

        return new ArrayList<>(values());
    }
}
