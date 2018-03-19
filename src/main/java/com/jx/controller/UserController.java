package com.jx.controller;

import com.jx.bean.User;
import com.jx.common.Constants;
import com.jx.common.EncryptUtils;
import com.jx.enums.ControllerEnums;
import com.jx.service.UserService;
import com.jx.vo.ControllerStatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/1/31.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    @ResponseBody
    public ControllerStatusVo login(HttpSession session, String email, String pwd) {
        ControllerStatusVo statusVo = null;
        User user = userService.getByEmailPwd(email, EncryptUtils.md5(pwd));
        if (user != null) {
            session.setAttribute(Constants.USER_IN_SESSION, user);
            statusVo = ControllerStatusVo.statusVo(ControllerEnums.USER_LOGIN_SUCCESS);
        } else {
            statusVo = ControllerStatusVo.statusVo((ControllerEnums.USER_LOGIN_FAIL));
        }
        return statusVo;

    }

    @RequestMapping("admin_home")
    public String home() {
        return "admin/admin_home";
    }

    @RequestMapping("admin_user")
    public String admin_user() {
        return "admin/admin_user";
    }

    @RequestMapping("admin_help")
    public String admin_help() {
        return "admin/admin_help";
    }

    @RequestMapping("admin_gallery")
    public String admin_gallery() {
        return "admin/admin_gallery";
    }

    @RequestMapping("admin_log")
    public String admin_log() {
        return "admin/admin_log";
    }

    @RequestMapping("admin_404")
    public String admin_404() {
        return "admin/admin_404";
    }

    @RequestMapping("admin_table")
    public String admin_table() {
        return "admin/admin_table";
    }

    @RequestMapping("admin_form")
    public String admin_form() {
        return "admin/admin_form";
    }

    @RequestMapping("admin_information")
    public String information() {
        return "admin/admin_information";
    }

    @RequestMapping("test")
    public String test() {
        return "admin/test";
    }

    @RequestMapping("getById/{id}")
    @ResponseBody
    public User getById(@PathVariable("id") Integer id) {

        User user = (User) userService.getById(id);
        return user;
    }
    @RequestMapping("listAll")
    @ResponseBody
    public List<Object> listAll() {
        List<Object> objects = userService.listAll();
        return objects;
    }
  /*  @RequestMapping("update")
    @ResponseBody
    public ControllerStatusVo update(HttpSession session,User user) {
        User user1 = (User) session.getAttribute(Constants.USER_IN_SESSION);
        user.setId(user1.getId());
        ControllerStatusVo statusVo = null;
        if (user1 != null) {
            userService.update(user);
            statusVo = ControllerStatusVo.statusVo(ControllerEnums.USER_UPDATE_SUCCESS);
        } else {
            statusVo = ControllerStatusVo.statusVo(ControllerEnums.USER_UPDATE_FAIL);
        }
        return statusVo;
    }*/

   /* @RequestMapping("update/{id}")
    @ResponseBody
    public ControllerStatusVo update(User user) {
        ControllerStatusVo statusVo = null;

        try {
            userService.update(user);
        } catch (RuntimeException e) {
            statusVo = ControllerStatusVo.statusVo(ControllerEnums.USER_UPDATE_FAIL);
        }
        statusVo = ControllerStatusVo.statusVo(ControllerEnums.USER_UPDATE_SUCCESS);
        return  statusVo;
    }*/

   @RequestMapping("excel")
   public String excel() {
       return "admin/excel";
   }
   @RequestMapping("update")
   @ResponseBody
   public ControllerStatusVo update(HttpSession session,User user) {
       User user1 = (User) session.getAttribute(Constants.USER_IN_SESSION);
       user.setId(user1.getId());
       ControllerStatusVo statusVo = null;
       if (user1 != null) {
           userService.update(user);
           statusVo = ControllerStatusVo.statusVo(ControllerEnums.USER_UPDATE_SUCCESS);
       } else {
           statusVo = ControllerStatusVo.statusVo(ControllerEnums.USER_UPDATE_FAIL);
       }
       return statusVo;


   }


    @RequestMapping("updateImage")
    public String updateImage() {
       return "admin/updateImage";
    }

}
