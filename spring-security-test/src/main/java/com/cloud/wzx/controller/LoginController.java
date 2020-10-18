package com.cloud.wzx.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

    @RequestMapping(value = "/login-success",produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String  loginSuccess(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return name+"登陆成功";
    }

    @RequestMapping(value = "/res/text",produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String  loginSuccess2(){
        return "text";
    }

    @RequestMapping(value = "/res/image",produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String  loginSuccess3(){
        return "image";
    }

    @RequestMapping(value = "/login-view",produces = {"text/plain;charset=UTF-8"})
    public String loginView(){
        return "login";
    }

}
