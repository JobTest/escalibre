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


public class SqlAlgorithmJ8Test {

    private SqlAlgorithmJ8 algorithm;
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

        algorithm = new SqlAlgorithmJ8();
    }

    @After
    public void tearDown() {
        dbTblA.shutdown();
        dbTblB.shutdown();
    }

    @Test
    public void testFindTblComplex() {
        List<String> tblC = new ArrayList<>();

        tblC = algorithm.leftJoinToIds(tblA, tblB);
//        tblC = algorithm.leftJoinToIds(tblA, null);
//        tblC = algorithm.leftJoinToIds(null, tblB);
        System.out.println( "tblC (left): " + tblC );

        tblC = algorithm.rightJoinToIds(tblA, tblB);
//        tblC = algorithm.rightJoinToIds(tblA, null);
//        tblC = algorithm.rightJoinToIds(null, tblB);
        System.out.println( "tblC (right): " + tblC );
    }

    @Test
    public void testFindTblComplexIsNull() {
        List<String> tblC = new ArrayList<>();

        tblC = algorithm.leftJoinToIds(tblA, null);
//        tblC = algorithm.leftJoinToIds(null, tblB);
        System.out.println( "tblC (leftJoin) = " + tblC.size() );
//        System.out.println( "tblC: " + tblC );

//        tblC = algorithm.rightJoinToIds(tblA, null);
        tblC = algorithm.rightJoinToIds(null, tblB);
        System.out.println( "tblC (rightJoin) = " + tblC.size() );
//        System.out.println( "tblC: " + tblC );
    }

    /**
     * С помощью встроенных методов Java-8 можно получить высокую производительность
     */
    @Test
    public void testFindTblHighPerfomance() {
        List<Tbl> tbls = new ArrayList<>();
        List<String> tblC = new ArrayList<>();
        long start, finish;

        start = System.currentTimeMillis();
        tblC = algorithm.leftJoinToIds(tblA, tblB); // >> 5 Millisecond
        finish = System.currentTimeMillis();
        System.out.println( "tblC (leftJoin) = " + tblC.size() + "  >> " + (finish-start) + " Millisecond" );
//        System.out.println( "tblC: " + tblC );

        start = System.currentTimeMillis();
        tblC = algorithm.rightJoinToIds(tblA, tblB); // >> 5 Millisecond
        finish = System.currentTimeMillis();
        System.out.println( "tblC (rightJoin) = " + tblC.size() + "  >> " + (finish-start) + " Millisecond" );
//        System.out.println( "tblC: " + tblC );
    }

    /**
     * Производительность зависит от порядка методов в стриме.. , неправильный порядок или лишние операции снижают производительность
     */
    @Test
    public void testFindTblAlternativePerfomance() {
        List<Tbl> tbls = new ArrayList<>();
        List<String> tblC = new ArrayList<>();
        long start, finish;

        start = System.currentTimeMillis();
        tbls = algorithm.leftJoinAlternative(tblA, tblB); // >> 346 Millisecond
        finish = System.currentTimeMillis();
        tblC = algorithm.toIDs(tbls);
        System.out.println( "tblC (leftJoin) = " + tblC.size() + "  >> " + (finish-start) + " Millisecond" );
//        System.out.println( "tblC: " + tblC );

        start = System.currentTimeMillis();
        tbls = algorithm.rightJoinAlternative(tblA, tblB); // >> 22 Millisecond
        finish = System.currentTimeMillis();
        tblC = algorithm.toIDs(tbls);
        System.out.println( "tblC (rightJoin) = " + tblC.size() + "  >> " + (finish-start) + " Millisecond" );
//        System.out.println( "tblC: " + tblC );
    }
}
