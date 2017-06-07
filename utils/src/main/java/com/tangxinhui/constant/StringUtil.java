package com.tangxinhui.constant;

import java.util.UUID;

/**
 *
 */
public class StringUtil {
    public static String getUuid(){
        return UUID.randomUUID().toString().trim().replaceAll("-", "").toLowerCase();
    }
}
