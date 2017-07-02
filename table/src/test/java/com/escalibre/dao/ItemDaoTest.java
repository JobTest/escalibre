//package com.escalibre.dao;
//
//import com.escalibre.model.Item;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//public class ItemDaoTest {
//
//    private EmbeddedDatabase dbTblA, dbTblB;
//    private ItemDaoImpl itemDao;
//
//    @Before
//    public void setUp() {
//        dbTblA = new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.HSQL)
//                .addScript("db/create-tbla-db.sql")
//                .addScript("db/_insert-tbla-data.sql")
//                .build();
//        dbTblB = new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.HSQL)
//                .addScript("db/create-tblb-db.sql")
//                .addScript("db/_insert-tblb-data.sql")
//                .build();
//
//        itemDao = new ItemDaoImpl();
//    }
//
//    @After
//    public void tearDown() {
//        dbTblA.shutdown();
//        dbTblB.shutdown();
//    }
//
//    @Test
//    public void testFindTblAll() {
//        itemDao.setNamedParameterJdbcTemplate(new NamedParameterJdbcTemplate(dbTblA));
//        List<Item> tblA = itemDao.findTblaAll();
//        itemDao.setNamedParameterJdbcTemplate(new NamedParameterJdbcTemplate(dbTblB));
//        List<Item> tblB = itemDao.findTblbAll();
//
//        System.out.println( "left: " + toWORDs(tblA) );
//        System.out.println( "right: " + toWORDs(tblB) );
//
//        /////////////////////////////////////////
//        System.out.println( "/////////////////////////////////////////" );
//
////        List<MyItem> rightJoin = rightJoin(tblA, tblB);
////        System.out.println( rightJoin );
////
////        List<String> its = toIDs(rightJoin);
////        System.out.println( its );
//
//        List<String> lJoin = lJoin(tblA, tblB);
////        List<String> lJoin = lJoin(tblA, null);
////        List<String> lJoin = lJoin(null, tblB);
//        System.out.println( "lJoin: " + lJoin );
//
//        List<String> rJoin = rJoin(tblA, tblB);
////        List<String> rJoin = rJoin(tblA, null);
////        List<String> rJoin = rJoin(null, tblB);
//        System.out.println( "rJoin: " + rJoin );
//    }
//
//    List<String> toIDs(List<Item> items){
//        return items.stream()
//                .map(i -> i.getId())
//                .collect(Collectors.toList());
//    }
//
//    List<String> toWORDs(List<Item> items){
//        return items.stream()
//                .map(i -> i.getWord())
//                .collect(Collectors.toList());
//    }
//
//    List<String> lJoin(List<Item> tblA, List<Item> tblB){
//        if (tblA==null)
//            return null;
//        else if (tblB==null)
//            return tblA.stream()
//                    .map(i -> i.getWord())
//                    .collect(Collectors.toList());
//
////        System.out.println( "left = " + toWORDs(tblA) );
//        List<String> lJoin = tblA.parallelStream()
//                .filter(i -> !tblB.contains(i))
//                .map(i -> i.getWord())
//                .collect(Collectors.toList());
////        System.out.println( "left = " + toWORDs(tblA) );
//        return lJoin;
//    }
//
//    List<String> rJoin(List<Item> tblA, List<Item> tblB){
//        if (tblB==null)
//            return null;
//        else if (tblA==null)
//            return tblB.stream()
//                    .map(i -> i.getWord())
//                    .collect(Collectors.toList());
//
////        System.out.println( "right = " + toWORDs(tblB) );
//        List<String> rJoin = tblB.parallelStream()
//                .filter(i -> !tblA.contains(i))
//                .map(i -> i.getWord())
//                .collect(Collectors.toList());
////        System.out.println( "right = " + toWORDs(tblB) );
//        return rJoin;
//    }
//}
