package com.jx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018/1/31.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
