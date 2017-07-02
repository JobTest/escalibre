package com.escalibre;

import com.escalibre.dao.ItemDaoImpl;
import com.escalibre.model.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.ArrayList;
import java.util.List;


public class SqlAlgorithmJ7Test {

    private SqlAlgorithmJ7 algorithm;
    private EmbeddedDatabase dbTblA, dbTblB;
    private List<Item> tblA, tblB;


    @Before

    public void setUp() {
        dbTblA = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("db/create-tbla-db.sql")
                .addScript("db/insert-tbla-data.sql")
                .build();
        dbTblB = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("db/create-tblb-db.sql")
                .addScript("db/insert-tblb-data.sql")
                .build();

        ItemDaoImpl itemDao = new ItemDaoImpl();
        itemDao.setNamedParameterJdbcTemplate(new NamedParameterJdbcTemplate(dbTblA));
        tblA = itemDao.findTblaAll();
        itemDao.setNamedParameterJdbcTemplate(new NamedParameterJdbcTemplate(dbTblB));
        tblB = itemDao.findTblbAll();

        algorithm = new SqlAlgorithmJ7();
    }

    @After
    public void tearDown() {
        dbTblA.shutdown();
        dbTblB.shutdown();
    }

    @Test
    public void testFindTblIsLoad() {
        System.out.println( "left (size) = " + tblA.size() );
        System.out.println( "right (size) = " + tblB.size() );
    }

    @Test
    public void testFindTblIsNull() {
        List<Item> items = new ArrayList<>();
        List<String> tblC = new ArrayList<>();

        items = algorithm.leftJoin(tblA, null);
//        items = algorithm.leftJoin(null, tblB);
        tblC = algorithm.toIDs(items);
        System.out.println( "tblC (leftJoin) = " + tblC.size() );

//        items = algorithm.rightJoin(tblA, null);
        items = algorithm.rightJoin(null, tblB);
        tblC = algorithm.toIDs(items);
        System.out.println( "tblC (rightJoin) = " + tblC.size() );
    }

    @Test
    public void testFindTblCustomPerfomance() {
        List<Item> items = new ArrayList<>();
        List<String> tblC = new ArrayList<>();
        long start, finish;

        start = System.currentTimeMillis();
        items = algorithm.leftJoinCustom(tblA, tblB); // >> 110 Millisecond
        finish = System.currentTimeMillis();
        tblC = algorithm.toIDs(items);
        System.out.println( "tblC (leftJoin) = " + tblC.size() + "  >> " + (finish-start) + " Millisecond" );
//        System.out.println( "tblC: " + tblC );

        start = System.currentTimeMillis();
        items = algorithm.rightJoinCustom(tblA, tblB); // >> 106 Millisecond
        finish = System.currentTimeMillis();
        tblC = algorithm.toIDs(items);
        System.out.println( "tblC (rightJoin) = " + tblC.size() + "  >> " + (finish-start) + " Millisecond" );
//        System.out.println( "tblC: " + tblC );
    }

    @Test
    public void testFindTblHighPerfomance() {
        List<Item> items = new ArrayList<>();
        List<String> tblC = new ArrayList<>();
        long start, finish;

        start = System.currentTimeMillis();
        items = algorithm.leftJoin(tblA, tblB); // >> 46 Millisecond
        finish = System.currentTimeMillis();
        tblC = algorithm.toIDs(items);
        System.out.println( "tblC (leftJoin) = " + tblC.size() + "  >> " + (finish-start) + " Millisecond" );
//        System.out.println( "tblC: " + tblC );

        start = System.currentTimeMillis();
        items = algorithm.rightJoin(tblA, tblB); // >> 7 Millisecond
        finish = System.currentTimeMillis();
        tblC = algorithm.toIDs(items);
        System.out.println( "tblC (rightJoin) = " + tblC.size() + "  >> " + (finish-start) + " Millisecond" );
//        System.out.println( "tblC: " + tblC );
    }
}
