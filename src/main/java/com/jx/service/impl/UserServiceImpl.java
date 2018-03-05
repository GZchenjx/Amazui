package com.jx.service.impl;

import com.jx.bean.User;
import com.jx.common.Pager;
import com.jx.dao.UserDAO;
import com.jx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/1/31.
 */
@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDAO userDAO;


    @Override
    public void save(Object obj) {
        userDAO.save(obj);
    }

    @Override
    public void remove(Object obj) {
        userDAO.remove(obj);
    }

    @Override
    public void removeById(Integer id) {
        userDAO.removeById(id);
    }

    @Override
    public void active(Integer id, Byte status) {
        userDAO.active(id,status);
    }

    @Override
    public void update(Object obj) {
        userDAO.update(obj);
    }

    @Override
    public Object getById(Integer id) {
        return userDAO.getById(id);
    }

    @Override
    public List<Object> listAll() {
        return userDAO.listAll();
    }

    @Override
    public Pager listPager(int pageNo, int pageSize) {
        Pager pager = new Pager();
        pager.setRows(userDAO.listPager(pager));
        pager.setTotal(userDAO.count());
        return null;
    }

    @Override
    public Pager listPagerCriteria(int pageNo, int pageSize, Object obj) {
        Pager pager = new Pager();
        pager.setRows(userDAO.listPagerCriteria(pager,obj));
        pager.setTotal(userDAO.countCriteria(obj));
        return pager;
    }

    @Override
    public User getByEmailPwd(String email, String pwd) {
        return userDAO.getByEmailPwd(email,pwd);
    }
}
