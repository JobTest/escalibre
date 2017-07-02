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
import java.util.List;


public class AlgorithmWithJava7Test {

    @Autowired
    private AlgorithmWithJava7 algorithm;
    private EmbeddedDatabase dbTblA, dbTblB;
    private ItemDaoImpl itemDao;

    @Before
    public void setUp() {
        dbTblA = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("db/create-tbla-db.sql")
                .addScript("db/_insert-tbla-data.sql")
                .build();
        dbTblB = new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("db/create-tblb-db.sql")
                .addScript("db/_insert-tblb-data.sql")
                .build();

        itemDao = new ItemDaoImpl();
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

//        List<MyItem> rightJoin = rightJoin(tblA, tblB);
//        System.out.println( rightJoin );
//
//        List<String> its = toIDs(rightJoin);
//        System.out.println( its );

        List<String> tblC = algorithm.toIDs( algorithm.leftJoin(tblA, tblB) );
//        List<String> tblC = algorithm.toIDs( algorithm.leftJoin(tblA, null) );
//        List<String> tblC = algorithm.toIDs( algorithm.leftJoin(null, tblB) );
        System.out.println( "tblC: " + tblC );

//        List<String> tblC = algorithm.toIDs( algorithm.rightJoin(tblA, tblB) );
//        List<String> tblC = algorithm.toIDs( algorithm.rightJoin(tblA, null) );
//        List<String> tblC = algorithm.toIDs( algorithm.rightJoin(null, tblB) );
//        System.out.println( "tblC: " + tblC );
    }
}
