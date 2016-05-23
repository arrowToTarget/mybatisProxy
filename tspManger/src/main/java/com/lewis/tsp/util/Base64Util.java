package com.lewis.tsp.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

public final class Base64Util {

    private Base64Util(){}

    public static String encode(String str){
        try {
            if (StringUtils.isNotEmpty(str)) {
                return new String(Base64.encodeBase64(str.getBytes()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decode(String str){
        try {
            if (StringUtils.isNotEmpty(str)) {
                return new String(Base64.decodeBase64(str.getBytes()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
