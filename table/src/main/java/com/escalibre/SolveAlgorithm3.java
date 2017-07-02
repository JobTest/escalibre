package com.escalibre;


import com.escalibre.dao.ItemDao;
import com.escalibre.dao.ItemDaoImpl;
import com.escalibre.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

public class SolveAlgorithm3 {

//    public static void main(String[] args) {
//        List<Item> tblA = new ArrayList<>();
//        tblA.add(new Item("Sasha"));
//        tblA.add(new Item("Masha"));
//        tblA.add(new Item("Roman"));
//        tblA.add(new Item("Misha"));
//        tblA.add(new Item("Dasha"));
//        System.out.println( "left: " + tblA );
//
//        List<Item> tblB = new ArrayList<>();
//        tblB.add(new Item("Alexandr"));
//        tblB.add(new Item("Masha"));
//        tblB.add(new Item("Vladimir"));
//        tblB.add(new Item("Misha"));
//        System.out.println( "right: " + tblB );
//
//
////        manNames.retainAll(womanNames);
//        System.out.println( "leftJoin: " + toWORDs(leftJoin(tblA, tblB)));
////        System.out.println( "leftJoin: " + leftJoin(tblA,null) );
////        System.out.println( "leftJoin: " + leftJoin(null,tblB) );
//
//        System.out.println( "rightJoin: " + toWORDs(rightJoin(tblA, tblB)));
////        System.out.println( "rightJoin: " + rightJoin(tblA, null) );
////        System.out.println( "rightJoin: " + rightJoin(null, tblB) );
//
//        System.out.println( "left: " + toWORDs(tblA) );
//        System.out.println( "right: " + toWORDs(tblB) );
//
//        /////////////////////////////////////////
//        // https://stackoverflow.com/questions/23057549/lambda-expression-to-convert-array-list-of-string-to-array-list-of-integers
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



    public static void main(String[] args) {
//        SolveAlgorithm3.generator();
//        new SolveAlgorithm3().test();

        //////////////////////////////////////////////////////
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        ItemDao itemDao = (ItemDao) context.getBean("itemDao");

        List<Item> tblA = itemDao.findTblaAll(),
                tblB = itemDao.findTblbAll();

        System.out.println( "left (size) = " + tblA.size() ); // 54644
        System.out.println( "right (size) = " + tblB.size() ); // 29907


//        System.out.println( "leftJoin (size) = " + leftJoin(tblA, tblB).size() );
//        System.out.println( "leftJoin (size) = " + leftJoin(tblA,null).size() );
//        System.out.println( "leftJoin (size) = " + leftJoin(null,tblB).size() );

//        System.out.println( "rightJoin (size) = " + rightJoin(tblA, tblB).size() );
//        System.out.println( "rightJoin (size) = " + rightJoin(tblA, null).size() );
//        System.out.println( "rightJoin (size) = " + rightJoin(null, tblB).size() );


        long lStart = System.currentTimeMillis();
//        List<String> tblC = lJoin(tblA, tblB);
//        List<String> tblC = lJoin(tblA, null);
//        List<String> tblC = lJoin(null, tblB);
        long lStop = System.currentTimeMillis();

        long rStart = System.currentTimeMillis();
        List<String> tblC = rJoin(tblA, tblB);
//        List<String> tblC = rJoin(tblA, null);
//        List<String> tblC = rJoin(null, tblB);
        long rStop = System.currentTimeMillis();

//        System.out.println( "tblC (size) = " + lJoin.size() + "  >>  " + (lStop-lStart) + " sec." ); // 54644
        System.out.println( "tblC (size) = " + tblC.size() + "  >>  " + (rStop-rStart) + " sec." ); // 29907
        System.out.println( tblC);
    }

    void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        ItemDao itemDao = (ItemDao) context.getBean("itemDao");

        List<Item> tblA = itemDao.findTblaAll();
        List<Item> tblB = itemDao.findTblbAll();

