package com.escalibre;

import com.escalibre.dao.TblDaoImpl;
import com.escalibre.model.Tbl;
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
    private List<Tbl> tblA, tblB;

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

        TblDaoImpl itemDao = new TblDaoImpl();
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
        List<Tbl> tbls = new ArrayList<>();
        List<String> tblC = new ArrayList<>();

        tbls = algorithm.leftJoin(tblA, null);
//        items = algorithm.leftJoin(null, tblB);
        tblC = algorithm.toIDs(tbls);
        System.out.println( "tblC (leftJoin) = " + tblC.size() );

//        items = algorithm.rightJoin(tblA, null);
        tbls = algorithm.rightJoin(null, tblB);
        tblC = algorithm.toIDs(tbls);
        System.out.println( "tblC (rightJoin) = " + tblC.size() );
    }

    /**
     * Производительность класического алгоритма является самой низкой
     */
    @Test
    public void testFindTblCustomPerfomance() {
        List<Tbl> tbls = new ArrayList<>();
        List<String> tblC = new ArrayList<>();
        long start, finish;

        start = System.currentTimeMillis();
        tbls = algorithm.leftJoinCustom(tblA, tblB); // >> 110 Millisecond
        finish = System.currentTimeMillis();
        tblC = algorithm.toIDs(tbls);
        System.out.println( "tblC (leftJoin) = " + tblC.size() + "  >> " + (finish-start) + " Millisecond" );
//        System.out.println( "tblC: " + tblC );

        start = System.currentTimeMillis();
        tbls = algorithm.rightJoinCustom(tblA, tblB); // >> 106 Millisecond
        finish = System.currentTimeMillis();
        tblC = algorithm.toIDs(tbls);
        System.out.println( "tblC (rightJoin) = " + tblC.size() + "  >> " + (finish-start) + " Millisecond" );
//        System.out.println( "tblC: " + tblC );
    }

    /**
     * Встроенные методы коллекции имеют среднюю производительность
     */
    @Test
    public void testFindTblMediumPerfomance() {
        List<Tbl> tbls = new ArrayList<>();
        List<String> tblC = new ArrayList<>();
        long start, finish;

        start = System.currentTimeMillis();
        tbls = algorithm.leftJoin(tblA, tblB); // >> 46 Millisecond
        finish = System.currentTimeMillis();
        tblC = algorithm.toIDs(tbls);
        System.out.println( "tblC (leftJoin) = " + tblC.size() + "  >> " + (finish-start) + " Millisecond" );
//        System.out.println( "tblC: " + tblC );

        start = System.currentTimeMillis();
        tbls = algorithm.rightJoin(tblA, tblB); // >> 7 Millisecond
        finish = System.currentTimeMillis();
        tblC = algorithm.toIDs(tbls);
        System.out.println( "tblC (rightJoin) = " + tblC.size() + "  >> " + (finish-start) + " Millisecond" );
//        System.out.println( "tblC: " + tblC );
    }
}
