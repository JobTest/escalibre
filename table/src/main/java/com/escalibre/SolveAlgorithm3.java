//package com.escalibre;
//
//
//import com.escalibre.dao.ItemDao;
//import com.escalibre.dao.ItemDaoImpl;
//import com.escalibre.model.Item;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class SolveAlgorithm3 {
//
////    public static void main(String[] args) {
////        List<Item> tblA = new ArrayList<>();
////        tblA.add(new Item("Sasha"));
////        tblA.add(new Item("Masha"));
////        tblA.add(new Item("Roman"));
////        tblA.add(new Item("Misha"));
////        tblA.add(new Item("Dasha"));
////        System.out.println( "left: " + tblA );
////
////        List<Item> tblB = new ArrayList<>();
////        tblB.add(new Item("Alexandr"));
////        tblB.add(new Item("Masha"));
////        tblB.add(new Item("Vladimir"));
////        tblB.add(new Item("Misha"));
////        System.out.println( "right: " + tblB );
////
////
//////        manNames.retainAll(womanNames);
////        System.out.println( "leftJoin: " + toWORDs(leftJoin(tblA, tblB)));
//////        System.out.println( "leftJoin: " + leftJoin(tblA,null) );
//////        System.out.println( "leftJoin: " + leftJoin(null,tblB) );
////
////        System.out.println( "rightJoin: " + toWORDs(rightJoin(tblA, tblB)));
//////        System.out.println( "rightJoin: " + rightJoin(tblA, null) );
//////        System.out.println( "rightJoin: " + rightJoin(null, tblB) );
////
////        System.out.println( "left: " + toWORDs(tblA) );
////        System.out.println( "right: " + toWORDs(tblB) );
////
////        /////////////////////////////////////////
////        // https://stackoverflow.com/questions/23057549/lambda-expression-to-convert-array-list-of-string-to-array-list-of-integers
////        System.out.println( "/////////////////////////////////////////" );
////
//////        List<MyItem> rightJoin = rightJoin(tblA, tblB);
//////        System.out.println( rightJoin );
//////
//////        List<String> its = toIDs(rightJoin);
//////        System.out.println( its );
////
////        List<String> lJoin = lJoin(tblA, tblB);
//////        List<String> lJoin = lJoin(tblA, null);
//////        List<String> lJoin = lJoin(null, tblB);
////        System.out.println( "lJoin: " + lJoin );
////
////        List<String> rJoin = rJoin(tblA, tblB);
//////        List<String> rJoin = rJoin(tblA, null);
//////        List<String> rJoin = rJoin(null, tblB);
////        System.out.println( "rJoin: " + rJoin );
////    }
//
//
//
//    public static void main(String[] args) {
////        SolveAlgorithm3.generator();
////        new SolveAlgorithm3().testDbContains();
//
//        //////////////////////////////////////////////////////
//        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        ItemDao itemDao = (ItemDao) context.getBean("itemDao");
//
//        List<Item> tblA = itemDao.findTblaAll(),
//                tblB = itemDao.findTblbAll();
//
//        System.out.println( "left (size) = " + tblA.size() ); // 54644
//        System.out.println( "right (size) = " + tblB.size() ); // 29907
//
//
////        System.out.println( "leftJoin (size) = " + leftJoin(tblA, tblB).size() );
////        System.out.println( "leftJoin (size) = " + leftJoin(tblA,null).size() );
////        System.out.println( "leftJoin (size) = " + leftJoin(null,tblB).size() );
//
////        System.out.println( "rightJoin (size) = " + rightJoin(tblA, tblB).size() );
////        System.out.println( "rightJoin (size) = " + rightJoin(tblA, null).size() );
////        System.out.println( "rightJoin (size) = " + rightJoin(null, tblB).size() );
//
//
//        long lStart = System.currentTimeMillis();
////        List<String> tblC = lJoin(tblA, tblB);
////        List<String> tblC = lJoin(tblA, null);
////        List<String> tblC = lJoin(null, tblB);
//        long lStop = System.currentTimeMillis();
//
//        long rStart = System.currentTimeMillis();
//        List<String> tblC = rJoin(tblA, tblB);
////        List<String> tblC = rJoin(tblA, null);
////        List<String> tblC = rJoin(null, tblB);
//        long rStop = System.currentTimeMillis();
//
////        System.out.println( "tblC (size) = " + lJoin.size() + "  >>  " + (lStop-lStart) + " sec." ); // 54644
//        System.out.println( "tblC (size) = " + tblC.size() + "  >>  " + (rStop-rStart) + " sec." ); // 29907
//        System.out.println( tblC);
//    }
//
//    void testDbContains(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        ItemDao itemDao = (ItemDao) context.getBean("itemDao");
//
//        List<Item> tblA = itemDao.findTblaAll();
//        List<Item> tblB = itemDao.findTblbAll();
//
//        System.err.println( "left (size) = " + tblA.size() );
//        System.err.println( "right (size) = " + tblB.size() );
//    }
//
//    static void generator(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        ItemDao itemDao = (ItemDao) context.getBean("itemDao");
//
//        for (int i=0; i<100; ++i) {
//            /*
//             * Male names
//             */
//            itemDao.addTbla(new Item("Абрам"));
//            itemDao.addTbla(new Item("Авангард"));
//            itemDao.addTbla(new Item("Август"));
//            itemDao.addTbla(new Item("Августин"));
//            itemDao.addTbla(new Item("Авдей"));
//            itemDao.addTbla(new Item("Авенир"));
//            itemDao.addTbla(new Item("Аверкий"));
//            itemDao.addTbla(new Item("Авксентий"));
//            itemDao.addTbla(new Item("Аврор"));
//            itemDao.addTbla(new Item("Агап"));
//            itemDao.addTbla(new Item("Агей"));
//            itemDao.addTbla(new Item("Адам"));
//            itemDao.addTbla(new Item("Адий"));
//            itemDao.addTbla(new Item("Адольф"));
//            itemDao.addTbla(new Item("Адонис"));
//            itemDao.addTbla(new Item("Адриан"));
//            itemDao.addTbla(new Item("Аким"));
//            itemDao.addTbla(new Item("Аксён"));
//            itemDao.addTbla(new Item("Алан"));
//            itemDao.addTbla(new Item("Алевтин"));
//            itemDao.addTbla(new Item("Александр"));
//            itemDao.addTbla(new Item("Алексей"));
//            itemDao.addTbla(new Item("Алим"));
//            itemDao.addTbla(new Item("Альберт"));
//            itemDao.addTbla(new Item("Альбин"));
//            itemDao.addTbla(new Item("Альвиан"));
//            itemDao.addTbla(new Item("Альвин"));
//            itemDao.addTbla(new Item("Альфред"));
//            itemDao.addTbla(new Item("Амос"));
//            itemDao.addTbla(new Item("Ананий"));
//            itemDao.addTbla(new Item("Анастасий"));
//            itemDao.addTbla(new Item("Анатолий"));
//            itemDao.addTbla(new Item("Анвар"));
//            itemDao.addTbla(new Item("Андрей"));
//            itemDao.addTbla(new Item("Андриан"));
//            itemDao.addTbla(new Item("Андрон"));
//            itemDao.addTbla(new Item("Анис"));
//            itemDao.addTbla(new Item("Анисим"));
//            itemDao.addTbla(new Item("Анри"));
//            itemDao.addTbla(new Item("Антип"));
//            itemDao.addTbla(new Item("Антон"));
//            itemDao.addTbla(new Item("Антонин"));
//            itemDao.addTbla(new Item("Антуан"));
//            itemDao.addTbla(new Item("Аполлинарий"));
//            itemDao.addTbla(new Item("Аполлон"));
//            itemDao.addTbla(new Item("Арам"));
//            itemDao.addTbla(new Item("Арвид"));
//            itemDao.addTbla(new Item("Аргент"));
//            itemDao.addTbla(new Item("Арефий"));
//            itemDao.addTbla(new Item("Арий"));
//            itemDao.addTbla(new Item("Аристарх"));
//            itemDao.addTbla(new Item("Аркадий"));
//            itemDao.addTbla(new Item("Арлен"));
//            itemDao.addTbla(new Item("Арнольд"));
//            itemDao.addTbla(new Item("Арсен"));
//            itemDao.addTbla(new Item("Арсений"));
//            itemDao.addTbla(new Item("Артамон"));
//            itemDao.addTbla(new Item("Артём"));
//            itemDao.addTbla(new Item("Артур"));
//            itemDao.addTbla(new Item("Архип"));
//            itemDao.addTbla(new Item("Аскольд"));
//            itemDao.addTbla(new Item("Атеист"));
//            itemDao.addTbla(new Item("Афанасий"));
//            itemDao.addTbla(new Item("Афиноген"));
//            itemDao.addTbla(new Item("Ахмат"));
//            itemDao.addTbla(new Item("Баграт"));
//            itemDao.addTbla(new Item("Бажен"));
//            itemDao.addTbla(new Item("Баян"));
//            itemDao.addTbla(new Item("Бенедикт"));
//            itemDao.addTbla(new Item("Бернард"));
//            itemDao.addTbla(new Item("Бертольд"));
//            itemDao.addTbla(new Item("Богдан"));
//            itemDao.addTbla(new Item("Боеслав"));
//            itemDao.addTbla(new Item("Болеслав"));
//            itemDao.addTbla(new Item("Боримир"));
//            itemDao.addTbla(new Item("Борис"));
//            itemDao.addTbla(new Item("Борислав"));
//            itemDao.addTbla(new Item("Боян"));
//            itemDao.addTbla(new Item("Бронислав"));
//            itemDao.addTbla(new Item("Бруно"));
//            itemDao.addTbla(new Item("Будимир"));
//            itemDao.addTbla(new Item("Булат"));
//            itemDao.addTbla(new Item("Вавила"));
//            itemDao.addTbla(new Item("Вадим"));
//            itemDao.addTbla(new Item("Валентин"));
//            itemDao.addTbla(new Item("Валерий"));
//            itemDao.addTbla(new Item("Валериан"));
//            itemDao.addTbla(new Item("Вальтер"));
//            itemDao.addTbla(new Item("Ванадий"));
//            itemDao.addTbla(new Item("Варлам"));
//            itemDao.addTbla(new Item("Варлен"));
//            itemDao.addTbla(new Item("Вартан"));
//            itemDao.addTbla(new Item("Варфоломей"));
//            itemDao.addTbla(new Item("Василий"));
//            itemDao.addTbla(new Item("Василько"));
//            itemDao.addTbla(new Item("Вахтанг"));
//            itemDao.addTbla(new Item("Вацлав"));
//            itemDao.addTbla(new Item("Велимир"));
//            itemDao.addTbla(new Item("Велислав"));
//            itemDao.addTbla(new Item("Велор"));
//            itemDao.addTbla(new Item("Венедикт"));
//            itemDao.addTbla(new Item("Вениамин"));
//            itemDao.addTbla(new Item("Вергилий"));
//            itemDao.addTbla(new Item("Викентий"));
//            itemDao.addTbla(new Item("Виктор"));
//            itemDao.addTbla(new Item("Вилен"));
//            itemDao.addTbla(new Item("Вилий"));
//            itemDao.addTbla(new Item("Вилиор"));
//            itemDao.addTbla(new Item("Вилли"));
//            itemDao.addTbla(new Item("Вилор"));
//            itemDao.addTbla(new Item("Вилорг"));
//            itemDao.addTbla(new Item("Виль"));
//            itemDao.addTbla(new Item("Вильгельм"));
//            itemDao.addTbla(new Item("Вильям"));
//            itemDao.addTbla(new Item("Винцент"));
//            itemDao.addTbla(new Item("Виолен"));
//            itemDao.addTbla(new Item("Виссарион"));
//            itemDao.addTbla(new Item("Виталий"));
//            itemDao.addTbla(new Item("Витольд"));
//            itemDao.addTbla(new Item("Влад"));
//            itemDao.addTbla(new Item("Владелин"));
//            itemDao.addTbla(new Item("Владилен"));
//            itemDao.addTbla(new Item("Владимир"));
//            itemDao.addTbla(new Item("Владислав"));
//            itemDao.addTbla(new Item("Владлен"));
//            itemDao.addTbla(new Item("Влас"));
//            itemDao.addTbla(new Item("Воин"));
//            itemDao.addTbla(new Item("Воислав"));
//            itemDao.addTbla(new Item("Володар"));
//            itemDao.addTbla(new Item("Вольдемар"));
//            itemDao.addTbla(new Item("Вольмир"));
//            itemDao.addTbla(new Item("Вольт"));
//            itemDao.addTbla(new Item("Вольфрам"));
//            itemDao.addTbla(new Item("Всеволод"));
//            itemDao.addTbla(new Item("Всемил"));
//            itemDao.addTbla(new Item("Вячеслав"));
//
//            /*
//             * Female names
//             */
//            itemDao.addTblb(new Item("Авдотья"));
//            itemDao.addTblb(new Item("Агата"));
//            itemDao.addTblb(new Item("Аглая"));
//            itemDao.addTblb(new Item("Агния"));
//            itemDao.addTblb(new Item("Аделина"));
//            itemDao.addTblb(new Item("Аделаида"));
//            itemDao.addTblb(new Item("Аксинья"));
//            itemDao.addTblb(new Item("Акулина"));
//            itemDao.addTblb(new Item("Алевтина"));
//            itemDao.addTblb(new Item("Александра"));
//            itemDao.addTblb(new Item("Алиса"));
//            itemDao.addTblb(new Item("Алла"));
//            itemDao.addTblb(new Item("Анастасия"));
//            itemDao.addTblb(new Item("Ангелина"));
//            itemDao.addTblb(new Item("Анжела"));
//            itemDao.addTblb(new Item("Анжелика"));
//            itemDao.addTblb(new Item("Анисия"));
//            itemDao.addTblb(new Item("Анфиса"));
//            itemDao.addTblb(new Item("Ариана"));
//            itemDao.addTblb(new Item("Ася"));
//            itemDao.addTblb(new Item("Афанасия"));
//            itemDao.addTblb(new Item("Аэлита"));
//            itemDao.addTblb(new Item("Василина"));
//            itemDao.addTblb(new Item("Василиса"));
//            itemDao.addTblb(new Item("Весёна"));
//            itemDao.addTblb(new Item("Вероника"));
//            itemDao.addTblb(new Item("Галина"));
//            itemDao.addTblb(new Item("Георгина"));
//            itemDao.addTblb(new Item("Глафира"));
//            itemDao.addTblb(new Item("Гликерия"));
//            itemDao.addTblb(new Item("Дарья"));
//            itemDao.addTblb(new Item("Диана"));
//            itemDao.addTblb(new Item("Евангелина"));
//            itemDao.addTblb(new Item("Евгения"));
//            itemDao.addTblb(new Item("Евдокия"));
//            itemDao.addTblb(new Item("Евпраксия"));
//            itemDao.addTblb(new Item("Екатерина"));
//            itemDao.addTblb(new Item("Елена"));
//            itemDao.addTblb(new Item("Ефросиния"));
//            itemDao.addTblb(new Item("Зинаида"));
//            itemDao.addTblb(new Item("Зоя"));
//            itemDao.addTblb(new Item("Илона"));
//            itemDao.addTblb(new Item("Инесса"));
//            itemDao.addTblb(new Item("Ирина"));
//            itemDao.addTblb(new Item("Камилла"));
//            itemDao.addTblb(new Item("Кира"));
//            itemDao.addTblb(new Item("Ксения"));
//            itemDao.addTblb(new Item("Лариса"));
//            itemDao.addTblb(new Item("Лидия"));
//            itemDao.addTblb(new Item("Лика"));
//            itemDao.addTblb(new Item("Лина"));
//            itemDao.addTblb(new Item("Мелания"));
//            itemDao.addTblb(new Item("Нелли"));
//            itemDao.addTblb(new Item("Ника"));
//            itemDao.addTblb(new Item("Нина"));
//            itemDao.addTblb(new Item("Пелагея"));
//            itemDao.addTblb(new Item("Полина"));
//            itemDao.addTblb(new Item("Прасковья"));
//            itemDao.addTblb(new Item("Раиса"));
//            itemDao.addTblb(new Item("София"));
//            itemDao.addTblb(new Item("Степанида"));
//            itemDao.addTblb(new Item("Стефания"));
//            itemDao.addTblb(new Item("Стефанида"));
//            itemDao.addTblb(new Item("Таисия"));
//            itemDao.addTblb(new Item("Тамара"));
//            itemDao.addTblb(new Item("Феврония"));
//            itemDao.addTblb(new Item("Хавронья"));
//            itemDao.addTblb(new Item("Фёкла"));
//            itemDao.addTblb(new Item("Феодора"));
//            itemDao.addTblb(new Item("Феодосия"));
//            itemDao.addTblb(new Item("Элеонора"));
//            itemDao.addTblb(new Item("Элина"));
//            itemDao.addTblb(new Item("Элла"));
//            itemDao.addTblb(new Item("Эмилия"));
//            itemDao.addTblb(new Item("Эмма"));
//        }
//    }
//
//
//    static List<String> lJoin(List<Item> tblA, List<Item> tblB){
//        if (tblA==null)
//            return null;
//        else if (tblB==null)
//            return tblA.stream()
//                .map(i -> i.getId())
//                .collect(Collectors.toList());
//        return tblA.parallelStream()
//                .filter(i -> !tblB.contains(i))
//                .map(i -> i.getId())
//                .collect(Collectors.toList());
//    }
//
//    static List<String> rJoin(List<Item> tblA, List<Item> tblB){
//        if (tblB==null)
//            return null;
//        else if (tblA==null)
//            return tblB.stream()
//                    .map(i -> i.getId())
//                    .collect(Collectors.toList());
//        return tblB.parallelStream()
//                .filter(i -> !tblA.contains(i))
//                .map(i -> i.getId())
//                .collect(Collectors.toList());
//    }
//
//
//    static List<Item> leftJoin(List<Item> tblA, List<Item> tblB){
//        if (tblA==null)
//            return null;
//        else if (tblB==null)
//            return tblA;
//
//        List<Item> left = (ArrayList) ((ArrayList) tblA).clone();
//        return left.removeAll(tblB)
//                ? left
//                : null;
//    }
//
//    static List<Item> rightJoin(List<Item> tblA, List<Item> tblB){
//        if (tblB==null)
//            return null;
//        else if (tblA==null)
//            return tblB;
//
//        List<Item> right = (ArrayList) ((ArrayList) tblB).clone();
//        return right.removeAll(tblA)
//                ? right
//                : null;
//    }
//
//    static List<String> toIDs(List<Item> items){
//        return items.stream()
//                .map(i -> i.getId())
//                .collect(Collectors.toList());
//    }
//
//    static List<String> toWORDs(List<Item> items){
//        return items.stream()
//                .map(i -> i.getWord())
//                .collect(Collectors.toList());
//    }
//}
