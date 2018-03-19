package com.jx.controller;

import com.alibaba.fastjson.JSONObject;
import com.jx.bean.User;
import com.jx.common.Constant;
import com.jx.common.FileUtil;
import com.jx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/19.
 */
@Controller
@RequestMapping("/imageUpload")
public class ImageUploadController {
    @Autowired
    private UserService userService;

    @RequestMapping("updateHeadImg/{id}")
    @ResponseBody
    public String updateHeadImg(@PathVariable("id")Integer id, MultipartFile file){
        User user = new User();
        user.setId(id);
        String status= null;
        Map<String,Object> map = new HashMap<>();
        if (file != null) {
            try {
                String imgPath = FileUtil.updateImg();
                file.transferTo(new File(imgPath,file.getOriginalFilename()));
                user.setHeadImage(Constant.IMAGE_PATH + file.getOriginalFilename());
                userService.updateImage(user);

                //0表示成功，1失败
                map.put("code",0);
                map.put("msg","static/uploads/img" + file.getOriginalFilename());
                status = new JSONObject(map).toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return status;
    }
}
