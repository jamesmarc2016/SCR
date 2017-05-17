package com.tangxinhui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xinhu on 2017/5/10.
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/index")
    public String index(){
        System.out.println("====index==");
        return "index";
    }
}
