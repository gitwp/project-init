package com.wangp.stock.util;

import com.google.gson.Gson;

/**
 * @author 2016/5/25 wangp
 */
public class GsonUtil {
    private static Gson gson = new Gson();

    public static String Obj2Json(Object obj){
        return gson.toJson(obj);
    }
}