        System.err.println( "left (size) = " + tblA.size() );
        System.err.println( "right (size) = " + tblB.size() );
    }

    static void generator(){
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        ItemDao itemDao = (ItemDao) context.getBean("itemDao");

        //////////////////////////////////////////////////////
        for (int i=0; i<100; ++i) {
            itemDao.putTbla(new Item("Абрам"));
            itemDao.putTbla(new Item("Авангард"));
            itemDao.putTbla(new Item("Август"));
            itemDao.putTbla(new Item("Августин"));
            itemDao.putTbla(new Item("Авдей"));
            itemDao.putTbla(new Item("Авенир"));
            itemDao.putTbla(new Item("Аверкий"));
            itemDao.putTbla(new Item("Авксентий"));
            itemDao.putTbla(new Item("Аврор"));
            itemDao.putTbla(new Item("Агап"));
            itemDao.putTbla(new Item("Агей"));
            itemDao.putTbla(new Item("Адам"));
            itemDao.putTbla(new Item("Адий"));
            itemDao.putTbla(new Item("Адольф"));
            itemDao.putTbla(new Item("Адонис"));
            itemDao.putTbla(new Item("Адриан"));
            itemDao.putTbla(new Item("Аким"));
            itemDao.putTbla(new Item("Аксён"));
            itemDao.putTbla(new Item("Алан"));
            itemDao.putTbla(new Item("Алевтин"));
            itemDao.putTbla(new Item("Александр"));
            itemDao.putTbla(new Item("Алексей"));
            itemDao.putTbla(new Item("Алим"));
            itemDao.putTbla(new Item("Альберт"));
            itemDao.putTbla(new Item("Альбин"));
            itemDao.putTbla(new Item("Альвиан"));
            itemDao.putTbla(new Item("Альвин"));
            itemDao.putTbla(new Item("Альфред"));
            itemDao.putTbla(new Item("Амос"));
            itemDao.putTbla(new Item("Ананий"));
            itemDao.putTbla(new Item("Анастасий"));
            itemDao.putTbla(new Item("Анатолий"));
            itemDao.putTbla(new Item("Анвар"));
            itemDao.putTbla(new Item("Андрей"));
            itemDao.putTbla(new Item("Андриан"));
            itemDao.putTbla(new Item("Андрон"));
            itemDao.putTbla(new Item("Анис"));
            itemDao.putTbla(new Item("Анисим"));
            itemDao.putTbla(new Item("Анри"));
            itemDao.putTbla(new Item("Антип"));
            itemDao.putTbla(new Item("Антон"));
            itemDao.putTbla(new Item("Антонин"));
            itemDao.putTbla(new Item("Антуан"));
            itemDao.putTbla(new Item("Аполлинарий"));
            itemDao.putTbla(new Item("Аполлон"));
            itemDao.putTbla(new Item("Арам"));
            itemDao.putTbla(new Item("Арвид"));
            itemDao.putTbla(new Item("Аргент"));
            itemDao.putTbla(new Item("Арефий"));
            itemDao.putTbla(new Item("Арий"));
            itemDao.putTbla(new Item("Аристарх"));
            itemDao.putTbla(new Item("Аркадий"));
            itemDao.putTbla(new Item("Арлен"));
            itemDao.putTbla(new Item("Арнольд"));
            itemDao.putTbla(new Item("Арсен"));
            itemDao.putTbla(new Item("Арсений"));
            itemDao.putTbla(new Item("Артамон"));
            itemDao.putTbla(new Item("Артём"));
            itemDao.putTbla(new Item("Артур"));
            itemDao.putTbla(new Item("Архип"));
            itemDao.putTbla(new Item("Аскольд"));
            itemDao.putTbla(new Item("Атеист"));
            itemDao.putTbla(new Item("Афанасий"));
            itemDao.putTbla(new Item("Афиноген"));
            itemDao.putTbla(new Item("Ахмат"));
            itemDao.putTbla(new Item("Баграт"));
            itemDao.putTbla(new Item("Бажен"));
            itemDao.putTbla(new Item("Баян"));
            itemDao.putTbla(new Item("Бенедикт"));
            itemDao.putTbla(new Item("Бернард"));
            itemDao.putTbla(new Item("Бертольд"));
            itemDao.putTbla(new Item("Богдан"));
            itemDao.putTbla(new Item("Боеслав"));
            itemDao.putTbla(new Item("Болеслав"));
            itemDao.putTbla(new Item("Боримир"));
            itemDao.putTbla(new Item("Борис"));
            itemDao.putTbla(new Item("Борислав"));
            itemDao.putTbla(new Item("Боян"));
            itemDao.putTbla(new Item("Бронислав"));
            itemDao.putTbla(new Item("Бруно"));
            itemDao.putTbla(new Item("Будимир"));
            itemDao.putTbla(new Item("Булат"));
            itemDao.putTbla(new Item("Вавила"));
            itemDao.putTbla(new Item("Вадим"));
            itemDao.putTbla(new Item("Валентин"));
            itemDao.putTbla(new Item("Валерий"));
            itemDao.putTbla(new Item("Валериан"));
            itemDao.putTbla(new Item("Вальтер"));
            itemDao.putTbla(new Item("Ванадий"));
            itemDao.putTbla(new Item("Варлам"));
            itemDao.putTbla(new Item("Варлен"));
            itemDao.putTbla(new Item("Вартан"));
            itemDao.putTbla(new Item("Варфоломей"));
            itemDao.putTbla(new Item("Василий"));
            itemDao.putTbla(new Item("Василько"));
            itemDao.putTbla(new Item("Вахтанг"));
            itemDao.putTbla(new Item("Вацлав"));
            itemDao.putTbla(new Item("Велимир"));
            itemDao.putTbla(new Item("Велислав"));
            itemDao.putTbla(new Item("Велор"));
            itemDao.putTbla(new Item("Венедикт"));
            itemDao.putTbla(new Item("Вениамин"));
            itemDao.putTbla(new Item("Вергилий"));
            itemDao.putTbla(new Item("Викентий"));
            itemDao.putTbla(new Item("Виктор"));
            itemDao.putTbla(new Item("Вилен"));
            itemDao.putTbla(new Item("Вилий"));
            itemDao.putTbla(new Item("Вилиор"));
            itemDao.putTbla(new Item("Вилли"));
            itemDao.putTbla(new Item("Вилор"));
            itemDao.putTbla(new Item("Вилорг"));
            itemDao.putTbla(new Item("Виль"));
            itemDao.putTbla(new Item("Вильгельм"));
            itemDao.putTbla(new Item("Вильям"));
            itemDao.putTbla(new Item("Винцент"));
            itemDao.putTbla(new Item("Виолен"));
            itemDao.putTbla(new Item("Виссарион"));
            itemDao.putTbla(new Item("Виталий"));
            itemDao.putTbla(new Item("Витольд"));
            itemDao.putTbla(new Item("Влад"));
            itemDao.putTbla(new Item("Владелин"));
            itemDao.putTbla(new Item("Владилен"));
            itemDao.putTbla(new Item("Владимир"));
            itemDao.putTbla(new Item("Владислав"));
            itemDao.putTbla(new Item("Владлен"));
            itemDao.putTbla(new Item("Влас"));
            itemDao.putTbla(new Item("Воин"));
            itemDao.putTbla(new Item("Воислав"));
            itemDao.putTbla(new Item("Володар"));
            itemDao.putTbla(new Item("Вольдемар"));
            itemDao.putTbla(new Item("Вольмир"));
            itemDao.putTbla(new Item("Вольт"));
            itemDao.putTbla(new Item("Вольфрам"));
            itemDao.putTbla(new Item("Всеволод"));
            itemDao.putTbla(new Item("Всемил"));
            itemDao.putTbla(new Item("Вячеслав"));
            //////////////////////////////////////////////////////
            itemDao.putTblb(new Item("Авдотья"));
            itemDao.putTblb(new Item("Агата"));
            itemDao.putTblb(new Item("Аглая"));
            itemDao.putTblb(new Item("Агния"));
            itemDao.putTblb(new Item("Аделина"));
            itemDao.putTblb(new Item("Аделаида"));
            itemDao.putTblb(new Item("Аксинья"));
            itemDao.putTblb(new Item("Акулина"));
            itemDao.putTblb(new Item("Алевтина"));
            itemDao.putTblb(new Item("Александра"));
            itemDao.putTblb(new Item("Алиса"));
            itemDao.putTblb(new Item("Алла"));
            itemDao.putTblb(new Item("Анастасия"));
            itemDao.putTblb(new Item("Ангелина"));
            itemDao.putTblb(new Item("Анжела"));
            itemDao.putTblb(new Item("Анжелика"));
            itemDao.putTblb(new Item("Анисия"));
            itemDao.putTblb(new Item("Анфиса"));
            itemDao.putTblb(new Item("Ариана"));
            itemDao.putTblb(new Item("Ася"));
            itemDao.putTblb(new Item("Афанасия"));
            itemDao.putTblb(new Item("Аэлита"));
            itemDao.putTblb(new Item("Василина"));
            itemDao.putTblb(new Item("Василиса"));
            itemDao.putTblb(new Item("Весёна"));
            itemDao.putTblb(new Item("Вероника"));
            itemDao.putTblb(new Item("Галина"));
            itemDao.putTblb(new Item("Георгина"));
            itemDao.putTblb(new Item("Глафира"));
            itemDao.putTblb(new Item("Гликерия"));
            itemDao.putTblb(new Item("Дарья"));
            itemDao.putTblb(new Item("Диана"));
            itemDao.putTblb(new Item("Евангелина"));
            itemDao.putTblb(new Item("Евгения"));
            itemDao.putTblb(new Item("Евдокия"));
            itemDao.putTblb(new Item("Евпраксия"));
            itemDao.putTblb(new Item("Екатерина"));
            itemDao.putTblb(new Item("Елена"));
            itemDao.putTblb(new Item("Ефросиния"));
            itemDao.putTblb(new Item("Зинаида"));
            itemDao.putTblb(new Item("Зоя"));
            itemDao.putTblb(new Item("Илона"));
            itemDao.putTblb(new Item("Инесса"));
            itemDao.putTblb(new Item("Ирина"));
            itemDao.putTblb(new Item("Камилла"));
            itemDao.putTblb(new Item("Кира"));
            itemDao.putTblb(new Item("Ксения"));
            itemDao.putTblb(new Item("Лариса"));
            itemDao.putTblb(new Item("Лидия"));
            itemDao.putTblb(new Item("Лика"));
            itemDao.putTblb(new Item("Лина"));
            itemDao.putTblb(new Item("Мелания"));
            itemDao.putTblb(new Item("Нелли"));
            itemDao.putTblb(new Item("Ника"));
            itemDao.putTblb(new Item("Нина"));
            itemDao.putTblb(new Item("Пелагея"));
            itemDao.putTblb(new Item("Полина"));
            itemDao.putTblb(new Item("Прасковья"));
            itemDao.putTblb(new Item("Раиса"));
            itemDao.putTblb(new Item("София"));
            itemDao.putTblb(new Item("Степанида"));
            itemDao.putTblb(new Item("Стефания"));
            itemDao.putTblb(new Item("Стефанида"));
            itemDao.putTblb(new Item("Таисия"));
            itemDao.putTblb(new Item("Тамара"));
            itemDao.putTblb(new Item("Феврония"));
            itemDao.putTblb(new Item("Хавронья"));
            itemDao.putTblb(new Item("Фёкла"));
            itemDao.putTblb(new Item("Феодора"));
            itemDao.putTblb(new Item("Феодосия"));
            itemDao.putTblb(new Item("Элеонора"));
            itemDao.putTblb(new Item("Элина"));
            itemDao.putTblb(new Item("Элла"));
            itemDao.putTblb(new Item("Эмилия"));
            itemDao.putTblb(new Item("Эмма"));
        }
    }


    static List<String> lJoin(List<Item> tblA, List<Item> tblB){
        if (tblA==null)
            return null;
        else if (tblB==null)
            return tblA.stream()
                .map(i -> i.getId())
                .collect(Collectors.toList());
        return tblA.parallelStream()
                .filter(i -> !tblB.contains(i))
                .map(i -> i.getId())
                .collect(Collectors.toList());
    }

    static List<String> rJoin(List<Item> tblA, List<Item> tblB){
        if (tblB==null)
            return null;
        else if (tblA==null)
            return tblB.stream()
                    .map(i -> i.getId())
                    .collect(Collectors.toList());
        return tblB.parallelStream()
                .filter(i -> !tblA.contains(i))
                .map(i -> i.getId())
                .collect(Collectors.toList());
    }


    static List<Item> leftJoin(List<Item> tblA, List<Item> tblB){
        if (tblA==null)
            return null;
        else if (tblB==null)
            return tblA;

        List<Item> left = (ArrayList) ((ArrayList) tblA).clone();
        return left.removeAll(tblB)
                ? left
                : null;
    }

    static List<Item> rightJoin(List<Item> tblA, List<Item> tblB){
        if (tblB==null)
            return null;
        else if (tblA==null)
            return tblB;

        List<Item> right = (ArrayList) ((ArrayList) tblB).clone();
        return right.removeAll(tblA)
                ? right
                : null;
    }

    static List<String> toIDs(List<Item> items){
        return items.stream()
                .map(i -> i.getId())
                .collect(Collectors.toList());
    }

    static List<String> toWORDs(List<Item> items){
        return items.stream()
                .map(i -> i.getWord())
                .collect(Collectors.toList());
    }
}
