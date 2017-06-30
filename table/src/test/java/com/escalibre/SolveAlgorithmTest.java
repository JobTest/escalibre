package com.escalibre;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class SolveAlgorithmTest {

    private SolveAlgorithm algorithm;

    private Map<Word, String> tblA, tblB;
    private List<String> tblC;

    @Before
    public void setUp() {
        tblA = new HashMap<>();
        tblB = new HashMap<>();
        init();
    }

    @Test
    public void testInit() {
        algorithm = new SolveAlgorithm(tblA, tblB);

        System.out.println(tblA);
        System.out.println(tblB);
        System.out.println(algorithm);
    }

    /**
     * Create and fill table 'C' containing: (ID).
     * By include a table-A or table-B and use match by 'WORD'
     */
    @Test
    public void testGetByInclude() {
        algorithm = new SolveAlgorithm(tblA, tblB);

        tblC = algorithm.getByInclude(tblA);
//        tblC = tbl.getByInclude(tblB);

        System.out.println(tblC);
    }

    /**
     * Create and fill table 'C' containing: (ID).
     * By exclude a table-A or table-B and use match by 'WORD'
     */
    @Test
    public void testGetByExclude() {
        algorithm = new SolveAlgorithm(tblA, tblB);

        tblC = algorithm.getByExclude(tblA);
//        tblC = tbl.getByExclude(tblB);

        System.out.println(tblC);
    }

    /**
     * To calculate result.
     * By include a table-A or table-B and use match by 'WORD'
     */
    @Test
    public void testCalculateByInclude() {
        algorithm = new SolveAlgorithm(tblA, tblB);

        System.out.println( algorithm.getByInclude(tblA).size() );
//        System.out.println( tbl.getByInclude(tblB).size() );
    }

    /**
     * To calculate result.
     * By include a table-A or table-B and use match by 'WORD'
     */
    @Test
    public void testCalculateByExclude() {
        algorithm = new SolveAlgorithm(tblA, tblB);

        System.out.println( algorithm.getByExclude(tblA).size() );
//        System.out.println( tbl.getByExclude(tblB).size() );
    }


    /**
     * There is a Table 'A' containing 2-fields: (WORD, ID) and table 'B' containing: (WORD, ID2).
     * IDs are random and does not match.
     *
     * (Java generating random sequence of numbers with random access to the sequence elements)
     */
    private void init() {
        tblA.put(new Word("Sasha"), UUID.randomUUID().toString());
        tblA.put(new Word("Masha"), UUID.randomUUID().toString());
        tblA.put(new Word("Roman"), UUID.randomUUID().toString());
        tblA.put(new Word("Misha"), UUID.randomUUID().toString());
        tblA.put(new Word("Dasha"), UUID.randomUUID().toString());

        tblB.put(new Word("Alexandr"), UUID.randomUUID().toString());
        tblB.put(new Word("Masha"), UUID.randomUUID().toString());
        tblB.put(new Word("Vladimir"), UUID.randomUUID().toString());
        tblA.put(new Word("Misha"), UUID.randomUUID().toString());
    }
}
