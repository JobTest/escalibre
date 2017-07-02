package com.escalibre;

import com.escalibre.dao.ItemDaoImpl;
import com.escalibre.model.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.ArrayList;
import java.util.List;


public class AlgorithmWithJava8Test {

    private AlgorithmWithJava8 algorithm;
    private EmbeddedDatabase dbTblA, dbTblB;
    private ItemDaoImpl itemDao;

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

        itemDao = new ItemDaoImpl();
        algorithm = new AlgorithmWithJava8();
    }

    @After
    public void tearDown() {
        dbTblA.shutdown();
        dbTblB.shutdown();
    }

    @Test
    public void testFindTblAll() {
        itemDao.setNamedParameterJdbcTemplate(new NamedParameterJdbcTemplate(dbTblA));
        List<Item> tblA = itemDao.findTblaAll();
        itemDao.setNamedParameterJdbcTemplate(new NamedParameterJdbcTemplate(dbTblB));
        List<Item> tblB = itemDao.findTblbAll();

//        System.out.println( "left (size) = " + tblA.size() );
//        System.out.println( "right (size) = " + tblB.size() );

        ////////////////////////////////////////////////////////////////////////
        List<String> tblC = new ArrayList<>();
        long start, finish;

        start = System.currentTimeMillis();
        tblC = algorithm.leftJoin(tblA, tblB);
//        tblC = algorithm.leftJoin(tblA, null);
//        tblC = algorithm.leftJoin(null, tblB);
        finish = System.currentTimeMillis();
        System.out.println( "tblC (leftJoin) = " + tblC.size() + "  >> " + (finish-start) + " Millisecond" );

        start = System.currentTimeMillis();
        tblC = algorithm.rightJoin(tblA, tblB);
//        tblC = algorithm.rightJoin(tblA, null);
//        tblC = algorithm.rightJoin(null, tblB);
        finish = System.currentTimeMillis();
        System.out.println( "tblC (rightJoin) = " + tblC.size() + "  >> " + (finish-start) + " Millisecond" );

        System.out.println( "tblC: " + tblC );
        System.out.println( "left (size) = " + tblA.size() );
        System.out.println( "right (size) = " + tblB.size() );
    }
}
