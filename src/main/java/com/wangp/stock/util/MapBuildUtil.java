package com.wangp.stock.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 2016/5/25 wangp
 */
public class MapBuildUtil {

    public static Map<String,Object> build(Object... objs){
        Map<String,Object> map = new HashMap<String, Object>();
        for(int i=0;i<objs.length;i=i+2){
            map.put(objs[i].toString(),objs[i+1]);
        }
        return map;
    }
}
