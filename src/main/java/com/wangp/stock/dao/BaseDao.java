package com.wangp.stock.dao;

import java.util.List;
import java.util.Map;

/**
 * @author 2016/5/24 wangp
 */
public interface BaseDao<T> {
    void insert(T dto);
    int update(T dto);
    List<T> queryList(Map map);
}
