package com.ztt.controller;

import com.ztt.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestScope;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestParamController {
    @RequestMapping("/param/servletAPI")
    public String getParamByServletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+password);
        return "success";
    }
    @RequestMapping("/param")
    public String getParam(@RequestParam(value = "userName",defaultValue = "hello") String username,
                           String password,
                           @RequestHeader("referer") String referer,
                           @CookieValue("JSESSIONID") String cookie
    ){

        System.out.println(username+password+"\n"+referer);
        return "success";
    }
    @RequestMapping("/param/pojo")
    public String getParamPojo(User user){
        System.out.println(user);
        return "success";
    }
}
