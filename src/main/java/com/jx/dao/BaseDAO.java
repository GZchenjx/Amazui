package com.jx.dao;

import com.jx.common.Pager;

import java.util.List;

/**
 * Created by Administrator on 2018/1/31.
 */
public interface BaseDAO {


    void save( Object obj);
    void remove(Object obj);
    void removeById(Integer id);
    void active(Integer id, Byte status);
    void update(Object obj);

    Object getById(Integer id);
    List<Object> listAll();
    List<Object> listPager(Pager pager);
    Long count();
    List<Object> listPagerCriteria(Pager pager, Object obj);
    Long countCriteria(Object obj);

}
