package com.escalibre.util;


import com.escalibre.dao.ItemDao;
import com.escalibre.model.Item;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;

public class RecordGeneratorUtil {

//    public static void main(String[] args) {
//        try {
//            generator();
//        } catch (IOException e) { e.printStackTrace(); }
//
//    }

    static void generator()
            throws IOException {
        BufferedReader bufferedMaleNames = new BufferedReader(new FileReader("male_names.txt")),
                bufferedFemaleNames = new BufferedReader(new FileReader("female_names.txt"));
        String name = null;

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        ItemDao itemDao = (ItemDao) context.getBean("itemDao");

        /*
         * Male names
         */
//        FileWriter tbla = new FileWriter("insert-tbla-data.sql");
        while ((name = bufferedMaleNames.readLine()) != null){
            itemDao.addTbla(new Item(name));
////            Item item = new Item(name);
////            tbla.append("\n('" + item.getWord() + "','" + item.getId() + "'),");
        }
//        tbla.close();

        /*
         * Female names
         */
//        FileWriter tblb = new FileWriter("insert-tblb-data.sql");
        while ((name = bufferedFemaleNames.readLine()) != null){
            itemDao.addTblb(new Item(name));
//            Item item = new Item(name);
//            tblb.append("\n('" + item.getWord() + "','" + item.getId() + "'),");
        }
//        tblb.close();
    }

}
