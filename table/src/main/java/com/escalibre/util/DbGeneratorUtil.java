package com.escalibre.util;


import com.escalibre.dao.TblDao;
import com.escalibre.model.Tbl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;

public class DbGeneratorUtil {

    public static final int COPIES = 100;

    public static void main(String[] args) {
        try {
            generator();
        } catch (IOException e) { e.printStackTrace(); }

    }

    public static void generator()
            throws IOException {

        for (int copy=0; copy<COPIES; ++copy) {
            BufferedReader bufferedMaleNames = new BufferedReader(new FileReader("male_names.txt")),
                    bufferedFemaleNames = new BufferedReader(new FileReader("female_names.txt"));
            String name = null;

            ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
            TblDao tblDao = (TblDao) context.getBean("tblDao");

            /*
             * Male names
             */
            while ((name = bufferedMaleNames.readLine()) != null) {
                tblDao.addTbla(new Tbl(name+copy));
            }

            /*
             * Female names
             */
            while ((name = bufferedFemaleNames.readLine()) != null) {
                tblDao.addTblb(new Tbl(name+copy));
            }
        }
    }

}
