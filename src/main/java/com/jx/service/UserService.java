package com.jx.service;

import com.jx.bean.User;

/**
 * Created by Administrator on 2018/1/31.
 */
public interface UserService extends BaseService{

    User getByEmailPwd(String email, String pwd);
}
