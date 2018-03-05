package com.jx.service;

import com.jx.common.Pager;

import java.util.List;

/**
 * Created by Administrator on 2018/1/31.
 */
public interface BaseService {

    void save(Object obj);
    void remove(Object obj);
    void removeById(Integer id);
    void active(Integer id, Byte status);
    void update(Object obj);

    Object getById(Integer id);
    List<Object> listAll();
    Pager listPager(int pageNo, int pageSize);

    Pager listPagerCriteria(int pageNo, int pageSize, Object obj);
}
