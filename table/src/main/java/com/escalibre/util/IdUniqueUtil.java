package com.escalibre.util;

import java.util.UUID;

public class IdUniqueUtil {

    public static String getUniqueId(){
        return UUID.randomUUID().toString();
    }
}
