package com.escalibre.util;

import java.util.UUID;

public class IdGeneratorUtil {

    public static String getUniqueId(){
        return UUID.randomUUID().toString();
    }
}
