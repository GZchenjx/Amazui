package com.jx.dao;


import com.jx.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/1/31.
 */
@Repository
public interface UserDAO extends BaseDAO{

    User getByEmailPwd(@Param("email") String email,@Param("pwd") String pwd);
}
